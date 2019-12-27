package com.epam.task.parser;

import com.epam.task.component.Component;
import com.epam.task.exception.ComponentException;

public class ParagraphParser extends AbstractParser {
    private static final String PARAGRAPH_REG_EXP = "[^\\t\\s.?!][^.?!]*(\\.{3}|\\.|\\?|!)";

    @Override
    public Component parse(String text) throws ComponentException {
        return findAllComponents(text, PARAGRAPH_REG_EXP);
    }
}
