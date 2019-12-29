package com.epam.task.reader;

import com.epam.task.exception.InformationTextReaderException;
import org.junit.Assert;
import org.junit.Test;

public class InformationTextReaderTests {
    private static final String PATH_TO_FILE_WITH_ONE_PARAGRAPH = "src/test/resources/one_paragraph.txt";
    private static final String PATH_TO_FILE_WITH_TWO_PARAGRAPHS = "src/test/resources/two_paragraphs.txt";
    private static final String INVALID_PATH = "invalid path";

    private static final String TEXT_WITH_ONE_PARAGRAPH = "   One paragraph.";
    private static final String TEXT_WITH_TWO_PARAGRAPHS = "   First paragraph.   Second paragraph.";

    @Test
    public void testReadShouldReturnTextWithOneParagraphWhenGivenValidPathToTextWithOneParagraph() throws InformationTextReaderException {
        //given
        InformationTextReader reader = new InformationTextReader();
        //when
        String actual = reader.read(PATH_TO_FILE_WITH_ONE_PARAGRAPH);
        //then
        Assert.assertEquals(TEXT_WITH_ONE_PARAGRAPH, actual);
    }

    @Test
    public void testReadShouldReturnTextWithTwoParagraphsWhenGivenValidPathToTextWithTwoParagraphs() throws InformationTextReaderException {
        //given
        InformationTextReader reader = new InformationTextReader();
        //when
        String actual = reader.read(PATH_TO_FILE_WITH_TWO_PARAGRAPHS);
        //then
        Assert.assertEquals(TEXT_WITH_TWO_PARAGRAPHS, actual);
    }

    @Test(expected = NullPointerException.class)
    public void testReadShouldThrowInvalidPathExceptionWhenGivenInvalidPath() throws InformationTextReaderException {
        //given
        InformationTextReader reader = new InformationTextReader();
        //when
        reader.read(INVALID_PATH);
        //then
        Assert.fail();
    }
}
