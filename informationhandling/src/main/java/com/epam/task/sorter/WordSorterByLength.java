package com.epam.task.sorter;

import com.epam.task.comparator.LexemeLengthComparator;
import com.epam.task.component.Component;
import com.epam.task.component.Lexeme;

import java.util.ArrayList;
import java.util.List;

public class WordSorterByLength implements Sorter<Component> {

    @Override
    public List<Component> sort(List<Component> components) {
        List<Component> sortable = new ArrayList<>();

        for (Component component : components) {
            Lexeme lexeme = (Lexeme) component;
            if (lexeme.isWord()) {
                sortable.add(component);
            }
        }

        sortable.sort(new LexemeLengthComparator());

        return sortable;
    }
}
