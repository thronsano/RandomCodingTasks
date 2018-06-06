package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class ChallengeWordCount {
    Map<String, Integer> wordOccurrences(String sentence) {
        Map<String, Integer> words = new HashMap<>();
        String[] wordList = sentence.toLowerCase().split("\\s+");

        for (String word : wordList)
            if (!words.containsKey(word))
                words.put(word, 1);
            else
                words.put(word, words.get(word) + 1);

        return words;
    }

    public static void main(String[] args) {
        ChallengeWordCount counter = new ChallengeWordCount();
        Map<String, Integer> wordOccurrences = counter.wordOccurrences("Ania i Ania maja kota");
        wordOccurrences.forEach((k, v) -> System.out.println(k + " wystapil " + v + " razy"));
    }
}
