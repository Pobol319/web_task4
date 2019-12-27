package com.epam.task.parser;

import com.epam.task.component.Component;
import com.epam.task.exception.ComponentException;

public interface TextParser {
    Component parse(String text) throws ComponentException;
}
