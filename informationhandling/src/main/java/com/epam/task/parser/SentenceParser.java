package com.epam.task.parser;

import com.epam.task.component.Component;
import com.epam.task.exception.ComponentException;

public class SentenceParser extends AbstractParser {
    private static final String SENTENCE_REG_EXP = "[\\w&&[^\\d]]+|[\\[](.*?)[\\]]|(\\d+(_\\d+)*[+\\-*/^]*)|\\.{3}|\\.|\\?|!|\\(|\\)|,|;|-|:";
    @Override
    public Component parse(String text) throws ComponentException {
        return findAllComponents(text,SENTENCE_REG_EXP);
    }
}
