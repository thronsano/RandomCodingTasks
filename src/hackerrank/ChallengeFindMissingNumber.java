package hackerrank;

import java.util.Arrays;

public class ChallengeFindMissingNumber {
    public int missingNumber(int[] list) {
        Arrays.sort(list);
        int prevNo = list[0];

        for (int i = 1; i < list.length; i++)
            if (list[i] == prevNo + 1)
                prevNo = list[i];
            else
                return prevNo + 1;

        return 0;
    }
}
