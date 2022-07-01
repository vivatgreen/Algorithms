package pro.sky.java.algorithms;
public interface IntegerList {

    int add(int item);

    int add(int index, int item);

    int set(int index, int item);

    int removeByValue(int item);

    int remove(int index);

    boolean contains(int item);

    int indexOf(int item);

    int lastIndexOf(int item);

    int get(int index);

    boolean equals(IntegerList otherList);

    int size();

    boolean isEmpty();

    void clear();

    int[] toArray();

    //Переработанный метод contains с бинарным поиском и сортировкой методом вставки
    boolean containsBinary (int item);

    //Переработанный метод contains c бинарным поиском и рекурсивной сортировкой
    boolean containsBinaryWithRecursionSort(int item);
}

