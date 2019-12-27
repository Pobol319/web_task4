package com.epam.task.parser;

import com.epam.task.component.Component;
import com.epam.task.component.Composite;
import com.epam.task.exception.ComponentException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractParser implements TextParser {
    private TextParser successor;

    public void setSuccessor(TextParser successor){
        this.successor = successor;
    }

    public TextParser getSuccessor(){
        return successor;
    }

    public Component findAllComponents(String text, String regExp) throws ComponentException {
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(text);

        Component compositeText = new Composite();
        while (matcher.find()){
            String matchingText = matcher.group();
            Component component = successor.parse(matchingText);
            compositeText.add(component);
        }
        return compositeText;
    }
}
