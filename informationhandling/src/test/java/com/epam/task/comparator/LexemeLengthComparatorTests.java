package com.epam.task.comparator;

import com.epam.task.component.Component;
import com.epam.task.component.Lexeme;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

public class LexemeLengthComparatorTests {
    private static final int ZERO = 0;
    private static final String LONGER_VALUE = "LongerLongerLonger";
    private static final String SHORTER_VALUE = "S";

    @Test
    public void testCompareShouldReturnPositiveIntegerWhenFirstLexemeLonger() {
        //given
        Lexeme firstLexeme = Lexeme.word(LONGER_VALUE);
        Lexeme secondLexeme = Lexeme.word(SHORTER_VALUE);

        Comparator<Component> comparator = new LexemeLengthComparator();
        //when
        int actual = comparator.compare(firstLexeme, secondLexeme);
        //then
        Assert.assertTrue(actual > ZERO);
    }

    @Test
    public void testCompareShouldReturnNegativeIntegerWhenFirstLexemeShorter() {
        //given
        Lexeme firstLexeme = Lexeme.word(SHORTER_VALUE);
        Lexeme secondLexeme = Lexeme.word(LONGER_VALUE);

        Comparator<Component> comparator = new LexemeLengthComparator();
        //when
        int actual = comparator.compare(firstLexeme, secondLexeme);
        //then
        Assert.assertTrue(actual < ZERO);
    }

    @Test
    public void testCompareShouldReturnZeroWhenLexemesHaveEqualLength() {
        //given
        Lexeme firstLexeme = Lexeme.word(SHORTER_VALUE);
        Lexeme secondLexeme = Lexeme.word(SHORTER_VALUE);

        Comparator<Component> comparator = new LexemeLengthComparator();
        //when
        int actual = comparator.compare(firstLexeme, secondLexeme);
        //then
        Assert.assertEquals(ZERO, actual);
    }
}
