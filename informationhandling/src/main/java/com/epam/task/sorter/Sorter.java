package com.epam.task.sorter;

import com.epam.task.component.Component;

import java.util.List;

public interface Sorter<T extends Component> {
    List<T> sort(List<T> sorted);
}