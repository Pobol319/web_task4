package com.epam.task.component;

import com.epam.task.exception.ComponentException;

import java.util.List;

public interface Component {
    void add(Component component) throws ComponentException;
    void remove(Component component) throws ComponentException;
    List<Component> getChild() throws ComponentException;
}
