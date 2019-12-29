package com.epam.task.director;


import com.epam.task.chain_responsibility.ParserChainBuilder;
import com.epam.task.component.Component;
import com.epam.task.exception.ComponentException;
import com.epam.task.exception.InformationTextReaderException;
import com.epam.task.exception.InvalidExpressionParserException;
import com.epam.task.exception.InvalidExpressionTextException;
import com.epam.task.parser.TextParser;
import com.epam.task.reader.InformationTextReader;
import com.epam.task.recovery.TextRecoveryExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Director {
    private InformationTextReader reader;
    private ParserChainBuilder builder;
    private TextRecoveryExecutor executor;

    private static final Logger LOG = LogManager.getRootLogger();

    public Director(InformationTextReader reader, ParserChainBuilder builder, TextRecoveryExecutor executor) {
        this.reader = reader;
        this.builder = builder;
        this.executor = executor;
    }

    public String handleInformation(String path) {
        String recoveringText = null;

        try {
            String text = reader.read(path);

            TextParser textParser = builder.build();
            Component component = textParser.parse(text);

            recoveringText = executor.executeRecovery(component);
        } catch (InformationTextReaderException | ComponentException | InvalidExpressionTextException | InvalidExpressionParserException e) {
            LOG.fatal(e);
        }

        return recoveringText;
    }

}
