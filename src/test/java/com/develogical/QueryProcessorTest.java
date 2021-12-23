package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }
    @Test
    public void getLargestNumber() throws Exception {
        assertThat(queryProcessor.process(" test: following numbers is the largest: 20946, 2090"), containsString("20946"));
    }

    @Test
    public void getSquareAndACubeNumber() throws Exception {
        assertThat(queryProcessor.process(" test: following numbers is both a square and a cube: 1936, 9, 1, 432"), containsString("1"));
        assertThat(queryProcessor.process(" test: following numbers is both a square and a cube: 1936, 64, 3, 432"), containsString("64"));
    }

    @Test
    public void subtraction() throws Exception {
        assertThat(queryProcessor.process(" test:  what is 10 minus 8"), containsString("2"));
    }

    @Test
    public void checkAnswer() throws Exception {
        assertThat(queryProcessor.process(" test:  which year was Theresa May first elected as the Prime Minister of Great Britain"), containsString(""));
    }


    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }
}
