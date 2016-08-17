package ru.test.animalShelter;

import java.util.Random;

/**
 * @author svip
 *         2016-08-17
 */
abstract class NameGenerator {

    public String getRandomName() {
        String[] names = getNames();
        int index = new Random().nextInt(names.length);

        return names[index];
    }

    protected abstract String[] getNames();
}
