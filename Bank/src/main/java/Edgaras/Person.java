package Edgaras;

import java.util.Objects;

public class Person {
    private int id;
    private String name;
    private String surname;
    private static int count = 0;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.id = count++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                name.equals(person.name) &&
                surname.equals(person.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname);
    }
}
