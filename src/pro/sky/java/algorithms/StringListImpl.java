package pro.sky.java.algorithms;

import java.util.Arrays;

public class StringListImpl implements StringList {

    private int lengthArray = 2;
    private String[] list;
    private int size = 0;

    public StringListImpl() {
        list = new String[lengthArray];
    }

    @Override
    public String add(String item) {
        if (item == null) {
            throw new java.lang.NullPointerException();
        }
        list[size] = item;
        size++;
        if (size == lengthArray) {
            String[] timeArray = new String[(lengthArray += 2)];
            System.arraycopy(list, 0, timeArray, 0, size);
            list = timeArray;
        }
        return list[(size - 1)];
    }

    @Override
    public String add(int index, String item) {
        if (index < 0 || index >= size) {
            throw new InvalidInputDataException();
        }
        if (item == null) {
            throw new java.lang.NullPointerException();
        }
        String[] temporaryArray = new String[lengthArray];
        System.arraycopy(list, index, temporaryArray, (index + 1), (size - index));
        temporaryArray[index] = item;
        System.arraycopy(list, 0, temporaryArray, 0, index);
        list = temporaryArray;
        size++;
        if (size == lengthArray) {
            String[] timeArray = new String[(lengthArray += 2)];
            System.arraycopy(list, 0, timeArray, 0, size);
            list = timeArray;
        }
        return list[index];
    }

    @Override
    public String set(int index, String item) {
        if (index < 0 || index >= size) {
            throw new InvalidInputDataException();
        }
        if (item == null) {
            throw new java.lang.NullPointerException();
        }
        list[index] = item;
        return list[index];
    }

    @Override
    public String remove(String item) {
        if (item == null) {
            throw new java.lang.NullPointerException();
        }
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                while (i < (size - 1)) {
                    list[i] = list[(i + 1)];
                    i++;
                }
                list[(size - 1)] = null;
                size--;
                return item;
            }
        }
        throw new ArgumentNotFoundException();
    }

    @Override
    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new InvalidInputDataException();
        }
        String item = list[index];
        while (index < (size - 1)) {
            list[index] = list[(index + 1)];
            index++;
        }
        list[(size - 1)] = null;
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        if (item == null) {
            throw new java.lang.NullPointerException();
        }
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        if (item == null) {
            throw new java.lang.NullPointerException();
        }
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        if (item == null) {
            throw new java.lang.NullPointerException();
        }
        for (int i = (size - 1); i >= 0; i--) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new InvalidInputDataException();
        }
        return list[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.deepEquals(list, otherList.toArray());
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
        list = new String[lengthArray];
    }

    @Override
    public String[] toArray() {
        String[] timeArray = new String[lengthArray];
        System.arraycopy(list, 0, timeArray, 0, size);
        return timeArray;
    }
}
