package ru.manannikov.jooqjpa.daos.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Query;
import org.springframework.stereotype.Repository;
import ru.manannikov.jooqjpa.daos.TaxonomicRankDao;
import ru.manannikov.jooqjpa.entities.AnimalEntity;
import ru.manannikov.jooqjpa.entities.TaxonomicRankEntity;

import java.util.Optional;

import static org.jooq.impl.DSL.*;
import static ru.manannikov.jooqjpa.utils.JpaUtils.*;
import static ru.manannikov.jooqjpa.generated.Tables.*;
import static ru.manannikov.jooqjpa.utils.OptionalUtils.*;

@Repository("taxonomicRankDao")
@RequiredArgsConstructor
public class TaxonomicRankDaoImpl
    implements TaxonomicRankDao
{
    private final DSLContext ctx;

    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<TaxonomicRankEntity> findByName(String name) {
        final Query query = ctx.selectFrom(TAXONOMIC_RANKS)
            .where(TAXONOMIC_RANKS.TAXONOMIC_RANK_NAME.eq(name));

        return fromThrowingSupplier(() -> nativeQuery(em, query, TaxonomicRankEntity.class).getFirst());
    }
}