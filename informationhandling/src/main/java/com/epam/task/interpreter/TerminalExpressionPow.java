package com.epam.task.interpreter;

public class TerminalExpressionPow implements AbstractExpression<Integer> {

    @Override
    public void interpret(Context<Integer> context) {
        context.pushValue((int) Math.pow(context.popValue(), context.popValue()));
    }
}
