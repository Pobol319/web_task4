package com.epam.task.parser;

import com.epam.task.component.Component;
import com.epam.task.component.Lexeme;
import com.epam.task.exception.ComponentException;
import org.junit.Assert;
import org.junit.Test;

public class LexemeParserTests {
    private static final String WORD = "Hello";
    private static final String EXPRESSION = "[12_13_14+-]";
    private static final String PUNCTUATION_MARK = "!";

    @Test
    public void testParseShouldReturnLexemeWordType() throws ComponentException {
        //given
        TextParser parser = new LexemeParser();
        Component wordComponent = parser.parse(WORD);
        //when
        Lexeme wordLexeme = (Lexeme) wordComponent;
        //then
        Assert.assertTrue(wordLexeme.isWord());
    }

    @Test
    public void testParseShouldReturnLexemeExpressionType() throws ComponentException {
        //given
        TextParser parser = new LexemeParser();
        Component wordComponent = parser.parse(EXPRESSION);
        //when
        Lexeme wordLexeme = (Lexeme) wordComponent;
        //then
        Assert.assertTrue(wordLexeme.isExpression());
    }

    @Test
    public void testParseShouldReturnLexemePunctuationMarkType() throws ComponentException {
        //given
        TextParser parser = new LexemeParser();
        Component wordComponent = parser.parse(PUNCTUATION_MARK);
        //when
        Lexeme wordLexeme = (Lexeme) wordComponent;
        //then
        Assert.assertTrue(wordLexeme.isPunctuationMark());
    }
}
