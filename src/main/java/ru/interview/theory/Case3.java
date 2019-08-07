package ru.interview.theory;

/**
 * Ниже представлены 2 класса, наследуемые от класса Thread
 * Опишите проблему данного кода и Ваши рекомендации по нему
 */
public class Case3 {

    public static Object lockOne = new Object();
    public static Object lockTwo = new Object();

    public static void main(String[] args) {
        FirstThread th1 = new FirstThread(lockOne, lockTwo, "FirstThread");
        SecondThread th2 = new SecondThread(lockTwo, lockOne, "SecondThread");
        th1.start();
        th2.start();
    }
}

class FirstThread extends Thread {

    final Object lockOne;
    final Object lockTwo;
    String name;

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
                System.out.println(name + " locking");
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

    public SecondThread(Object lockOne, Object lockTwo, String name) {
        super(lockOne, lockTwo, name);
    }
}