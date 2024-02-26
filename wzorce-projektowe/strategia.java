// Strategia jest wzorcem behawioralnym, który okresla rodzinę algorytmów, enkapsuluje ją i pozwala wymiennie z nich korzystać.
// Pozwala na odseparowanie algorytmów od wykorzystujących ich klientów oraz wybierania ich w trakcie wykonywania kodu.

// Interfejs strategii
interface SortingStrategy {
    void sort(int[] array);
}

// Strategie
class BubbleSort implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        System.out.println("Sorting using Bubble Sort");
    }
}

class MergeSort implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        System.out.println("Sorting using Merge Sort");
    }
}

class QuickSort implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        System.out.println("Sorting using Quick Sort");
    }
}

// Kontekst
class Sorter {
    private SortingStrategy sortingStrategy;

    public Sorter(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void performSort(int[] array) {
        sortingStrategy.sort(array);
    }
}

public class StrategyPatternExample {
    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 4};

        // inicjalizacja kontekstu strategii
        Sorter sorter = new Sorter(new BubbleSort());
        // przykład modyfikacji obranej strategii w trakcie wykonania
        if (array.length >= 10) {
            sorter.setSortingStrategy(new QuickSort());
        } else if (array.length >= 4) {
            sorter.setSortingStrategy(new MergeSort());
        }

        sorter.performSort(array);
    }
}
