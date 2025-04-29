package ru.manannikov.jooqjpa.daos;

import ru.manannikov.jooqjpa.entities.AnimalEntity;

import java.util.List;
import java.util.Optional;

public interface AnimalDao {
    List<AnimalEntity> findAll(
        int pageNumber, int pageSize,
        List<Short> ranks
    );
    Optional<AnimalEntity> findById(Integer id);
    Optional<AnimalEntity> findByRussianName(String russianName);
}