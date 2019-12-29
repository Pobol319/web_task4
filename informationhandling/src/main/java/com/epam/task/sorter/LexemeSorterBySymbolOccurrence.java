package com.epam.task.sorter;

import com.epam.task.comparator.LexemeSymbolOccurrenceComparator;
import com.epam.task.component.Lexeme;

import java.util.ArrayList;
import java.util.List;

public class LexemeSorterBySymbolOccurrence implements Sorter<Lexeme> {
    private String desiredSymbol;

    public LexemeSorterBySymbolOccurrence(String desiredSymbol) {
        this.desiredSymbol = desiredSymbol;
    }

    @Override
    public List<Lexeme> sort(List<Lexeme> lexemes) {
        List<Lexeme> sortable = new ArrayList<>(lexemes);

        lexemes.sort(new LexemeSymbolOccurrenceComparator(desiredSymbol));

        return sortable;
    }
}
