package com.epam.task.director;


import com.epam.task.chain_responsibility.ParserChainBuilder;
import com.epam.task.component.Component;
import com.epam.task.component.Lexeme;
import com.epam.task.exception.ComponentException;
import com.epam.task.exception.InformationTextReaderException;
import com.epam.task.exception.InvalidExpressionParserException;
import com.epam.task.exception.InvalidExpressionTextException;
import com.epam.task.interpreter.ArithmeticExpressionInterpreter;
import com.epam.task.interpreter.ArithmeticExpressionParser;
import com.epam.task.parser.TextParser;
import com.epam.task.reader.InformationTextReader;
import com.epam.task.recovery.TextRecoveryExecutor;
import com.epam.task.sorter.WordSorterByLength;

import java.util.List;

public class Director {
    public static void main(String[] args) throws ComponentException, InformationTextReaderException, InvalidExpressionTextException, InvalidExpressionParserException {
        String path = "src\\main\\resources\\text.txt";

        InformationTextReader reader = new InformationTextReader();
        ParserChainBuilder builder = new ParserChainBuilder();
        TextParser parser = builder.build();
        String text = reader.read(path);
        Component component = parser.parse(text);

        ArithmeticExpressionParser factory = new ArithmeticExpressionParser();
        ArithmeticExpressionInterpreter interpreter = new ArithmeticExpressionInterpreter(factory);

        TextRecoveryExecutor executor = new TextRecoveryExecutor(interpreter);
        String recoveryText = executor.executeRecovery(component);

        /*System.out.println(recoveryText);*/

        /*ParagraphSorterBySentenceNumber sorter = new ParagraphSorterBySentenceNumber();
        List<Component> sortedComposite = sorter.sort(component.getChild());

        for (Component component1: sortedComposite){
            System.out.println(executor.executeRecovery(component1));
            System.out.println();
        }*/

        WordSorterByLength sorter = new WordSorterByLength();
        List<Component> components = component.getChild();

        List<Component> sortedComposite = null;
        List<List<Component>> sortedAllText = null;
        for (Component component1 : components) {
            for (Component component2 : component1.getChild()) {
                sortedComposite = sorter.sort(component2.getChild());
                for (Component component3 : sortedComposite) {
                    Lexeme lexeme = (Lexeme) component3;
                    System.out.print(lexeme.getValue());
                    System.out.println();
                }
            }
        }

    }
}
