package ru.manannikov.jooqjpa.daos.impl;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Query;
import org.springframework.stereotype.Repository;
import ru.manannikov.jooqjpa.daos.AnimalDao;
import ru.manannikov.jooqjpa.entities.AnimalEntity;
import ru.manannikov.jooqjpa.pojos.AnimalFilter;

import java.util.List;
import java.util.Optional;

import static org.jooq.impl.DSL.*;
import static ru.manannikov.jooqjpa.generated.Tables.*;
import static ru.manannikov.jooqjpa.utils.JpaUtils.*;
import static ru.manannikov.jooqjpa.utils.OptionalUtils.*;

@Repository("animalDao")
@RequiredArgsConstructor
public class AnimalDaoImpl
    implements AnimalDao
{
    private final DSLContext ctx;

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<AnimalEntity> findAll(
        int pageNumber, int pageSize,
        AnimalFilter animalFilter
    ) {
        final Condition dynamicFilter = noCondition();
        if (animalFilter.getAnimalClass() != null) {
            dynamicFilter.and(ANIMALS.ANIMAL_CLASS.eq(animalFilter.getAnimalClass()));
        }
        if (animalFilter.getAnimalOrder() != null) {
            dynamicFilter.and(ANIMALS.ANIMAL_ORDER.eq(animalFilter.getAnimalOrder()));
        }
        if (animalFilter.getAnimalFamily() != null) {
            dynamicFilter.and(ANIMALS.ANIMAL_FAMILY.eq(animalFilter.getAnimalFamily()));
        }
        if (animalFilter.getAnimalGenus() != null) {
            dynamicFilter.and(ANIMALS.ANIMAL_GENUS.eq(animalFilter.getAnimalGenus()));
        }
        if (animalFilter.getAnimalSpecies() != null) {
            dynamicFilter.and(ANIMALS.ANIMAL_SPECIES.eq(animalFilter.getAnimalSpecies()));
        }

        final Query query = ctx.selectFrom(ANIMALS)
            .where(dynamicFilter)
            .limit(pageSize).offset(pageNumber > 0 ? (pageNumber - 1) * pageNumber : pageNumber);
        return nativeQuery(em, query, AnimalEntity.class);
    }

    @Override
    public Optional<AnimalEntity> findById(Integer id) {
        final Query query = ctx.selectFrom(ANIMALS)
            .where(ANIMALS.ANIMAL_ID.eq(id));

        return fromThrowingSupplier(() -> nativeQuery(em, query, AnimalEntity.class).getFirst());
    }

    public Optional<AnimalEntity> findByRussianName(String russianName) {
        final Query query = ctx.selectFrom(ANIMALS)
            .where(ANIMALS.ANIMAL_RUSSIAN_NAME.eq(russianName));

        return fromThrowingSupplier(() -> nativeQuery(em, query, AnimalEntity.class).getFirst());
    }
}