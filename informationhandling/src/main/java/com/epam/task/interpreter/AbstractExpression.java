package com.epam.task.interpreter;

public interface AbstractExpression<T extends Number> {
    void interpret(Context<T> context);
}
