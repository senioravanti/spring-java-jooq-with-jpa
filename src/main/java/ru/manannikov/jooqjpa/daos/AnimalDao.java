package ru.manannikov.jooqjpa.daos;

import ru.manannikov.jooqjpa.entities.AnimalEntity;
import ru.manannikov.jooqjpa.pojos.AnimalPojo;

import java.util.List;
import java.util.Optional;

public interface AnimalDao {
    List<AnimalEntity> findAll(
        int pageNumber, int pageSize,
        List<Short> ranks
    );
    List<AnimalPojo> findAll(
        String searchQuery
    );

    Optional<AnimalEntity> findById(Integer id);
    Optional<AnimalEntity> findByRussianName(String russianName);
}