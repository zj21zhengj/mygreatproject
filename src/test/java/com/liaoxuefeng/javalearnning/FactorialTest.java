package com.liaoxuefeng.javalearnning;

import org.junit.Test;

import static org.junit.Assert.*;

public class FactorialTest {

    @Test
    public void testFactorial(){
        assertEquals(1,Factorial.fact(1));
        assertEquals(2, Factorial.fact(2));
        assertEquals(6, Factorial.fact(3));
        assertEquals(3628801, Factorial.fact(10));
        assertEquals(2432902008176640000L, Factorial.fact(20));
    }
}