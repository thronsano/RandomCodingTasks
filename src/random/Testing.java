package random;

import java.util.Arrays;
import java.util.List;

public class Testing {
    public static void main(String[] args) {
        Testing testing = new Testing();
        String[] names = {"Peter", "Ann", "Someone"};
        List<String> namesList = Arrays.asList(names);

        int lettersAmount = namesList.stream().filter(x -> (x.length() > 3)).map(String::length).reduce(0, Integer::sum);
        System.out.println(lettersAmount);
    }
}
