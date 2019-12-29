package com.epam.task.interpreter;

public class TerminalExpressionDivide implements AbstractExpression<Integer> {

    @Override
    public void interpret(Context<Integer> context) {
        Integer denominator = context.popValue();
        Integer dividend = context.popValue();
        context.pushValue(dividend / denominator);
    }
}