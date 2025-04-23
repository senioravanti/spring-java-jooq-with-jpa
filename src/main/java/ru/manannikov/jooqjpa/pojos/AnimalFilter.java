package ru.manannikov.jooqjpa.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnimalFilter {
    private String animalClass;
    private String animalOrder;
    private String animalFamily;
    private String animalGenus;
    private String animalSpecies;
}