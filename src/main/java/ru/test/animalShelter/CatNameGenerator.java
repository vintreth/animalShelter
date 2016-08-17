package ru.test.animalShelter;

/**
 * @author svip
 *         2016-08-17
 */
class CatNameGenerator extends NameGenerator {

    @Override
    protected String[] getNames() {
        return new String[] {
                "Oliver",
                "Tiger",
                "Lucy",
                "Luna",
                "Jack",
                "Sophie"
        };
    }
}
