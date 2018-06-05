package random;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Fibonacci {
    enum Technique {
        RECURSIVE,
        ITERATION
    }

    private int recursiveFibonacci(int twoNumbersBack, int oneNumberBack, int currentIndex, int desiredIndex) {
        int currentNo = twoNumbersBack + oneNumberBack;

        if (currentIndex < desiredIndex)
            return recursiveFibonacci(oneNumberBack, currentNo, ++currentIndex, desiredIndex);
        else
            return currentNo;
    }

    private int iterationFibonacci(int desiredIndex) {
        int twoNumbersBack = 0;
        int oneNumberBack = 1;
        int currentNo = 1;

        for (int i = 1; i < desiredIndex; i++) {
            currentNo = twoNumbersBack + currentNo;
            twoNumbersBack = oneNumberBack;
            oneNumberBack = currentNo;
        }

        return currentNo;
    }

    private int getFibonacciNumber(int desiredIndex, Technique technique) {
        if (desiredIndex <= 0)
            return 0;
        else if (desiredIndex == 1)
            return 1;

        switch (technique) {
            case RECURSIVE:
                return recursiveFibonacci(0, 1, 2, desiredIndex);
            case ITERATION:
                return iterationFibonacci(desiredIndex);
            default:
                throw new NotImplementedException();
        }
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();

        int desiredIndex = 10;

        System.out.println(fibonacci.getFibonacciNumber(desiredIndex, Technique.RECURSIVE));
        System.out.println(fibonacci.getFibonacciNumber(desiredIndex, Technique.ITERATION));
    }
}
