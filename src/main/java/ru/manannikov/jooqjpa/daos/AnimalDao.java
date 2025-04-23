package ru.manannikov.jooqjpa.daos;

import ru.manannikov.jooqjpa.entities.AnimalEntity;
import ru.manannikov.jooqjpa.pojos.AnimalFilter;

import java.util.List;
import java.util.Optional;

public interface AnimalDao {
    List<AnimalEntity> findAll(
        int pageNumber, int pageSize,
        AnimalFilter animalFilter
    );
    Optional<AnimalEntity> findById(Integer id);
    Optional<AnimalEntity> findByRussianName(String russianName);
}