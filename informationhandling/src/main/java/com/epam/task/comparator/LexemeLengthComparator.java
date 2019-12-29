package com.epam.task.comparator;

import com.epam.task.component.Component;
import com.epam.task.component.Lexeme;

import java.util.Comparator;

public class LexemeLengthComparator implements Comparator<Component> {

    @Override
    public int compare(Component component1, Component component2) {
        Lexeme lexeme1 = (Lexeme) component1;
        Lexeme lexeme2 = (Lexeme) component2;

        String lexemeValue1 = lexeme1.getValue();
        String lexemeValue2 = lexeme2.getValue();

        return lexemeValue1.length() - lexemeValue2.length();
    }
}