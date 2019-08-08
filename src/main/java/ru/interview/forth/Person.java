package ru.interview.forth;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Требуется отрефакторить код
 */
public class Person {

    private String firstName;
    private String lastName;
    public Date birthDate;
    private Boolean male;

    public Person(String firstName, String lastName, Date birthDate, Boolean male) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.male = male;
    }

    Person() {
        this(new String("qwe"), "lastName", new Date(), false);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getGender() {
        return male;
    }

    public void setGender(Boolean gender) {
        this.male = gender;
    }

}

class PersonFinder {

    private static List<Person> PERSONS = new ArrayList<>();

    public static void main(String[] args) {
        PERSONS.add(new Person());
        PERSONS.add(new Person("Евгения", "Степанова", convertStringToDate("16/09/2000"), false));
        PERSONS.add(new Person("Сергей", "Галанов", convertStringToDate("15/07/1993"), true));
        PERSONS.add(new Person("Александр", "Ильин", convertStringToDate("11/10/1989"), true));

        System.out.println(isPersonExists(new Person("Александр", "Ильин", convertStringToDate("11/10/1989"), true)));
        System.out.println(isPersonExists(new Person("Анна", "Жукова", convertStringToDate("17/10/1995"), false)));
    }

    /**
     * Выводит информацию о строке
     * @param person
     * @return
     */
    private static boolean isPersonExists(Person person) {
        List<Person> result = new ArrayList<>();
        PERSONS.stream()
                .filter((el -> el.getFirstName().equals(person.getFirstName())
                                && el.getLastName().equals(person.getLastName())
                                && el.getGender().equals(person.getGender())
                                && el.getBirthDate().equals(person.getBirthDate())))
                .collect(Collectors.toCollection(() ->result));
        if (result.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }


    /**
     * Перевод строки в Date
     * @param date - строка формата день/месяц/год
     * @return обьект Date, эквивалентный данной строке
     */
    private static Date convertStringToDate(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date result = new Date();
        try {
            result = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}
