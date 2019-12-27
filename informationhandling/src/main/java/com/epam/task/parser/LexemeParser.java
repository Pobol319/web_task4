package com.epam.task.parser;

import com.epam.task.component.Component;
import com.epam.task.component.Lexeme;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser extends AbstractParser {
    private static final String WORD_REG_EXP = "\\w+";
    private static final String PUNCTUATION_MARK_REG_EXP = "-|,|;|:|\\.{3}|\\.|!|\\?|\\(|\\)";

    @Override
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
    }
}
