package ru.malychev.junit;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Unit test for simple Calc.
*/
@RunWith(Parameterized.class)
public class CalcTest {

    @Parameterized.Parameters
    public static Collection<Object> data() {
        return Arrays.asList(new Object[][] {
            {5, 3, 8, 2},
            {15, 10, 25, 5},
            {5, 10, 15, -5}
        });
    }
    int x, y, sum, sub;
    public CalcTest(int x, int y, int sum, int sub) {
        this.x = x;
        this.y = y;
        this.sum = sum;
        this.sub = sub;
    }

/**
 * Rigourous Test :-)
*/
    @Test
    public void getCalcTest() {
        Assert.assertEquals(new Calc().getSum(x, y), sum);
    }

    @Test
    public void getSubtractionTest() {
        Assert.assertEquals(new Calc().getSubtraction(x, y), sub);
    }

    @BeforeClass
    public static void allTestsStarted() {
        System.out.println("All tests started");
    }

    @AfterClass
    public static void allTestsFinished() {
        System.out.println("All tests finished");
    }

    @Before
    public void testStarted() {
        System.out.println("Started");
    }

    @After
    public void testFinished() {
        System.out.println("Finished");
    }

}
