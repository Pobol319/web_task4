package com.epam.task.chain_responsibility;

import com.epam.task.parser.FullTextParser;
import com.epam.task.parser.TextParser;
import org.junit.Assert;
import org.junit.Test;

public class ParserChainBuilderTests {
    @Test
    public void testBuildShouldReturnNewTextParser() {
        //given
        ParserChainBuilder builder = new ParserChainBuilder();
        //when
        TextParser textParser = builder.build();
        //then
        Assert.assertEquals(FullTextParser.class, textParser.getClass());
    }
}
