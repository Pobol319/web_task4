package com.epam.task.interpreter;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class NonTerminalExpressionNumberTests {
    private static final Integer NUMBER_VALUE = 10;

    @Test
    public void testInterpretShouldPushValueToContextWhenGivenThisContext() {
        //given
        AbstractExpression<Integer> expressionNumber = new NonTerminalExpressionNumber(NUMBER_VALUE);
        Context<Integer> context = mock(IntegerContext.class);
        //when
        expressionNumber.interpret(context);
        //then
        verify(context, atLeastOnce()).pushValue(NUMBER_VALUE);
    }
}