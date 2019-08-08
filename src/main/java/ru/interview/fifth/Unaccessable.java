package ru.interview.fifth;

public class Unaccessable {

    public void doWork() {
        notAccessableMethod();
    }

    private void notAccessableMethod() {
        System.out.println("Меня нельзя изменить обычным образом!");
    }
}

