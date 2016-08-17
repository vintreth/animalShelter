package ru.test;

import ru.test.animalShelter.*;

import java.text.SimpleDateFormat;
import java.util.Collection;

/**
 * @author svip
 *         2016-08-17
 */
public class Main {

    public static void main(String[] args) {
        AnimalShelter animalShelter = new AnimalShelterImpl();
        try {
            animalShelter.addAnimal(Cat.class);
            animalShelter.addAnimal(Cat.class);
            animalShelter.addAnimal(Cat.class);
            animalShelter.addAnimal(Dog.class);
            animalShelter.addAnimal(Dog.class);
            animalShelter.addAnimal(Dog.class);
            animalShelter.addAnimal(Turtle.class);
            animalShelter.addAnimal(Turtle.class);
            animalShelter.addAnimal(Turtle.class);

            System.out.println("All animals:");
            printCollection(animalShelter.getAllAnimals());
            System.out.println("");

            System.out.println("All dogs sorted by name:");
            printCollection(animalShelter.getAllAnimalsByClass(Dog.class));
            System.out.println("");

            System.out.println("Oldest cat:");
            printObject(animalShelter.getOldestAnimalByClass(Cat.class));
            System.out.println("");

            System.out.println("Oldest animal:");
            printObject(animalShelter.getOldestAnimal());
            System.out.println("");
        } catch (AnimalShelterException e) {
            e.printStackTrace();
        }
    }

    private static void printCollection(Collection<? extends Animal> collection) {
        for (Animal animal : collection) {
            System.out.print("\t");
            printObject(animal);
        }

        System.out.println("");
        System.out.println("===================");
        System.out.println("");
    }

    private static void printObject(Animal animal) {
        System.out.println(
                animal.getClass().getSimpleName() + " " + animal.getName() + ", "
                        + "age: " + animal.getAge() + ", "
                        + new SimpleDateFormat("yyyy-MM-dd").format(animal.getDateAdded())
        );
    }
}
