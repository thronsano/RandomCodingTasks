import java.util.Random;

public class NumberSet {
    private static int MAX_SIZE = 100;
    private int[] nSet = new int[MAX_SIZE];
    private int size;

    /**
     * Metoda dodaje liczbę do zbioru liczb
     * (zezwalamy na dodanie liczby już istniejącej)
     *
     * @param i liczba którą dodajemy
     * @throws Exception występuje w przypadku przepełnienia zbioru
     */
    public void add(int i) throws Exception {
        if (size >= MAX_SIZE)
            throw new Exception("Zbiór przepełniony!");
        else {
            nSet[size] = i;
            size++;
        }
    }

    /**
     * Metoda usuwa liczbę ze zbioru (każde wystąpienie)
     *
     * @param i liczba do usunięcia
     * @throws Exception występuje jeśli zbiór nie posiada liczby
     *                   którą chcemy usunąć
     */
    public void remove(int i) throws Exception {
        boolean occurred = false;

        for (int j = 0; j < size; j++) {
            if (nSet[j] == i) {
                shiftListLeft(j);
                size--;
                occurred = true;
            }
        }

        if (!occurred)
            throw new Exception("Liczba nie wystąpiła!");
    }

    private void shiftListLeft(int beginning) {
        for (int i = beginning; i < size - 1; i++)
            nSet[i] = nSet[i + 1];
    }

    /**
     * Metoda losuje jedną liczbę ze zbioru oraz ją usuwa
     *
     * @return wylosowana liczba
     * @throws Exception występuje jeśli zbiór jest pustu
     **/
    public int getRandomValue() throws Exception {
        Random random = new Random();
        int randomVal = random.nextInt() % size;

        remove(randomVal);

        return randomVal;
    }

    /**
     * Metoda zwraca sumę elementów
     *
     * @return Suma liczb.
     * @throws Exception występuje jeśli zbiór jest pusty.
     */
    public int getSumOfElements() throws Exception {
        if (size == 0)
            throw new Exception("Zbiór jest pusty!");

        int sum = 0;

        for (int i = 0; i < size; i++)
            sum += nSet[i];

        return sum;
    }

    /**
     * Metoda dzieli każdy element zbioru przez podaną
     * wartość bez reszty
     *
     * @param d liczba przez którą dzielimy
     * @throws Exception występuje w przypadku dzielenia przez 0
     *                   (można zastąpić asercją)
     */
    public void divideAllElementsBy(int d) throws Exception {
        if (d == 0)
            throw new Exception("Nie można podzielić przez zero!");

        for (int i = 0; i < size; i++)
            nSet[i] = nSet[i] / d;
    }

    /**
     * Metoda sprawdza czy w zbiorze istnieje podany element
     *
     * @param i element do sprawdzenia
     * @return true w przypadku odnalezienia wartości, false w przeciwnym razie.
     */
    public boolean contains(int i) {
        for (int j = 0; j < size; j++)
            if (nSet[j] == i)
                return true;

        return false;
    }

    /**
     * Metoda zwraca rozmiar zbioru (liczbę elementów)
     *
     * @return rozmiar zbioru
     */
    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        NumberSet numberSet = new NumberSet();
        try {
            numberSet.add(5);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(numberSet.getSize());
    }
}