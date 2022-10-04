package io.wimmelstein.hellofx.data;

import io.wimmelstein.hellofx.model.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private List<Person> people = new ArrayList<>();

    public Database() {

        people.addAll(
                List.of(
                        new Person("Abe", "Lincoln", LocalDate.of(1809, 2, 12)),
                        new Person("Jack", "Adams", LocalDate.of(1767, 7, 11))
                ));
    }

    public List<Person> getPeople() {
        return people;
    }
}
