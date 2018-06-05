package random;

import org.junit.Before;
import org.junit.Test;
import random.Fibonacci.Technique;

import static org.junit.jupiter.api.Assertions.*;

public class FibonacciTest {
    private Fibonacci fibonacci;

    @Before
    public void setup() {
        fibonacci = new Fibonacci();
    }

    @Test
    public void checkRecursive() {
        assertEquals(0, fibonacci.getFibonacciNumber(-10, Technique.RECURSIVE));
        assertEquals(0, fibonacci.getFibonacciNumber(0, Technique.RECURSIVE));

        assertEquals(1, fibonacci.getFibonacciNumber(1, Technique.RECURSIVE));
        assertEquals(1, fibonacci.getFibonacciNumber(2, Technique.RECURSIVE));
        assertEquals(2, fibonacci.getFibonacciNumber(3, Technique.RECURSIVE));

        assertEquals(55, fibonacci.getFibonacciNumber(10, Technique.RECURSIVE));
        assertEquals(377, fibonacci.getFibonacciNumber(14, Technique.RECURSIVE));
    }

    @Test
    public void checkIteration() {
        assertEquals(0, fibonacci.getFibonacciNumber(-10, Technique.ITERATION));
        assertEquals(0, fibonacci.getFibonacciNumber(0, Technique.ITERATION));

        assertEquals(1, fibonacci.getFibonacciNumber(1, Technique.ITERATION));
        assertEquals(1, fibonacci.getFibonacciNumber(2, Technique.ITERATION));
        assertEquals(2, fibonacci.getFibonacciNumber(3, Technique.ITERATION));

        assertEquals(55, fibonacci.getFibonacciNumber(10, Technique.ITERATION));
        assertEquals(377, fibonacci.getFibonacciNumber(14, Technique.ITERATION));
    }
}