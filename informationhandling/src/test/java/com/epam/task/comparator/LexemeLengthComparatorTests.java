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
        Lexeme firstLexeme = Lexeme.word(LONGER_VALUE);
        Lexeme secondLexeme = Lexeme.word(SHORTER_VALUE);

        Comparator<Component> comparator = new LexemeLengthComparator();

        int actual = comparator.compare(firstLexeme, secondLexeme);

        Assert.assertTrue(actual > ZERO);
    }

    @Test
    public void testCompareShouldReturnNegativeIntegerWhenFirstLexemeShorter() {
        Lexeme firstLexeme = Lexeme.word(SHORTER_VALUE);
        Lexeme secondLexeme = Lexeme.word(LONGER_VALUE);

        Comparator<Component> comparator = new LexemeLengthComparator();

        int actual = comparator.compare(firstLexeme, secondLexeme);

        Assert.assertTrue(actual < ZERO);
    }

    @Test
    public void testCompareShouldReturnZeroWhenLexemesHaveEqualLength() {
        Lexeme firstLexeme = Lexeme.word(SHORTER_VALUE);
        Lexeme secondLexeme = Lexeme.word(SHORTER_VALUE);

        Comparator<Component> comparator = new LexemeLengthComparator();

        int actual = comparator.compare(firstLexeme, secondLexeme);

        Assert.assertEquals(ZERO, actual);
    }
}
