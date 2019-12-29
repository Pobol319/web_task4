package com.epam.task.comparator;

import com.epam.task.component.Lexeme;

import java.util.Comparator;

public class LexemeLengthComparator implements Comparator<Lexeme> {

    @Override
    public int compare(Lexeme lexeme1, Lexeme lexeme2) {
        String lexemeValue1 = lexeme1.getValue();
        String lexemeValue2 = lexeme2.getValue();

        return lexemeValue1.length() - lexemeValue2.length();
    }
}