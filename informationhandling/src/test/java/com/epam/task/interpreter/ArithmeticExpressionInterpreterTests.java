package com.epam.task.interpreter;

import com.epam.task.exception.InvalidExpressionParserException;
import com.epam.task.exception.InvalidExpressionTextException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeastOnce;

public class ArithmeticExpressionInterpreterTests {
    private static final Integer OPERAND = 5;
    private static final Integer ANSWER = 10;

    private static final String INTERPRETED_LINE = "5_5+";
    private static final String NULL_LINE = null;

    private static final ArithmeticExpressionParser NULL_PARSER = null;

    @Test
    public void testCalculateShouldReturnResultOfAddingTwoNumbersWhenGivenListWithThreeExpressionsToAdd() throws InvalidExpressionTextException, InvalidExpressionParserException {
        //given
        AbstractExpression<Integer> firstExpressionNumber = new NonTerminalExpressionNumber(OPERAND);
        AbstractExpression<Integer> secondExpressionNumber = new NonTerminalExpressionNumber(OPERAND);
        AbstractExpression<Integer> expressionAdd = new TerminalExpressionAdd();

        List<AbstractExpression<Integer>> expressions = Arrays.asList(
                firstExpressionNumber,
                secondExpressionNumber,
                expressionAdd
        );

        ArithmeticExpressionParser expressionParser = mock(ArithmeticExpressionParser.class);
        when(expressionParser.parse(INTERPRETED_LINE)).thenReturn(expressions);

        ArithmeticExpressionInterpreter interpreter = new ArithmeticExpressionInterpreter(expressionParser);
        //when
        Integer actual = interpreter.calculate(INTERPRETED_LINE);
        //then
        Assert.assertEquals(ANSWER, actual);
        verify(expressionParser, atLeastOnce()).parse(INTERPRETED_LINE);
    }

    @Test(expected = InvalidExpressionTextException.class)
    public void testCalculateShouldThrowInvalidExpressionTextExceptionWhenGivenNullExpression()
            throws InvalidExpressionTextException, InvalidExpressionParserException {
        //given
        ArithmeticExpressionParser expressionParser = new ArithmeticExpressionParser();
        ArithmeticExpressionInterpreter interpreter = new ArithmeticExpressionInterpreter(expressionParser);
        //when
        interpreter.calculate(NULL_LINE);
        //then
        Assert.fail();
    }

    @Test(expected = InvalidExpressionParserException.class)
    public void testCalculateShouldThrowInvalidExpressionParserExceptionWhenGivenNullParser()
            throws InvalidExpressionTextException, InvalidExpressionParserException {
        //given
        ArithmeticExpressionInterpreter interpreter = new ArithmeticExpressionInterpreter(NULL_PARSER);
        //when
        interpreter.calculate(INTERPRETED_LINE);
        //then
        Assert.fail();
    }
}
