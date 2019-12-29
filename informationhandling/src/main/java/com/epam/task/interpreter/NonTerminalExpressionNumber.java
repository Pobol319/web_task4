package com.epam.task.interpreter;

public class NonTerminalExpressionNumber implements AbstractExpression<Integer> {
    public Integer value;

    public NonTerminalExpressionNumber(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public void interpret(Context<Integer> context) {
        context.pushValue(value);
    }
}
