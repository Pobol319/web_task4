package com.epam.task.parser;

import com.epam.task.component.Component;
import com.epam.task.component.Composite;
import com.epam.task.exception.ComponentException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;

public class SentenceParserTests {
    private static final String SENTENCE_WITH_WORD_AND_DOT = "Word.";
    private static final String SENTENCE_WITH_EXPRESSION_AND_DOT = "12_13_14+-.";
    private static final String SENTENCE_WITH_WORD_EXPRESSION_AND_DOT = "Word 12_13_14+-.";

    private static final int TWO_ELEMENTS = 2;
    private static final int THREE_ELEMENTS = 3;


    @Test
    public void testParseShouldReturnSentenceCompositeWithTwoWordLexemesWhenSentenceHasWordAndDot() throws ComponentException {
        //given
        TextParser lexemeParser = mock(LexemeParser.class);
        SentenceParser sentenceParser = new SentenceParser();
        sentenceParser.setSuccessor(lexemeParser);
        //when
        Component sentenceComposite = sentenceParser.parse(SENTENCE_WITH_WORD_AND_DOT);
        List<Component> wordLexemes = sentenceComposite.getChild();
        //then
        Assert.assertEquals(Composite.class, sentenceComposite.getClass());
        Assert.assertEquals(TWO_ELEMENTS, wordLexemes.size());
    }

    @Test
    public void testParseShouldReturnSentenceCompositeWithOneExpressionAndOneWordLexemesWhenSentenceHasExpressionAndDot() throws ComponentException {
        //given
        TextParser lexemeParser = mock(LexemeParser.class);
        SentenceParser sentenceParser = new SentenceParser();
        sentenceParser.setSuccessor(lexemeParser);
        //when
        Component sentenceComposite = sentenceParser.parse(SENTENCE_WITH_EXPRESSION_AND_DOT);
        List<Component> lexemes = sentenceComposite.getChild();
        //then
        Assert.assertEquals(Composite.class, sentenceComposite.getClass());
        Assert.assertEquals(TWO_ELEMENTS, lexemes.size());
    }

    @Test
    public void testParseShouldReturnSentenceCompositeWithOneExpressionAndTwoWordLexemesWhenSentenceHasWordExpressionAndDot() throws ComponentException {
        //given
        TextParser lexemeParser = mock(LexemeParser.class);
        SentenceParser sentenceParser = new SentenceParser();
        sentenceParser.setSuccessor(lexemeParser);
        //when
        Component sentenceComposite = sentenceParser.parse(SENTENCE_WITH_WORD_EXPRESSION_AND_DOT);
        List<Component> lexemes = sentenceComposite.getChild();
        //then
        Assert.assertEquals(Composite.class, sentenceComposite.getClass());
        Assert.assertEquals(THREE_ELEMENTS, lexemes.size());
    }
}
