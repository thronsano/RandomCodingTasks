package hackerrank.Tests;

import org.junit.Before;
import org.junit.Test;
import hackerrank.ChallengeFibonacci;
import hackerrank.ChallengeFibonacci.Technique;

import static org.junit.jupiter.api.Assertions.*;

public class ChallengeFibonacciTest {
    private ChallengeFibonacci challengeFibonacci;

    @Before
    public void setup() {
        challengeFibonacci = new ChallengeFibonacci();
    }

    @Test
    public void checkRecursive() {
        assertEquals(0, challengeFibonacci.getFibonacciNumber(-10, Technique.RECURSIVE));
        assertEquals(0, challengeFibonacci.getFibonacciNumber(0, Technique.RECURSIVE));

        assertEquals(1, challengeFibonacci.getFibonacciNumber(1, Technique.RECURSIVE));
        assertEquals(1, challengeFibonacci.getFibonacciNumber(2, Technique.RECURSIVE));
        assertEquals(2, challengeFibonacci.getFibonacciNumber(3, Technique.RECURSIVE));

        assertEquals(55, challengeFibonacci.getFibonacciNumber(10, Technique.RECURSIVE));
        assertEquals(377, challengeFibonacci.getFibonacciNumber(14, Technique.RECURSIVE));
    }

    @Test
    public void checkIteration() {
        assertEquals(0, challengeFibonacci.getFibonacciNumber(-10, Technique.ITERATION));
        assertEquals(0, challengeFibonacci.getFibonacciNumber(0, Technique.ITERATION));

        assertEquals(1, challengeFibonacci.getFibonacciNumber(1, Technique.ITERATION));
        assertEquals(1, challengeFibonacci.getFibonacciNumber(2, Technique.ITERATION));
        assertEquals(2, challengeFibonacci.getFibonacciNumber(3, Technique.ITERATION));

        assertEquals(55, challengeFibonacci.getFibonacciNumber(10, Technique.ITERATION));
        assertEquals(377, challengeFibonacci.getFibonacciNumber(14, Technique.ITERATION));
    }
}