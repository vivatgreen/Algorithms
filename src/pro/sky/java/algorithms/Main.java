package pro.sky.java.algorithms;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// Для проверки
        String s1 = "Hello";
        String s2 = "Maksym";
        String s3 = "Voronov";
        String s4 = "Abramovich";
        String s5 = "My friend";
        String s6 = "Good";
        String s7 = "Human";

        StringList list = new StringListImpl();
        System.out.println("Добавлен в список - " + list.add(s1));
        System.out.println("Добавлен в список - " + list.add(s2));
        System.out.println("Добавлен в список - " + list.add(s3));
        System.out.println("Добавлен в список - " + list.add(s4));
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println("Добавлен в список по индексу 1: " + list.add(1, s5));
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println("По индексу: 2 установлен элемент: " + list.set(2, s6));
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println("Удален элемент: " + list.remove(s6));
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println("Удален элемент с индексом: 2 - " + list.remove(2));
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.contains(s5));
        System.out.println(list.indexOf(s3));
        System.out.println(list.lastIndexOf(s4));
        System.out.println(list.get(2));
    }
}
