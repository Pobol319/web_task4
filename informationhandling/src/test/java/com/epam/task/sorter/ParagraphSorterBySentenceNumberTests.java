package com.epam.task.sorter;

import com.epam.task.component.Component;
import com.epam.task.component.Composite;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ParagraphSorterBySentenceNumberTests {
    private static final int FIRST = 0;
    private static final int SECOND = 1;

    @Test
    public void testSortShouldReturnSortedParagraphsWhenFirstParagraphHasMoreSentences() {
        Component firstSentenceComponent = new Composite();
        Component secondSentenceComponent = new Composite();
        Composite firstParagraphComposite = new Composite();
        firstParagraphComposite.add(firstSentenceComponent);
        firstParagraphComposite.add(secondSentenceComponent);

        Component thirdSentenceComponent = new Composite();
        Composite secondParagraphComposite = new Composite();
        secondParagraphComposite.add(thirdSentenceComponent);

        List<Component> unsorted = Arrays.asList(
                firstParagraphComposite,
                secondParagraphComposite
        );

        Sorter<Component> sorter = new ParagraphSorterBySentenceNumber();

        List<Component> sorted = sorter.sort(unsorted);

        Component firstSecondComposite = sorted.get(FIRST);
        Assert.assertEquals(secondParagraphComposite, firstSecondComposite);

        Component secondSortedComposite = sorted.get(SECOND);
        Assert.assertEquals(firstParagraphComposite, secondSortedComposite);
    }
}
