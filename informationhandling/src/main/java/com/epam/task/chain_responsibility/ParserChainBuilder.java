package com.epam.task.chain_responsibility;

import com.epam.task.parser.*;

public class ParserChainBuilder {

    public TextParser build() {
        LexemeParser lexemeParser = new LexemeParser();

        SentenceParser sentenceParser = new SentenceParser();
        sentenceParser.setSuccessor(lexemeParser);

        ParagraphParser paragraphParser = new ParagraphParser();
        paragraphParser.setSuccessor(sentenceParser);

        FullTextParser fullTextParser = new FullTextParser();
        fullTextParser.setSuccessor(paragraphParser);

        return fullTextParser;
    }
}
