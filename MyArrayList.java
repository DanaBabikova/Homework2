import java.util.*;


/**
 * Моя реализация ArrayList
 * @author Бабикова Дана
 * @param <E> дженерик типа данных, который содержит MyArrayList
 */
public class MyArrayList <E>{

    private int size;

    private E[] values;


    /**
     * Конструктор моей реализации ArrayList, начальное значение вместимости массива = 10
     */
    public MyArrayList() {
        values = (E[]) new Object[10];
        size = 0;
    }


    /**
     * Увеличиваем вместимость массива
     */
    private void increaseSize() {
        int newCapacity = values.length * 2;
        E[] newValues = (E[]) new Object[newCapacity];
        for (int i = 0;i<= size -1; i ++) {
            newValues [i] = values[i];
        }
            values = newValues;
    }

    /**
     * С помощью метода add вставляем элемент в конец массива
     * @param e элемент, который мы добавляем
     * @return возвращает true, если операция прошла успешно
     */
    public boolean add(E e) {
        if (size >= values.length) {
            increaseSize();
        }
        values[size] = e;
        size ++;
        return true;
    }


    /**
     * С помощью метода add мы добавляем элемент в определенный индекс
     * @param e элемент, который мы добавляем
     * @param index индекс, на который мы добавляем элемент
     */
    public void add (E e, int index) {
        if (index<0) {
            return;
        }
        if (index > size) {
            return;
        }
        if (size >= values.length) {
            increaseSize();
        }
        for (int i = size - 1; i >= index; i --){
            values [i+1] = values [i];
        }
        values [index] = e;
        size ++;
    }


    /**
     * С помощью метода remove мы удаляем элемент в массиве под определенным индексом
     * @param index индекс элемента, который мы удаляем
     */
    public void remove(int index) {

        values[index] = null;
        for (int i = index +1; i <= size - 1; i ++) {
            values[i-1] = values[i];

        }
        values[size - 1] = null;
        size = size - 1;

    }


    /**
     * С помощью метода get получаем элемент
     * @param index индекс элемента, который мы получаем
     * @return возвращает значение элемента под определенным индексом
     */
    public E get(int index) {
        return values[index];
    }

    /**
     * С помощью метода clear очищаем всю коллекцию
     */
    public void clear() {
       for (int i = 0; i < size; i++) {
           values [i] = null;
       }
       size = 0;
    }


    /**
     * С помощью метода sort производим сортировку с помощью компаратора
     * @param c переменная компаратора
     */
    public void sort(Comparator<E> c) {
        Arrays.sort(values,c);
    }

    /**
     * @return возвращает количество элементов в массиве
     */
    public int size (){
        return size;
    }

    /**
     * С помощью метода update мы обновляем элемент массива
     * @param element элемент, который мы присваиваем
     * @param index индекс обновляемого элемента
     */
    public void update ( E element, int index) {
        values[index] = element;
    }

    /**
     * @return возвращает массив как строку
     */
    @Override
    public String toString() {
        return Arrays.toString(values);
    }
}

