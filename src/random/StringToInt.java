package random;

//Implementation of a class converting String to an int without parseInt
//Input is a pure String like "1412"
public class StringToInt {

    public int customParseInt(String no) {
        String localCopy;
        double factor;
        int finalNo = 0;
        boolean positive = true;

        //CHECK IF NUMBER IS NEGATIVE
        if (no.charAt(0) == '-') {
            positive = false;
            localCopy = no.substring(1, no.length());
        } else
            localCopy = no;

        //DEFINE DIVISION FACTOR
        factor = Math.pow(10, localCopy.length() - 1);

        for (int i = 0; i < localCopy.length(); i++) {
            finalNo += turnIntoNumber(localCopy.charAt(i)) * factor;
            factor /= 10;
        }

        return positive ? finalNo : -1 * finalNo;
    }

    private int turnIntoNumber(char character) {
        return character - '0';
    }
}
