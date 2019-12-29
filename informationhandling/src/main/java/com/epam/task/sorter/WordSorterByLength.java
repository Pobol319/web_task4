package com.epam.task.sorter;

import com.epam.task.comparator.LexemeLengthComparator;
import com.epam.task.component.Lexeme;

import java.util.ArrayList;
import java.util.List;

public class WordSorterByLength implements Sorter<Lexeme> {

    @Override
    public List<Lexeme> sort(List<Lexeme> lexemes) {
        List<Lexeme> sortable = new ArrayList<>();

        for(Lexeme lexeme: lexemes){
            if(lexeme.isWord()){
                sortable.add(lexeme);
            }
        }

        lexemes.sort(new LexemeLengthComparator());

        return sortable;
    }
}
