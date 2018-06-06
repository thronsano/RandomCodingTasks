package hackerrank.Tests;

import hackerrank.ChallengeFindMissingNumber;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChallengeFindMissingNumberTest {
    ChallengeFindMissingNumber challengeFindMissingNumber;

    @BeforeEach
    public void setup() {
        challengeFindMissingNumber = new ChallengeFindMissingNumber();
    }

    @Test
    public void missingNumber() {
        assertEquals(5, challengeFindMissingNumber.missingNumber(new int[]{1, 2, 3, 4, 6, 7}));
        assertEquals(0, challengeFindMissingNumber.missingNumber(new int[]{-1, 1, 2, 3}));
        assertEquals(4, challengeFindMissingNumber.missingNumber(new int[]{1, 2, 3, 5, 6, 8}));
    }
}