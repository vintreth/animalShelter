package ru.test.animalShelter;

import java.util.Set;

/**
 * @author svip
 *         2016-08-17
 */
public interface AnimalShelter {

    void addAnimal(Class<? extends Animal> clazz) throws AnimalShelterException;

    Set<Animal> getAllAnimals();

    Set<Animal> getAllAnimalsByClass(Class<? extends Animal> clazz);

    Animal getOldestAnimalByClass(Class<? extends Animal> clazz);

    Animal getOldestAnimal();
}
