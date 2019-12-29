package com.epam.task.parser;

import com.epam.task.component.Component;
import com.epam.task.component.Composite;
import com.epam.task.exception.ComponentException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class FullTextParserTest {
    private static final String TEXT_WITH_ONE_PARAGRAPH = "\tFirst paragraph.";
    private static final String TEXT_WITH_TWO_PARAGRAPHS = "\tFirst paragraph.   \tSecond paragraph.";

    private static final int ONE_ELEMENT = 1;
    private static final int TWO_ELEMENTS = 2;


    @Test
    public void testParserShouldReturnTextCompositeWithOneParagraph() throws ComponentException {
        //given
        TextParser paragraphParser = mock(ParagraphParser.class);
        FullTextParser textParser = new FullTextParser();
        textParser.setSuccessor(paragraphParser);
        //when
        Component textComposite = textParser.parse(TEXT_WITH_ONE_PARAGRAPH);
        List<Component> paragraphComposites = textComposite.getChild();
        //then
        Assert.assertEquals(Composite.class, textComposite.getClass());
        Assert.assertEquals(ONE_ELEMENT, paragraphComposites.size());
    }

    @Test
    public void testParserShouldReturnTextCompositeWithTwoParagraphs() throws ComponentException {
        //given
        TextParser paragraphParser = mock(ParagraphParser.class);
        FullTextParser textParser = new FullTextParser();
        textParser.setSuccessor(paragraphParser);
        //when
        Component textComposite = textParser.parse(TEXT_WITH_TWO_PARAGRAPHS);
        List<Component> paragraphComposites = textComposite.getChild();
        //then
        Assert.assertEquals(Composite.class, textComposite.getClass());
        Assert.assertEquals(TWO_ELEMENTS, paragraphComposites.size());
    }
}
