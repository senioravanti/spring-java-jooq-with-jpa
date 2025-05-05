package ru.manannikov.jooqjpa.pojos;

public record AnimalPojo(
    String russianName,
    String latinName,

    String naturalHabitat,
    String imageUri,

    String animalClass,
    String animalOrder,
    String animalFamily,
    String animalGenus
) {}