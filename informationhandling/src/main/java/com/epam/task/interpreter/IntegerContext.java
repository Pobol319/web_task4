package com.epam.task.interpreter;

import java.util.ArrayDeque;
import java.util.Deque;

public class IntegerContext implements Context<Integer> {
    private Deque<Integer> values = new ArrayDeque<>();

    public void pushValue(Integer value) {
        values.push(value);
    }

    public Integer popValue() {
        return values.pop();
    }
}
