import java.util.Comparator;

/**
 * Класс содержащий методы для сортировки MyArrayList
 * @author Бабикова Дана
 */
public class Sort {
    /**
     * Метод quickSort вызывает внутри метод quickSortByIndex, в котором происходит сортировка в указанном диапазоне индексов
     * @param input входящий MyArrayList
     * @param comparator отвечает за сравнение
     * @param <E> дженерик типа данных, которые содержит MyArrayList
     */
    public static <E> void quickSort(MyArrayList<E> input, Comparator<E> comparator) {
        quickSortByIndex(input, comparator, 0, input.size() - 1);

    }

    /**
     * Метод для сортировки MyArrayList в заданном диапазоне значений индексов
     * Внутри метода quickSortByIndex происходит деление массива на подмассивы с помощью рекурсии
     * Если начальное значение индекса будет >= конечному значению индекса, то метод завершаем
     * Выбираем опорный элемент - правый последний элемент (pivot)
     * i перемещаем вправо, пока значение меньше pivot, а j перемещаем влево, пока значение больше pivot
     * @param input входящий MyArrayList
     * @param comparator отвечает за сравнение
     * @param left начальное значение индекса
     * @param right конечное значение индекса
     * @param <E> дженерик типа данных, которые содержит MyArrayList
     * С помощью метода swap i и j меняем местами
     */
    private static <E> void quickSortByIndex(MyArrayList<E> input, Comparator<E> comparator, int left,int right) {
        if (left>=right) {
            return;
        }
        int pivot = right;
        int i = left;
        int j = pivot - 1;
        while (i<=j) {
            while ((comparator.compare(input.get(i),input.get(pivot)) < 0) && i < pivot) {
                i++;
            }
            while (j>=left && (comparator.compare(input.get(j),input.get(pivot)) > 0)) {
                j--;
            }
            if (i < j) {
                swap(input, i, j);
                i++;
                j--;
            }

        }
        Sort.<E>swap(input, i, pivot);
        quickSortByIndex(input, comparator, left,i-1);
        quickSortByIndex(input, comparator, i+1, right);
    }

    /**
     * Метод меняет местами два элемента в MyArrayList
     * @param input входящий MyArrayList
     * @param a индекс первого элемента
     * @param b индекс второго элемента
     * @param <E> дженерик типа данных, которые содержит MyArrayList
     */
    private static <E> void swap(MyArrayList<E> input, int a, int b) {
        E temp = input.get(a);
        input.update(input.get(b), a);
        input.update(temp, b);
    }
}
