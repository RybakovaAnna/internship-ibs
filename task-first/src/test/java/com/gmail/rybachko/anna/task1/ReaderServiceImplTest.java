package com.gmail.rybachko.anna.task1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReaderServiceImplTest {
    private ReaderService readerService;

    @Before
    public void setUp() throws Exception {
        readerService = new ReaderServiceImpl();
    }

    @Test
    public void getReaderIs() {
        Assert.assertNull(readerService.getReader("Abc"));
    }
}