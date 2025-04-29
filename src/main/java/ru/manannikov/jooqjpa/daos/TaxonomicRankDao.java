package ru.manannikov.jooqjpa.daos;

import ru.manannikov.jooqjpa.entities.TaxonomicRankEntity;

import java.util.Optional;

public interface TaxonomicRankDao {
    Optional<TaxonomicRankEntity> findByName(String name);
}