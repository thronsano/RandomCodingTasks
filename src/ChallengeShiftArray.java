import java.util.Scanner;

public class ChallengeShiftArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];

        for (int a_i = 0; a_i < n; a_i++)
            a[a_i] = in.nextInt();


        ChallengeShiftArray test = new ChallengeShiftArray();
        a = test.shiftArrayLeft(a, k);

        for (int no : a)
            System.out.print(no + " ");

    }

    int[] shiftArrayLeft(int[] array, int shiftByAmount) {
        for (int i = 0; i < shiftByAmount; i++) {
            int firstNo = array[0];

            for (int j = 0; j < array.length - 1; j++)
                array[j] = array[j + 1];

            array[array.length - 1] = firstNo;
        }

        return array;
    }
}
