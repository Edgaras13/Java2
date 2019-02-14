package Exercise1;

import java.io.Serializable;

public class Person implements Serializable {

    String name;
    String surname;
    long id;

    public Person(String name, String surname, long id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                '}';
    }
}
