package org.example;

import org.junit.Test;

import static org.example.Main.calculateBill;
import static org.junit.Assert.*;

public class MainTest {

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateBillNegativeNumber() {
        calculateBill(-10);
    }

    @Test
    public void testBac1() {
        assertEquals(58.514, calculateBill(30), 0.001);
    }

    @Test
    public void testBac2() {
        assertEquals(137.83, calculateBill(70), 0.001);
    }

    @Test
    public void testBac3() {
        assertEquals(291.902, calculateBill(140), 0.001);
    }

    @Test
    public void testBac4() {
        assertEquals(609.163, calculateBill(260), 0.001);
    }

    @Test
    public void testBac5() {
        assertEquals(957.636, calculateBill(370), 0.001);
    }

    @Test
    public void testBac6() {
        assertEquals(1158.548, calculateBill(430), 0.01);
    }
}