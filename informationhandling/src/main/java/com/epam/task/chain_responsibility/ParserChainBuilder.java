package com.epam.task.chain_responsibility;

import com.epam.task.parser.LexemeParser;
import com.epam.task.parser.ParagraphParser;
import com.epam.task.parser.SentenceParser;
import com.epam.task.parser.TextParser;

public class ParserChainBuilder {

    public TextParser build(){
        LexemeParser lexemeParser = new LexemeParser();

        SentenceParser sentenceParser = new SentenceParser();
        sentenceParser.setSuccessor(lexemeParser);

        ParagraphParser paragraphParser = new ParagraphParser();
        paragraphParser.setSuccessor(sentenceParser);

        return paragraphParser;
    }
}
