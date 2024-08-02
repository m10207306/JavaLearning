package com.in28minutes.junit;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class MyAssertTest {

    List<String> todos = Arrays.asList("AWS", "Azure", "DevOps");
    
    @Test
    void testCalculateSum() {
        boolean test = todos.contains("AWS");
        assertEquals(true, test);
        assertEquals(3, todos.size());

        assertArrayEquals(new int[] {1, 2}, new int[] {1, 2});
    }
}
