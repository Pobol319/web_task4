package com.epam.task.sorter;

import com.epam.task.component.Component;
import com.epam.task.component.Lexeme;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class WordSorterByLengthTests {
    private static final String LONGER_VALUE = "LongerLongerLonger";
    private static final String SHORTER_VALUE = "S";

    private static final int FIRST = 0;
    private static final int SECOND = 1;

    @Test
    public void testSortShouldReturnSortedWordsWhenFirstWordLonger() {
        List<Component> unsorted = Arrays.asList(
                Lexeme.word(LONGER_VALUE),
                Lexeme.word(SHORTER_VALUE)
        );

        WordSorterByLength sorter = new WordSorterByLength();

        List<Component> sorted = sorter.sort(unsorted);

        Component firstLexeme = sorted.get(FIRST);
        Assert.assertEquals(SHORTER_VALUE, ((Lexeme) firstLexeme).getValue());

        Component secondLexeme = sorted.get(SECOND);
        Assert.assertEquals(LONGER_VALUE, ((Lexeme) secondLexeme).getValue());
    }
}
