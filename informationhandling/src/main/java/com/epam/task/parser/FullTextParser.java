package com.epam.task.parser;

import com.epam.task.component.Component;
import com.epam.task.component.Composite;
import com.epam.task.exception.ComponentException;

public class FullTextParser extends AbstractParser {
    private static final String FULL_TEXT_REG_EXP = "   ";

    @Override
    public Component parse(String text) throws ComponentException {
        String[] strings = text.split(FULL_TEXT_REG_EXP);

        TextParser successor = getSuccessor();

        Component compositeText = new Composite();
        for (String s : strings) {
            Component component = successor.parse(s);
            compositeText.add(component);
        }

        return compositeText;
    }
}
