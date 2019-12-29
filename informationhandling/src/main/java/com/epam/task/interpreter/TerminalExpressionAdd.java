package com.epam.task.interpreter;

public class TerminalExpressionAdd implements AbstractExpression<Integer> {

    @Override
    public void interpret(Context<Integer> context) {
        context.pushValue(context.popValue() + context.popValue());
    }
}
