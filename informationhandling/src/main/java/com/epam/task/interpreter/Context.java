package com.epam.task.interpreter;

public interface Context<T extends Number> {
    void pushValue(T value);
    T popValue();
}
