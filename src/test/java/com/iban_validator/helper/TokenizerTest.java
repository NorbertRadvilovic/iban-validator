package com.iban_validator.helper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TokenizerTest {

    @Test
    void testTokenize() {
        String[] result = Tokenizer.tokenize("test1 \n test2");
        assertEquals(result.length, 2);
        assertEquals(result[0], "test1");
        assertEquals(result[1], "test2");
    }

    @Test
    void testTokenizeSingleElement() {
        String[] result = Tokenizer.tokenize("test1");
        assertEquals(result.length, 1);
        assertEquals(result[0], "test1");
    }

    @Test
    void testTokenizeEmptyString() {
        String[] result = Tokenizer.tokenize("");
        assertEquals(result.length, 0);
    }

    @Test
    void testDeTokenize() {
        String[] input = {"test1;false", "test2;true"};
        String result = Tokenizer.deTokenize(input);
        assertEquals(result, "test1;false test2;true");
    }
}