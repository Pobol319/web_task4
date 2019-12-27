package com.epam.task.director;


import com.epam.task.chain_responsibility.ParserChainBuilder;
import com.epam.task.component.Component;
import com.epam.task.exception.ComponentException;
import com.epam.task.parser.TextParser;
import com.epam.task.reader.InformationTextReader;

public class Director {
    public static void main(String[] args) throws ComponentException {
        String path = "src\\main\\resources\\text.txt";

        InformationTextReader reader = new InformationTextReader();
        ParserChainBuilder builder = new ParserChainBuilder();
        TextParser parser = builder.build();
        String text = reader.read(path);
        Component component = parser.parse(text);

        for (Component component1 : component.getChild()) {
            for (Component component2 : component1.getChild()) {
                System.out.print(component2.toString() + " ");
            }
        }


    }
}
