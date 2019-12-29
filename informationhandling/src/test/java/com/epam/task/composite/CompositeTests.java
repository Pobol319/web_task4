package com.epam.task.composite;

import com.epam.task.component.Component;
import com.epam.task.component.Composite;
import com.epam.task.exception.ComponentException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CompositeTests {
    private static final int FIRST = 0;

    @Test
    public void testAddShouldAddNewComponentToCompositeListWhenGivenComponent() throws ComponentException {
        //given
        Component component = new Composite();
        Component givenComponent = new Composite();
        component.add(givenComponent);
        List<Component> children = component.getChild();
        //when
        Component child = children.get(FIRST);
        //then
        Assert.assertEquals(Composite.class, child.getClass());
    }


}
