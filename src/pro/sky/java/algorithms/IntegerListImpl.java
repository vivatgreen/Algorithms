package pro.sky.java.algorithms;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {

    private int lengthArray = 3;
    private int[] list;
    private int size = 0;

    public IntegerListImpl() {
        list = new int[lengthArray];
    }

    @Override
    public int add(int item) {
        if (item < 0) {
            throw new InvalidInputDataException();
        }
        list[size] = item;
        size++;
        if (size == lengthArray) {
            grow();
        }
        return list[(size - 1)];
    }

    @Override
    public int add(int index, int item) {
        if (index < 0 || index >= size || item < 0) {
            throw new InvalidInputDataException();
        }
        int[] temporaryArray = new int[lengthArray];
        System.arraycopy(list, index, temporaryArray, (index + 1), (size - index));
        temporaryArray[index] = item;
        System.arraycopy(list, 0, temporaryArray, 0, index);
        list = temporaryArray;
        size++;
        if (size == lengthArray) {
            grow();
        }
        return list[index];
    }

    @Override
    public int set(int index, int item) {
        if (index < 0 || index >= size || item < 0) {
            throw new InvalidInputDataException();
        }
        list[index] = item;
        return list[index];
    }

    @Override
    public int removeByValue(int item) {
        if (item < 0) {
            throw new InvalidInputDataException();
        }
        for (int i = 0; i < size; i++) {
            if (list[i] == item) {
                while (i < (size - 1)) {
                    list[i] = list[(i + 1)];
                    i++;
                }
                list[(size - 1)] = 0;
                size--;
                if (size < (lengthArray / 2)) {
                    resize();
                }
                return item;
            }
        }
        throw new ArgumentNotFoundException();
    }

    @Override
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new InvalidInputDataException();
        }
        int item = list[index];
        while (index < (size - 1)) {
            list[index] = list[(index + 1)];
            index++;
        }
        list[(size - 1)] = 0;
        size--;
        if (size < (lengthArray / 2)) {
            resize();
        }
        return item;
    }

    @Override
    public boolean contains(int item) {
        if (item < 0) {
            throw new InvalidInputDataException();
        }
        for (int i = 0; i < size; i++) {
            if (list[i] == item) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(int item) {
        if (item < 0) {
            throw new InvalidInputDataException();
        }
        for (int i = 0; i < size; i++) {
            if (list[i] == item) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int item) {
        if (item < 0) {
            throw new InvalidInputDataException();
        }
        for (int i = (size - 1); i >= 0; i--) {
            if (list[i] == item) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new InvalidInputDataException();
        }
        return list[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(list, otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        lengthArray = 10;
        size = 0;
        list = new int[lengthArray];
    }

    @Override
    public int[] toArray() {
        int[] timeArray = new int[lengthArray];
        System.arraycopy(list, 0, timeArray, 0, size);
        return timeArray;
    }

    //Переработанный метод contains c использованием бинарного поиска и сортировки методом вставки
    @Override
    public boolean containsBinary(int item) {
        return binarySearch(list, item);
    }

    //Переработанный метод contains c использованием бинарного поиска и рекурсивной сортировки
    @Override
    public boolean containsBinaryWithRecursionSort(int item) {
        return binarySearchWithRecursion(list, item);
    }

    //Метод бинарного поиска с использованием сортировки методом вставки
    private boolean binarySearch(int[] arr, int element) {
        int[] arrCopy = Arrays.copyOf(arr, lengthArray);
        sortInsertion(arrCopy);
        int min = 0;
        int max = arr.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (element == arrCopy[mid]) {
                return true;
            }
            if (element < arrCopy[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    //Метод бинарного поиска с использованием рекурсивной сортировки
    private boolean binarySearchWithRecursion(int[] arr, int element) {
        int[] arrCopy = Arrays.copyOf(arr, lengthArray);
        quickSort(arrCopy, 0, lengthArray - 1);
        int min = 0;
        int max = arrCopy.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (element == arrCopy[mid]) {
                return true;
            }
            if (element < arrCopy[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    //Сортировка методом вставки
    private void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++)   {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp)   {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    //Быстрая сортировка с применением рекурсии
    public static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }
    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                swapElements(arr, i, j);
            }
        }
        swapElements(arr, i + 1, end);
        return i + 1;
    }
    private static void swapElements(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    //Метод расширения массива-хранилища
    private void grow() {
        lengthArray = (int) (lengthArray * 1.5);
        int[] timeArray = new int[lengthArray];
        System.arraycopy(list, 0, timeArray, 0, size);
        list = timeArray;
    }

    //Метод уменьшения массива-хранилища
    private void resize() {
        lengthArray = (int) (lengthArray * 0.67);
        int[] timeArray = new int[lengthArray];
        System.arraycopy(list, 0, timeArray, 0, size);
        list = timeArray;
    }
}
