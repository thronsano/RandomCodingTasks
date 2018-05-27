package university.sob.lab3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {
    private Stack stack;

    @Before
    public void prepare() {
        stack = new Stack(100);
    }

    @After
    public void cleanup() {
        stack = null;
    }

    @Test
    public void testNewStackIsEmpty() {
        assertTrue(stack.isEmpty());
    }

    @Test(expected = Exception.class)
    public void testNewStackNoTop() throws Exception {
        stack.top();
    }

    @Test(expected = Exception.class)
    public void testNewStackNoPop() throws Exception {
        stack.pop();
    }

    @Test
    public void testSinglePushThenOthers() throws Exception {
        String abc = "abc";

        stack.push(abc);

        assertSame(abc, stack.top());
        assertSame(abc, stack.top());
        assertSame(abc, stack.top());

        assertFalse(stack.isEmpty());

        assertSame(abc, stack.pop());

        assertTrue(stack.isEmpty());

        try {
            stack.pop();
            fail("No exception when removing from empty stack!");
        } catch (Exception ignored) {
        }
    }

    @Test
    public void testMultiplePushThenOthers() throws Exception {
        String abc = "abc", cba = "cba", bac = "bac";

        stack.push(abc);
        stack.push(cba);
        stack.push(bac);

        assertSame(bac, stack.pop());
        assertSame(cba, stack.pop());
        assertSame(abc, stack.pop());

        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPushNull() throws Exception {
        stack.push(null);

        assertFalse(stack.isEmpty());

        assertNull(stack.pop());
    }

    @Test
    public void workingAfterException() throws Exception {
        try {
            stack.pop();
        } catch (Exception ignore) {
        }

        String abc = "abc";
        stack.push(abc);

        assertSame(abc, stack.pop());
    }
}
