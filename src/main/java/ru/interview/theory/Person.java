package ru.interview.theory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Укажите какие здесь допущены ошибки
 */
public class Person {

    private String firstName;
    private String lastName;
    public Date birthDate;
    private Boolean isMan;

    public Person(String firstName, String lastName, Date birthDate, Boolean isMan) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.isMan = isMan;
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
        return isMan;
    }

    public void setGender(Boolean gender) {
        this.isMan = gender;
    }

}

class Test {

    private static List<Person> PERSONS = new ArrayList<>();

    public static void main(String[] args) {
        PERSONS.add(new Person());
        PERSONS.add(new Person("Andrey", "Ivanov", convertStringToDate("01/05/2019"), true));
        PERSONS.add(new Person("Sergey", "Galanov", convertStringToDate("03/3/2017"), false));

        System.out.println(findSamePerson(new Person("Andrey", "Ivanov", convertStringToDate("01/05/2019"), true)).size());
    }

    /**
     * Выводит информацию о строке
     * @param person
     * @return
     */
    private static List<Person> findSamePerson(Person person) {
        List<Person> result = new ArrayList<>();
        PERSONS.stream()
                .filter((el -> el.getFirstName().equals(person.getFirstName())
                                && el.getLastName().equals(person.getLastName())
                                && el.getGender().equals(person.getGender())
                                && el.getBirthDate().equals(person.getBirthDate())))
                .collect(Collectors.toCollection(() ->result));
        return result;
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
