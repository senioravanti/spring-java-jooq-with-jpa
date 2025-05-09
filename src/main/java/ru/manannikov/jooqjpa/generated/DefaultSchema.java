/*
 * This file is generated by jOOQ.
 */
package ru.manannikov.jooqjpa.generated;


import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;

import ru.manannikov.jooqjpa.generated.tables.Animals;
import ru.manannikov.jooqjpa.generated.tables.TaxonomicRankTypes;
import ru.manannikov.jooqjpa.generated.tables.TaxonomicRanks;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class DefaultSchema extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>DEFAULT_SCHEMA</code>
     */
    public static final DefaultSchema DEFAULT_SCHEMA = new DefaultSchema();

    /**
     * The table <code>ANIMALS</code>.
     */
    public final Animals ANIMALS = Animals.ANIMALS;

    /**
     * The table <code>TAXONOMIC_RANK_TYPES</code>.
     */
    public final TaxonomicRankTypes TAXONOMIC_RANK_TYPES = TaxonomicRankTypes.TAXONOMIC_RANK_TYPES;

    /**
     * The table <code>TAXONOMIC_RANKS</code>.
     */
    public final TaxonomicRanks TAXONOMIC_RANKS = TaxonomicRanks.TAXONOMIC_RANKS;

    /**
     * No further instances allowed
     */
    private DefaultSchema() {
        super("", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            Animals.ANIMALS,
            TaxonomicRankTypes.TAXONOMIC_RANK_TYPES,
            TaxonomicRanks.TAXONOMIC_RANKS
        );
    }
}
