package com.epam.task.interpreter;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeastOnce;

public class TerminalExpressionCommonTests {
    private static final int TWICE = 2;

    public void testInterpret(AbstractExpression<Integer> expression, Integer firstNumber,
                              Integer secondNumber, Integer answer) {
        Context<Integer> context = mock(IntegerContext.class);
        when(context.popValue()).thenReturn(firstNumber, secondNumber);

        expression.interpret(context);

        verify(context, atLeast(TWICE)).popValue();
        verify(context, atLeastOnce()).pushValue(answer);
    }
}
