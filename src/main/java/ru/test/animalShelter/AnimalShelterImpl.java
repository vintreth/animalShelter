package ru.test.animalShelter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author svip
 *         2016-08-17
 */
public class AnimalShelterImpl implements AnimalShelter {

    private Set<Animal> animals = new HashSet<>();

    @Override
    public void addAnimal(Class<? extends Animal> clazz) throws AnimalShelterException {
        try {
            Animal animal = clazz
                .getDeclaredConstructor(String.class, Integer.class, Date.class)
                .newInstance(getNameGenerator(clazz).getRandomName(), defineAnimalAge(), defineDateAdded());

            animals.add(animal);
        } catch (ReflectiveOperationException e) {
            throw new AnimalShelterException("Failure to add animal to the shelter", e);
        }
    }

    @Override
    public Set<Animal> getAllAnimals() {
        return animals;
    }

    @Override
    public Set<Animal> getAllAnimalsByClass(Class<? extends Animal> clazz) {
        return new TreeSet<>(animalsByClass(clazz));
    }

    @Override
    public Animal getOldestAnimalByClass(Class<? extends Animal> clazz) {
        List<Animal> animals = new ArrayList<>(animalsByClass(clazz));
        Collections.sort(
            animals,
            (Animal animal1, Animal animal2) -> animal1.getDateAdded().compareTo(animal2.getDateAdded())
        );

        return animals.get(0);
    }

    @Override
    public Animal getOldestAnimal() {
        List<Animal> animals = new ArrayList<>(this.animals);
        Collections.sort(
            animals,
            (Animal animal1, Animal animal2) -> animal1.getDateAdded().compareTo(animal2.getDateAdded())
        );

        return animals.get(0);
    }

    private Set<Animal> animalsByClass(Class<? extends Animal> clazz) {
        Set<Animal> animals = new HashSet<>();
        for (Animal animal : this.animals) {
            if (animal.getClass().equals(clazz)) {
                animals.add(animal);
            }
        }

        return animals;
    }

    private Integer defineAnimalAge() {
        return new Random().nextInt(20);
    }

    private NameGenerator getNameGenerator(Class<? extends Animal> clazz) throws NameGeneratorException {
        String generatorName = clazz.getName() + "NameGenerator";
        try {
            return (NameGenerator) Class.forName(generatorName).newInstance();
        } catch (ClassNotFoundException e) {
            throw new NameGeneratorException("Cannot find name generator for " + generatorName, e);
        } catch (ReflectiveOperationException e) {
            throw new NameGeneratorException("Failure to create instance for " + generatorName, e);
        }
    }

    private Date defineDateAdded() {
        int datesLength = 100;
        Random random = new Random();
        String[] dates = new String[datesLength];
        for (int i = 0; i < datesLength; i++) {
            int mInt = random.nextInt(12) + 1;
            String m = mInt < 10 ? "0" + mInt : String.valueOf(mInt);

            int dInt = random.nextInt(28) + 1;
            String d = dInt < 10 ? "0" + dInt : String.valueOf(dInt);

            dates[i] = "2015-" + m + "-" + d;
        }

        try {
            String date = dates[random.nextInt(dates.length)];

            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new Date();
    }
}
