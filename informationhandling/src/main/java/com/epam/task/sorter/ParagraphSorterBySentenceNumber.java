package com.epam.task.sorter;

import com.epam.task.comparator.NumberOfCompositeChildrenComparator;
import com.epam.task.component.Composite;

import java.util.ArrayList;
import java.util.List;

public class ParagraphSorterBySentenceNumber implements Sorter<Composite> {

    @Override
    public List<Composite> sort(List<Composite> composites) {
        List<Composite> sortable = new ArrayList<>(composites);

        sortable.sort(new NumberOfCompositeChildrenComparator());

        return sortable;
    }
}