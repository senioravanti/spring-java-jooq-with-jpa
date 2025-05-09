/*
 * This file is generated by jOOQ.
 */
package ru.manannikov.jooqjpa.generated.tables;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.InverseForeignKey;
import org.jooq.Name;
import org.jooq.Path;
import org.jooq.PlainSQL;
import org.jooq.QueryPart;
import org.jooq.Record;
import org.jooq.SQL;
import org.jooq.Schema;
import org.jooq.Select;
import org.jooq.Stringly;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import ru.manannikov.jooqjpa.generated.DefaultSchema;
import ru.manannikov.jooqjpa.generated.Keys;
import ru.manannikov.jooqjpa.generated.tables.TaxonomicRanks.TaxonomicRanksPath;
import ru.manannikov.jooqjpa.generated.tables.records.AnimalsRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Animals extends TableImpl<AnimalsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>ANIMALS</code>
     */
    public static final Animals ANIMALS = new Animals();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AnimalsRecord> getRecordType() {
        return AnimalsRecord.class;
    }

    /**
     * The column <code>ANIMALS.ANIMAL_ID</code>.
     */
    public final TableField<AnimalsRecord, Integer> ANIMAL_ID = createField(DSL.name("ANIMAL_ID"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>ANIMALS.ANIMAL_RUSSIAN_NAME</code>.
     */
    public final TableField<AnimalsRecord, String> ANIMAL_RUSSIAN_NAME = createField(DSL.name("ANIMAL_RUSSIAN_NAME"), SQLDataType.VARCHAR(1000000000).nullable(false), this, "");

    /**
     * The column <code>ANIMALS.ANIMAL_LATIN_NAME</code>.
     */
    public final TableField<AnimalsRecord, String> ANIMAL_LATIN_NAME = createField(DSL.name("ANIMAL_LATIN_NAME"), SQLDataType.VARCHAR(1000000000).nullable(false), this, "");

    /**
     * The column <code>ANIMALS.TAXONOMIC_RANK_ID</code>.
     */
    public final TableField<AnimalsRecord, Short> TAXONOMIC_RANK_ID = createField(DSL.name("TAXONOMIC_RANK_ID"), SQLDataType.SMALLINT.nullable(false), this, "");

    /**
     * The column <code>ANIMALS.ANIMAL_NATURAL_HABITAT</code>.
     */
    public final TableField<AnimalsRecord, String> ANIMAL_NATURAL_HABITAT = createField(DSL.name("ANIMAL_NATURAL_HABITAT"), SQLDataType.VARCHAR(1000000000), this, "");

    /**
     * The column <code>ANIMALS.ANIMAL_IMAGE_URI</code>.
     */
    public final TableField<AnimalsRecord, String> ANIMAL_IMAGE_URI = createField(DSL.name("ANIMAL_IMAGE_URI"), SQLDataType.VARCHAR(1000000000).defaultValue(DSL.field(DSL.raw("NULL"), SQLDataType.VARCHAR)), this, "");

    private Animals(Name alias, Table<AnimalsRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Animals(Name alias, Table<AnimalsRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>ANIMALS</code> table reference
     */
    public Animals(String alias) {
        this(DSL.name(alias), ANIMALS);
    }

    /**
     * Create an aliased <code>ANIMALS</code> table reference
     */
    public Animals(Name alias) {
        this(alias, ANIMALS);
    }

    /**
     * Create a <code>ANIMALS</code> table reference
     */
    public Animals() {
        this(DSL.name("ANIMALS"), null);
    }

    public <O extends Record> Animals(Table<O> path, ForeignKey<O, AnimalsRecord> childPath, InverseForeignKey<O, AnimalsRecord> parentPath) {
        super(path, childPath, parentPath, ANIMALS);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class AnimalsPath extends Animals implements Path<AnimalsRecord> {

        private static final long serialVersionUID = 1L;
        public <O extends Record> AnimalsPath(Table<O> path, ForeignKey<O, AnimalsRecord> childPath, InverseForeignKey<O, AnimalsRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private AnimalsPath(Name alias, Table<AnimalsRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public AnimalsPath as(String alias) {
            return new AnimalsPath(DSL.name(alias), this);
        }

        @Override
        public AnimalsPath as(Name alias) {
            return new AnimalsPath(alias, this);
        }

        @Override
        public AnimalsPath as(Table<?> alias) {
            return new AnimalsPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<AnimalsRecord, Integer> getIdentity() {
        return (Identity<AnimalsRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<AnimalsRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_F;
    }

    @Override
    public List<UniqueKey<AnimalsRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.CONSTRAINT_F7, Keys.CONSTRAINT_F7B);
    }

    @Override
    public List<ForeignKey<AnimalsRecord, ?>> getReferences() {
        return Arrays.asList(Keys.FK_ANIMAL_DESCRIBED_BY_TAXONOMIC_RANK);
    }

    private transient TaxonomicRanksPath _taxonomicRanks;

    /**
     * Get the implicit join path to the <code>TAXONOMIC_RANKS</code> table.
     */
    public TaxonomicRanksPath taxonomicRanks() {
        if (_taxonomicRanks == null)
            _taxonomicRanks = new TaxonomicRanksPath(this, Keys.FK_ANIMAL_DESCRIBED_BY_TAXONOMIC_RANK, null);

        return _taxonomicRanks;
    }

    @Override
    public Animals as(String alias) {
        return new Animals(DSL.name(alias), this);
    }

    @Override
    public Animals as(Name alias) {
        return new Animals(alias, this);
    }

    @Override
    public Animals as(Table<?> alias) {
        return new Animals(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Animals rename(String name) {
        return new Animals(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Animals rename(Name name) {
        return new Animals(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Animals rename(Table<?> name) {
        return new Animals(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Animals where(Condition condition) {
        return new Animals(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Animals where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Animals where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Animals where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Animals where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Animals where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Animals where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Animals where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Animals whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Animals whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
