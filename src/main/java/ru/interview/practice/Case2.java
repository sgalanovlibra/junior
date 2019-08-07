package ru.interview.practice;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Необходимо реализовать метод printStringsByName, чтобы он выводил в терминал строки,
 *  содержащие подстроку MATCH вне зависимости от регистра строки в масиве
 */
public class Case2 {

    static String MATCH = "java";

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("oracle", "Java", "javaScript", "sql"));
        printStringsByName(list, MATCH);
    }

    private static void printStringsByName(List<String> list, final String match) {
        throw new NotImplementedException();
    }
}


