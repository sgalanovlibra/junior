package ru.interview.second;

/**
 * Ниже представлены 2 класса, наследуемые от класса Thread
 * Какая в коде есть проблема? Как бы Вы её исправили?
 */
public class Locks {

    private static Object lockOne = new Object();
    private static Object lockTwo = new Object();

    public static void main(String[] args) {
        FirstThread th1 = new FirstThread(lockOne, lockTwo, "FirstThread");
        SecondThread th2 = new SecondThread(lockTwo, lockOne, "SecondThread");
        th1.start();
        th2.start();
    }
}

class FirstThread extends Thread {

    private final Object lockOne;
    private final Object lockTwo;
    private String name;

    FirstThread(Object lockOne, Object lockTwo, String name) {
        this.lockOne = lockOne;
        this.lockTwo = lockTwo;
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (this.lockOne) {
            System.out.println(name + " locking");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (this.lockTwo) {
                System.out.println(name + " unlocking");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class SecondThread extends FirstThread {

    SecondThread(Object lockOne, Object lockTwo, String name) {
        super(lockOne, lockTwo, name);
    }
}