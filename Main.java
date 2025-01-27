public class Main {
    public static void main (String[] args) {
        MyArrayList <Integer> list = new MyArrayList<>();
        list.add(42);
        list.add(4);
        list.add(16);
        list.add(8);
        list.add(23);

        System.out.println(list);

        Sort.quickSort(list, Integer::compareTo);

        System.out.println(list);






    }
}
