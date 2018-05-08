import java.util.*;

public class ChallengeAnagrams {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ChallengeAnagrams challenge = new ChallengeAnagrams();

        String a = in.next();
        String b = in.next();

        System.out.println(challenge.numberNeeded(a, b));
    }

    class Letter {
        int timesOccurred;
        char letter;

        Letter(char letter, boolean reverseCount) {
            if (!reverseCount)
                this.timesOccurred++;
            else
                this.timesOccurred--;

            this.letter = letter;
        }
    }

    private int numberNeeded(String first, String second) {
        HashSet<Letter> letters = new HashSet<>();

        for (int i = 0; i < first.length(); i++)
            charExistsAddIfNot(first.charAt(i), letters, false);

        for (int i = 0; i < second.length(); i++)
            charExistsAddIfNot(second.charAt(i), letters, true);

        return charDifference(letters);
    }

    private int charDifference(Set<Letter> letters) {
        int sum = 0;
        for (Letter letter : letters)
            sum += Math.abs(letter.timesOccurred);

        return sum;
    }

    private boolean charExistsAddIfNot(char character, Set<Letter> letters, boolean reverseCount) {
        for (Letter currentLetter : letters) {
            if (currentLetter.letter == character) {
                if (!reverseCount)
                    currentLetter.timesOccurred++;
                else
                    currentLetter.timesOccurred--;

                return true;
            }
        }

        letters.add(new Letter(character, reverseCount));
        return false;
    }
}
