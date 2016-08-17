package ru.test.animalShelter;

/**
 * @author svip
 *         2016-08-17
 */
class TurtleNameGenerator extends NameGenerator {

    @Override
    protected String[] getNames() {
        return new String[] {
                "Lucky",
                "Columbus",
                "Marisol",
                "Victoria",
                "Francis"
        };
    }
}
