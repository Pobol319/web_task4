package com.epam.task.recovery;

import com.epam.task.component.Component;
import com.epam.task.component.Composite;
import com.epam.task.component.Lexeme;
import com.epam.task.exception.ComponentException;
import com.epam.task.exception.InvalidExpressionParserException;
import com.epam.task.exception.InvalidExpressionTextException;
import com.epam.task.interpreter.ArithmeticExpressionInterpreter;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class TextRecoveryExecutorTests {
    private static final String WORD_LEXEME_VALUE = "First";
    private static final String POINT_LEXEME_VALUE = ".";

    private static final String ONE_PARAGRAPH_TEXT = "First . ";

    @Test
    public void testExecuteRecoveryShouldReturnOneParagraphTextWhenGivenTextCompositeWithOneChild()
            throws ComponentException, InvalidExpressionTextException, InvalidExpressionParserException {
        //given
        ArithmeticExpressionInterpreter interpreter = mock(ArithmeticExpressionInterpreter.class);
        Component firstWordLexeme = Lexeme.word(WORD_LEXEME_VALUE);
        Component secondWordLexeme = Lexeme.word(POINT_LEXEME_VALUE);

        Component sentenceComposite = new Composite();
        sentenceComposite.add(firstWordLexeme);
        sentenceComposite.add(secondWordLexeme);

        Component paragraphComposite = new Composite();
        paragraphComposite.add(sentenceComposite);

        Component textComposite = new Composite();
        textComposite.add(paragraphComposite);

        TextRecoveryExecutor recoveryExecutor = new TextRecoveryExecutor(interpreter);
        //when
        String actual = recoveryExecutor.executeRecovery(textComposite);
        //then
        Assert.assertEquals(ONE_PARAGRAPH_TEXT, actual);
    }


    @Test(expected = NullPointerException.class)
    public void testExecuteRecoveryShouldThrowNullPointerException() throws ComponentException, InvalidExpressionTextException, InvalidExpressionParserException {
        //given
        ArithmeticExpressionInterpreter interpreter = mock(ArithmeticExpressionInterpreter.class);
        Component firstWordLexeme = Lexeme.word(WORD_LEXEME_VALUE);

        TextRecoveryExecutor recoveryExecutor = new TextRecoveryExecutor(interpreter);
        //when
        recoveryExecutor.executeRecovery(firstWordLexeme);
        //then
        Assert.fail();
    }

}
