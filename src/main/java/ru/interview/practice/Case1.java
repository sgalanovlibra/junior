package ru.interview.practice;

/**
 * Дан класс, реализующий проверку наличия драйвера jdbc
 * Перепишите класс, что бы он проверял наличие драйвера при инициализации класса
 */
public class Case1 {
    public static void main(String[] args) {
        new DbConnector();
    }
}

class DbConnector {

    boolean isDriverAvailable;

    DbConnector() {
        try {
            Class.forName("com.example.jdbc.Driver");
            isDriverAvailable = true;
            //DO SMTH
        } catch (ClassNotFoundException e) {
            isDriverAvailable = false;
            throw new ExceptionInInitializerError("Cannot load JDBC driver.");
        }
    }

    public boolean isDriverAvailable() {
        return isDriverAvailable;
    }

}
