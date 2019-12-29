package com.epam.task.interpreter;

import com.epam.task.exception.InvalidExpressionParserException;
import com.epam.task.exception.InvalidExpressionTextException;

import java.util.List;

public class ArithmeticExpressionInterpreter {
    private ArithmeticExpressionFactory expressionParser;

    public ArithmeticExpressionInterpreter(ArithmeticExpressionFactory expressionParser) {
        this.expressionParser = expressionParser;
    }

    public Integer calculate(String expressionText)
            throws InvalidExpressionTextException, InvalidExpressionParserException {
        if (expressionText == null) {
            throw new InvalidExpressionTextException("Expression text value is null");
        }

        if (expressionParser == null) {
            throw new InvalidExpressionParserException("Expression parser value is null");
        }

        List<AbstractExpression<Integer>> expressions = expressionParser.createExpression(expressionText);

        Context<Integer> context = new IntegerContext();

        for (AbstractExpression<Integer> expression : expressions) {
            expression.interpret(context);
        }

        return context.popValue();
    }
}
