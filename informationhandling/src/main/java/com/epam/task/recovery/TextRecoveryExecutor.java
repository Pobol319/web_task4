package com.epam.task.recovery;

import com.epam.task.component.Component;
import com.epam.task.component.Lexeme;
import com.epam.task.exception.ComponentException;
import com.epam.task.exception.InvalidExpressionParserException;
import com.epam.task.exception.InvalidExpressionTextException;
import com.epam.task.interpreter.ArithmeticExpressionInterpreter;

public class TextRecoveryExecutor {
    private static final Component LAST = null;
    private ArithmeticExpressionInterpreter interpreter;

    public TextRecoveryExecutor(ArithmeticExpressionInterpreter interpreter) {
        this.interpreter = interpreter;
    }

    public String executeRecovery(Component mainComponent) throws ComponentException, InvalidExpressionTextException, InvalidExpressionParserException {
        StringBuilder result = new StringBuilder();
        for (Component component : mainComponent.getChild()) {
            if (component.getChild() == LAST) {
                Lexeme lexeme = (Lexeme) component;
                if (lexeme.isExpression()) {
                    result.append(interpreter.calculate(lexeme.getValue())).append(" ");
                } else {
                    result.append(lexeme.getValue()).append(" ");
                }
            } else {
                result.append(executeRecovery(component));
            }
        }
        return result.toString();
    }
}
