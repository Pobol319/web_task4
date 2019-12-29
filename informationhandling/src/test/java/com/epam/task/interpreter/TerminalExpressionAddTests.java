package com.epam.task.interpreter;

import org.junit.Test;

public class TerminalExpressionAddTests {
    private static final Integer FIRST_NUMBER = 12;
    private static final Integer SECOND_NUMBER = 3;
    private static final Integer ANSWER = 15;

    @Test
    public void testInterpretShouldPushResultOfAddingTwoNumbersToContextWhenGivenThisContext() {
        AbstractExpression<Integer> expressionAdd = new TerminalExpressionAdd();

        new TerminalExpressionCommonTests().testInterpret(expressionAdd, FIRST_NUMBER, SECOND_NUMBER, ANSWER);
    }
}