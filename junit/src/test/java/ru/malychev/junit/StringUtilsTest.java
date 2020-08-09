package ru.malychev.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilsTest {

    double pi_d;
    String pi_s;

    @Before
    public void setUp() throws Exception {
        pi_d = 3.1415;
        pi_s = "3.1415";
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testJoinArray() {
    }

    @Test
    public void testToArray() {
        String[] expected = {"T", "E", "S", "T"};
        String source="T:E:S:T";
        assertArrayEquals("Wrong array", expected, StringUtils.toArray(source, ':'));
        assertNotNull(StringUtils.toArray(null, ':'));
    }

    @Test
    public void testIsEmpty() {
        assertFalse("Non empty string claimed to be empty", StringUtils.isEmpty("TEST"));
        assertTrue("Empty string not recognized", StringUtils.isEmpty(""));
        assertTrue("Whitespaces not recognized",StringUtils.isEmpty(" "));
    }

    @Test
    public void testToDouble() {
        assertEquals("Unexpected double value", pi_d, StringUtils.toDouble(pi_s), 0.0001);
        assertEquals("Not NaN for null", Double.NaN, StringUtils.toDouble(null), 0.00001);
    }

    @Test
    public void testFromDouble() {
        assertEquals("Unexpected string value", pi_s, StringUtils.fromDouble(pi_d));
    }
}