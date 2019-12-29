package com.epam.task.component;

import com.epam.task.exception.ComponentException;

import java.util.List;

public class Lexeme implements Component {
    private String value;
    private LexemeEnum type;

    private Lexeme(String value, LexemeEnum type) {
        this.value = value;
        this.type = type;
    }

    public static Lexeme word(String value) {
        return new Lexeme(value, LexemeEnum.WORD);
    }

    public static Lexeme punctuationMark(String value) {
        return new Lexeme(value, LexemeEnum.PUNCTUATION_MARK);
    }

    public static Lexeme expression(String value) {
        return new Lexeme(value, LexemeEnum.EXPRESSION);
    }

    public String getValue() {
        return value;
    }

    public boolean isWord() {
        return LexemeEnum.WORD.equals(type);
    }

    public boolean isPunctuationMark() {
        return LexemeEnum.PUNCTUATION_MARK.equals(type);
    }

    public boolean isExpression() {
        return LexemeEnum.EXPRESSION.equals(type);
    }

    @Override
    public void add(Component component) throws ComponentException {
        throw new ComponentException("Cant add component to Leaf");
    }

    @Override
    public void remove(Component component) throws ComponentException {
        throw new ComponentException("Cant remove component from Leaf");
    }

    @Override
    public List<Component> getChild() {
        return null;
    }
}
