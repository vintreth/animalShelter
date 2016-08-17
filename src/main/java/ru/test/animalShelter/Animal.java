package ru.test.animalShelter;

import java.util.Date;

/**
 * @author svip
 *         2016-08-17
 */
public abstract class Animal implements Comparable {

    protected String name;

    protected Integer age;

    protected Date dateAdded;

    public Animal(String name, Integer age, Date dateAdded) {
        this.name = name;
        this.age = age;
        this.dateAdded = dateAdded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (!name.equals(animal.name)) return false;
        if (!age.equals(animal.age)) return false;

        return dateAdded.equals(animal.dateAdded);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age.hashCode();
        result = 31 * result + dateAdded.hashCode();

        return result;
    }

    @Override
    public int compareTo(Object o) {
        Animal animal = (Animal) o;
        int result = name.compareTo(animal.name);
        if (0 == result) {
            if (age.equals(animal.age) && dateAdded.equals(animal.dateAdded)) {
                return 0;
            } else {
                return 1;
            }
        }

        return result;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Date getDateAdded() {
        return dateAdded;
    }
}
