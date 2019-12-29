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
        Component firstComponent = new Composite();
        Component secondComponent = new Composite();
        Composite firstComposite = new Composite();
        firstComposite.add(firstComponent);
        firstComposite.add(secondComponent);

        Component thirdComponent = new Composite();
        Composite secondComposite = new Composite();
        secondComposite.add(thirdComponent);

        Comparator<Component> comparator = new NumberOfComponentChildrenComparator();

        int actual = comparator.compare(firstComposite, secondComposite);

        Assert.assertTrue(actual > ZERO);
    }

    @Test
    public void testCompareShouldReturnNegativeIntegerWhenFirstCompositeHasLessChildren() {
        Component firstComponent = new Composite();
        Composite firstComposite = new Composite();
        firstComposite.add(firstComponent);

        Component secondComponent = new Composite();
        Component thirdComponent = new Composite();
        Composite secondComposite = new Composite();
        secondComposite.add(secondComponent);
        secondComposite.add(thirdComponent);

        Comparator<Component> comparator = new NumberOfComponentChildrenComparator();

        int actual = comparator.compare(firstComposite, secondComposite);

        Assert.assertTrue(actual < ZERO);
    }

    @Test
    public void testCompareShouldReturnZeroWhenCompositesHaveEqualNumberOfChildren() {
        Component firstComponent = new Composite();
        Composite firstComposite = new Composite();
        firstComposite.add(firstComponent);

        Component secondComponent = new Composite();
        Composite secondComposite = new Composite();
        secondComposite.add(secondComponent);

        Comparator<Component> comparator = new NumberOfComponentChildrenComparator();

        int actual = comparator.compare(firstComposite, secondComposite);

        Assert.assertEquals(ZERO, actual);
    }
}
