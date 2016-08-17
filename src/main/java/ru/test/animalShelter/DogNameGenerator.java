package ru.test.animalShelter;

/**
 * @author svip
 *         2016-08-17
 */
class DogNameGenerator extends NameGenerator {

    @Override
    protected String[] getNames() {
        return new String[] {
                "Bigson",
                "Bazuka",
                "Giant",
                "Seven",
                "Toby"
        };
    }
}
