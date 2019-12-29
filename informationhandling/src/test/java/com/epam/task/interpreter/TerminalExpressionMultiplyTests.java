package com.epam.task.interpreter;

import org.junit.Test;

public class TerminalExpressionMultiplyTests {

    private static final Integer FIRST_NUMBER = 12;
    private static final Integer SECOND_NUMBER = 3;
    private static final Integer ANSWER = 36;

    @Test
    public void testInterpretShouldPushResultOfMultiplyingTwoNumbersToContextWhenGivenThisContext() {
        AbstractExpression<Integer> expressionMultiply = new TerminalExpressionMultiply();

        new TerminalExpressionCommonTests().testInterpret(expressionMultiply, FIRST_NUMBER, SECOND_NUMBER, ANSWER);
    }
}
