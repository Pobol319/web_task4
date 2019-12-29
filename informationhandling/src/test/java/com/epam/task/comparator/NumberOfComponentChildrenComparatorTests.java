package com.epam.task.comparator;

import com.epam.task.component.Component;
import com.epam.task.component.Composite;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

public class NumberOfComponentChildrenComparatorTests {
    private static final int ZERO = 0;

    @Test
    public void testCompareShouldReturnPositiveIntegerWhenFirstCompositeHasMoreChildren() {
        //given
        Component firstComponent = new Composite();
        Component secondComponent = new Composite();
        Composite firstComposite = new Composite();
        firstComposite.add(firstComponent);
        firstComposite.add(secondComponent);

        Component thirdComponent = new Composite();
        Composite secondComposite = new Composite();
        secondComposite.add(thirdComponent);

        Comparator<Component> comparator = new NumberOfComponentChildrenComparator();
        //when
        int actual = comparator.compare(firstComposite, secondComposite);
        //then
        Assert.assertTrue(actual > ZERO);
    }

    @Test
    public void testCompareShouldReturnNegativeIntegerWhenFirstCompositeHasLessChildren() {
        //given
        Component firstComponent = new Composite();
        Composite firstComposite = new Composite();
        firstComposite.add(firstComponent);

        Component secondComponent = new Composite();
        Component thirdComponent = new Composite();
        Composite secondComposite = new Composite();
        secondComposite.add(secondComponent);
        secondComposite.add(thirdComponent);

        Comparator<Component> comparator = new NumberOfComponentChildrenComparator();
        //when
        int actual = comparator.compare(firstComposite, secondComposite);
        //then
        Assert.assertTrue(actual < ZERO);
    }

    @Test
    public void testCompareShouldReturnZeroWhenCompositesHaveEqualNumberOfChildren() {
        //given
        Component firstComponent = new Composite();
        Composite firstComposite = new Composite();
        firstComposite.add(firstComponent);

        Component secondComponent = new Composite();
        Composite secondComposite = new Composite();
        secondComposite.add(secondComponent);

        Comparator<Component> comparator = new NumberOfComponentChildrenComparator();
        //when
        int actual = comparator.compare(firstComposite, secondComposite);
        //then
        Assert.assertEquals(ZERO, actual);
    }
}
