package hackerrank.Tests;

import hackerrank.ChallengeConvertStringToInt;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChallengeConvertStringToIntTest {
    ChallengeConvertStringToInt challengeConvertStringToInt;

    @Before
    public void setup() {
        challengeConvertStringToInt = new ChallengeConvertStringToInt();
    }

    @Test
    public void testConversion() {
        assertEquals(100, challengeConvertStringToInt.customParseInt("100"));
        assertEquals(1, challengeConvertStringToInt.customParseInt("1"));
    }

    @Test
    public void testConversionNegative() {
        assertEquals(-100, challengeConvertStringToInt.customParseInt("-100"));
        assertEquals(-1, challengeConvertStringToInt.customParseInt("-1"));
        assertEquals(-53, challengeConvertStringToInt.customParseInt("-53"));
    }
}