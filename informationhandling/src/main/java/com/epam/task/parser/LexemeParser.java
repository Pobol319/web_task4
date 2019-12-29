package com.epam.task.parser;

import com.epam.task.component.Component;
import com.epam.task.component.Lexeme;

public class LexemeParser extends AbstractParser {
    private static final String PUNCTUATION_MARK_REG_EXP = "-|,|;|:|\\.{3}|\\.|!|\\?|\\(|\\)";
    private static final String EXPRESSION_REG_EXP = "[\\[](.*?)[\\]]";

    @Override
    public Component parse(String text) {
        if (text.matches(EXPRESSION_REG_EXP)) {
            return Lexeme.expression(text);
        } else if (text.matches(PUNCTUATION_MARK_REG_EXP)) {
            return Lexeme.punctuationMark(text);
        } else {
            return Lexeme.word(text);
        }
    }


 /*   @Override
    public Component parse(String text) {
        Pattern pattern = Pattern.compile(WORD_REG_EXP);
        Matcher matcher = pattern.matcher(text);
        if (matcher.matches()) {
            return Lexeme.word(text);
        } else if (text.matches(PUNCTUATION_MARK_REG_EXP)) {
            return Lexeme.punctuationMark(text);
        } else {
            return Lexeme.expression(text);
        }
    }*/
}
