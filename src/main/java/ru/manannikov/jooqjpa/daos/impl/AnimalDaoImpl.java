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
import ru.manannikov.jooqjpa.pojos.AnimalPojo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        List<Short> ranks
    ) {
        final Condition dynamicFilter = noCondition();
        if (ranks != null) {
            ranks.forEach(it -> dynamicFilter.and(ANIMALS.TAXONOMIC_RANK_ID.eq(it)));
        }

        final Query query = ctx.selectFrom(ANIMALS)
            .where(dynamicFilter)
            .limit(pageSize).offset(pageNumber > 0 ? (pageNumber - 1) * pageNumber : pageNumber);
        return nativeQuery(em, query, AnimalEntity.class);
    }

    @Override
    public List<AnimalPojo> findAll(
        String searchQuery
    ) {
        final var tr1 = TAXONOMIC_RANKS.as("tr1");
        final var tr2 = TAXONOMIC_RANKS.as("tr2");
        final var tr3 = TAXONOMIC_RANKS.as("tr3");
        final var tr4 = TAXONOMIC_RANKS.as("tr4");

        final var fields = List.of(
            ANIMALS.ANIMAL_RUSSIAN_NAME.as("russianName"),
            ANIMALS.ANIMAL_LATIN_NAME.as("latinName"),

            ANIMALS.ANIMAL_NATURAL_HABITAT.as("naturalHabitat"),
            ANIMALS.ANIMAL_IMAGE_URI.as("imageUri"),

            tr4.TAXONOMIC_RANK_NAME.as("animalClass"),
            tr3.TAXONOMIC_RANK_NAME.as("animalOrder"),
            tr2.TAXONOMIC_RANK_NAME.as("animalFamily"),
            tr1.TAXONOMIC_RANK_NAME.as("animalGenus")
        );

        final String fullTextSearchQuery = Arrays.stream(searchQuery.trim()
            .replaceAll("[&|!()<>]", "").split("\\s+"))
            .map(it -> it + ":*")
            .collect(Collectors.joining(" & "));
        final Condition searchFilter = condition(String.format("search_vector @@ to_tsquery('%s')", fullTextSearchQuery));

        return ctx
            .select(fields)
            .from(ANIMALS)
                .join(tr1).on(ANIMALS.TAXONOMIC_RANK_ID.eq(tr1.TAXONOMIC_RANK_ID))
                .leftJoin(tr2).on(tr1.TAXONOMIC_RANK_PARENT_ID.eq(tr2.TAXONOMIC_RANK_ID))
                .leftJoin(tr3).on(tr2.TAXONOMIC_RANK_PARENT_ID.eq(tr3.TAXONOMIC_RANK_ID))
                .leftJoin(tr4).on(tr3.TAXONOMIC_RANK_PARENT_ID.eq(tr4.TAXONOMIC_RANK_ID))

            .where(searchFilter)
            .fetchInto(AnimalPojo.class);
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