package com.epam.task.interpreter;

public class TerminalExpressionSubtract implements AbstractExpression<Integer> {

    @Override
    public void interpret(Context<Integer> context) {
        Integer subtrahend = context.popValue();
        Integer minuend = context.popValue();
        context.pushValue(minuend - subtrahend);
    }
}
