package ru.interview.fifth;

/**
 * Из кода вызывается метод класса, к которому у нас нет доступа.
 * Посмотрите этот класс и скажите, что будет выведено в консоль?
 */
public class Main {

    public static void main(String[] args) {
        new Unaccessable().doWork();
    }
}
