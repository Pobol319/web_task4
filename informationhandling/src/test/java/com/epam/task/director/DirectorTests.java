package com.epam.task.director;

import com.epam.task.chain_responsibility.ParserChainBuilder;
import com.epam.task.component.Component;
import com.epam.task.component.Composite;
import com.epam.task.exception.ComponentException;
import com.epam.task.exception.InformationTextReaderException;
import com.epam.task.exception.InvalidExpressionParserException;
import com.epam.task.exception.InvalidExpressionTextException;
import com.epam.task.parser.TextParser;
import com.epam.task.reader.InformationTextReader;
import com.epam.task.recovery.TextRecoveryExecutor;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class DirectorTests {
    private static final String VALID_PATH = "src/test/resources/one_paragraph.txt";
    private static final String TEXT = "\tOne paragraph.";


    @Test
    public void testHandleInformationShouldReturnSameTextWhenGivenText() throws InformationTextReaderException, ComponentException, InvalidExpressionTextException, InvalidExpressionParserException {
        InformationTextReader reader = mock(InformationTextReader.class);
        when(reader.read(VALID_PATH)).thenReturn(TEXT);

        Component textComposite = new Composite();

        TextParser textParser = mock(TextParser.class);
        when(textParser.parse(TEXT)).thenReturn(textComposite);

        ParserChainBuilder parserBuilder = mock(ParserChainBuilder.class);
        when(parserBuilder.build()).thenReturn(textParser);

        TextRecoveryExecutor recoveryExecutor = mock(TextRecoveryExecutor.class);
        when(recoveryExecutor.executeRecovery(textComposite)).thenReturn(TEXT);

        Director director = new Director(reader, parserBuilder, recoveryExecutor);

        String actual = director.handleInformation(VALID_PATH);

        Assert.assertEquals(TEXT, actual);

        verify(reader, atLeastOnce()).read(VALID_PATH);
        verify(parserBuilder, atLeastOnce()).build();
        verify(textParser, atLeastOnce()).parse(TEXT);
        verify(recoveryExecutor, atLeastOnce()).executeRecovery(textComposite);
    }
}
