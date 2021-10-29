package com.gmail.rybachko.anna.task1;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContentHandlerImplTest {
    private NumberFormatException exception;
    ContentHandler contentHandler;

    @Before
    public void setUp() throws Exception {
       contentHandler = new ContentHandlerImpl();

    }

    @Test
    public void processedIsFizz() {
        Assert.assertEquals("Fizz", contentHandler.process("3"));
    }

    @Test
    public void processedIsBuzz() {
        Assert.assertEquals("Buzz", contentHandler.process("5"));
    }

    @Test
    public void processedIsFizzBuzz() {
        Assert.assertEquals("FizzBuzz", contentHandler.process("15"));
    }

    @Test
    public void processedIsNotFizzBuzz() {
        Assert.assertEquals("2", contentHandler.process("2"));
    }

    @Test
    public void processedIsNull() {
        Assert.assertThrows(NumberFormatException.class, () ->  contentHandler.process(null));
    }

    @Test
    public void processedIsAbc() {
        Assert.assertThrows(NumberFormatException.class, () ->  contentHandler.process("Abc"));
    }
}