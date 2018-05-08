import java.util.Random;

/**
 * Task is to implement methods marked as public based on their provided descriptions in comments. Then add as many asserts as we can.
 */

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
        assert nSet != null : "Tablica niezainicjalizowana!";

        if (size >= MAX_SIZE)
            throw new Exception("Zbiór przepełniony!");
        else {
            nSet[size] = i;
            size++;
        }

        assert contains(i) : "Element nie został dodany!";
    }

    /**
     * Metoda usuwa liczbę ze zbioru (każde wystąpienie)
     *
     * @param i liczba do usunięcia
     * @throws Exception występuje jeśli zbiór nie posiada liczby
     *                   którą chcemy usunąć
     */
    public void remove(int i) throws Exception {
        assert nSet != null : "Tablica niezainicjalizowana!";

        boolean occurred = false;

        for (int currentNo = 0; currentNo < size; currentNo++) {
            if (nSet[currentNo] == i) {
                shiftListLeft(currentNo);
                occurred = true;
                currentNo--; //Check new number at this index again
            }
        }

        assert !contains(i) : "Liczba nie została usunięta!";

        if (!occurred)
            throw new Exception("Liczba nie wystąpiła!");
    }

    /**
     * Przesuwa listę o jeden w lewo (rozpoczynając od beginning) nadpisując element znajdujący się pod indeksem beginning
     *
     * @param beginning indeks nadpisywanego elementu
     */
    private void shiftListLeft(int beginning) {
        assert nSet != null : "Tablica niezainicjalizowana!";

        System.arraycopy(nSet, beginning + 1, nSet, beginning, size - 1 - beginning);

        size--;
        assert size >= 0 : "Ilość elemnetów w tablicy jest niepoprawna!";
    }

    /**
     * Metoda losuje jedną liczbę ze zbioru oraz ją usuwa
     *
     * @return wylosowana liczba
     * @throws Exception występuje jeśli zbiór jest pustu
     **/
    public int getRandomValue() throws Exception {
        assert nSet != null : "Tablica niezainicjalizowana!";

        Random random = new Random();
        int randomVal = random.nextInt(size);

        assert randomVal >= 0 && randomVal < size : "Wylosowany indeks jest niepoprawny!";

        int noToDelete = nSet[randomVal];

        for (int i = 0; i < size; i++) {
            if (nSet[i] == noToDelete) {
                shiftListLeft(i);
                break;
            }
        }

        return noToDelete;
    }

    /**
     * Metoda zwraca sumę elementów
     *
     * @return Suma liczb.
     * @throws Exception występuje jeśli zbiór jest pusty.
     */
    public int getSumOfElements() throws Exception {
        assert nSet != null : "Tablica niezainicjalizowana!";

        boolean allNoPositive = true;

        if (size == 0)
            throw new Exception("Zbiór jest pusty!");

        int sum = 0;

        for (int i = 0; i < size; i++) {
            sum += nSet[i];

            if (nSet[i] < 0)
                allNoPositive = false;
        }

        assert !allNoPositive || sum >= 0 : "Suma liczb dodanich jest ujemna!";

        return sum;
    }

    /**
     * Metoda dzieli każdy element zbioru przez podaną
     * wartość bez reszty
     *
     * @param d liczba przez którą dzielimy
     */
    public void divideAllElementsBy(int d) {
        assert nSet != null : "Tablica niezainicjalizowana!";
        assert d != 0 : "Nie można podzielić przez 0!";

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
        assert nSet != null : "Tablica niezainicjalizowana!";
        assert size != 0 : "Tablica nie zawiera elementów!";

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
        assert nSet != null : "Tablica niezainicjalizowana!";
        return size;
    }

    public static void main(String[] args) {
        NumberSet numberSet = new NumberSet();

        try {
            for (int i = 0; i < 99; i++)
                numberSet.add(5);

            numberSet.add(6);
            numberSet.remove(5);
            numberSet.add(7);

            numberSet.divideAllElementsBy(2);

            System.out.println("Random val: " + numberSet.getRandomValue());
            System.out.println("Contains 5: " + numberSet.contains(5));
            System.out.println("Size: " + numberSet.getSize());
            System.out.println("Sum: " + numberSet.getSumOfElements());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}