package random;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringToIntTest {
    StringToInt stringToInt;

    @Before
    public void setup() {
        stringToInt = new StringToInt();
    }

    @Test
    public void testConversion() {
        assertEquals(100, stringToInt.customParseInt("100"));
        assertEquals(1, stringToInt.customParseInt("1"));
    }

    @Test
    public void testConversionNegative() {
        assertEquals(-100, stringToInt.customParseInt("-100"));
        assertEquals(-1, stringToInt.customParseInt("-1"));
        assertEquals(-53, stringToInt.customParseInt("-53"));
    }
}