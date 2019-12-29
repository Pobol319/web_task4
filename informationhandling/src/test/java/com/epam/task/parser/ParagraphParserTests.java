package com.epam.task.parser;

import com.epam.task.component.Component;
import com.epam.task.component.Composite;
import com.epam.task.exception.ComponentException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class ParagraphParserTests {
    private static final String PARAGRAPH_WITH_ONE_SENTENCE = "\tFirst sentence.";
    private static final String PARAGRAPH_WITH_TWO_SENTENCES = "\tFirst sentence. Second sentence.";

    private static final int ONE_ELEMENT = 1;
    private static final int TWO_ELEMENTS = 2;


    @Test
    public void testParseShouldReturnParagraphCompositeWithOneSentence() throws ComponentException {
        //given
        TextParser sentenceParser = mock(SentenceParser.class);
        ParagraphParser paragraphParser = new ParagraphParser();
        paragraphParser.setSuccessor(sentenceParser);
        //when
        Component paragraphComposite = paragraphParser.parse(PARAGRAPH_WITH_ONE_SENTENCE);
        List<Component> sentenceComposites = paragraphComposite.getChild();
        //then
        Assert.assertEquals(Composite.class, paragraphComposite.getClass());
        Assert.assertEquals(ONE_ELEMENT, sentenceComposites.size());
    }

    @Test
    public void testParserShouldReturnParagraphCompositeWithTwoSentence() throws ComponentException {
        //given
        TextParser sentenceParser = mock(ParagraphParser.class);
        ParagraphParser paragraphParser = new ParagraphParser();
        paragraphParser.setSuccessor(sentenceParser);
        //when
        Component paragraphComposite = paragraphParser.parse(PARAGRAPH_WITH_TWO_SENTENCES);
        List<Component> sentenceComposites = paragraphComposite.getChild();
        //then
        Assert.assertEquals(Composite.class, paragraphComposite.getClass());
        Assert.assertEquals(TWO_ELEMENTS, sentenceComposites.size());
    }
}
