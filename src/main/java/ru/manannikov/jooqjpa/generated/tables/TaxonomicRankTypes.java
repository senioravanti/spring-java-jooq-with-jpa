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
import ru.manannikov.jooqjpa.generated.tables.records.TaxonomicRankTypesRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class TaxonomicRankTypes extends TableImpl<TaxonomicRankTypesRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>TAXONOMIC_RANK_TYPES</code>
     */
    public static final TaxonomicRankTypes TAXONOMIC_RANK_TYPES = new TaxonomicRankTypes();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TaxonomicRankTypesRecord> getRecordType() {
        return TaxonomicRankTypesRecord.class;
    }

    /**
     * The column <code>TAXONOMIC_RANK_TYPES.TAXONOMIC_RANK_TYPE_ID</code>.
     */
    public final TableField<TaxonomicRankTypesRecord, Short> TAXONOMIC_RANK_TYPE_ID = createField(DSL.name("TAXONOMIC_RANK_TYPE_ID"), SQLDataType.SMALLINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>TAXONOMIC_RANK_TYPES.TAXONOMIC_RANK_TYPE_NAME</code>.
     */
    public final TableField<TaxonomicRankTypesRecord, String> TAXONOMIC_RANK_TYPE_NAME = createField(DSL.name("TAXONOMIC_RANK_TYPE_NAME"), SQLDataType.VARCHAR(1000000000).nullable(false), this, "");

    private TaxonomicRankTypes(Name alias, Table<TaxonomicRankTypesRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private TaxonomicRankTypes(Name alias, Table<TaxonomicRankTypesRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>TAXONOMIC_RANK_TYPES</code> table reference
     */
    public TaxonomicRankTypes(String alias) {
        this(DSL.name(alias), TAXONOMIC_RANK_TYPES);
    }

    /**
     * Create an aliased <code>TAXONOMIC_RANK_TYPES</code> table reference
     */
    public TaxonomicRankTypes(Name alias) {
        this(alias, TAXONOMIC_RANK_TYPES);
    }

    /**
     * Create a <code>TAXONOMIC_RANK_TYPES</code> table reference
     */
    public TaxonomicRankTypes() {
        this(DSL.name("TAXONOMIC_RANK_TYPES"), null);
    }

    public <O extends Record> TaxonomicRankTypes(Table<O> path, ForeignKey<O, TaxonomicRankTypesRecord> childPath, InverseForeignKey<O, TaxonomicRankTypesRecord> parentPath) {
        super(path, childPath, parentPath, TAXONOMIC_RANK_TYPES);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class TaxonomicRankTypesPath extends TaxonomicRankTypes implements Path<TaxonomicRankTypesRecord> {

        private static final long serialVersionUID = 1L;
        public <O extends Record> TaxonomicRankTypesPath(Table<O> path, ForeignKey<O, TaxonomicRankTypesRecord> childPath, InverseForeignKey<O, TaxonomicRankTypesRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private TaxonomicRankTypesPath(Name alias, Table<TaxonomicRankTypesRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public TaxonomicRankTypesPath as(String alias) {
            return new TaxonomicRankTypesPath(DSL.name(alias), this);
        }

        @Override
        public TaxonomicRankTypesPath as(Name alias) {
            return new TaxonomicRankTypesPath(alias, this);
        }

        @Override
        public TaxonomicRankTypesPath as(Table<?> alias) {
            return new TaxonomicRankTypesPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<TaxonomicRankTypesRecord, Short> getIdentity() {
        return (Identity<TaxonomicRankTypesRecord, Short>) super.getIdentity();
    }

    @Override
    public UniqueKey<TaxonomicRankTypesRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_E;
    }

    @Override
    public List<UniqueKey<TaxonomicRankTypesRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.CONSTRAINT_E6);
    }

    private transient TaxonomicRanksPath _taxonomicRanks;

    /**
     * Get the implicit to-many join path to the <code>TAXONOMIC_RANKS</code>
     * table
     */
    public TaxonomicRanksPath taxonomicRanks() {
        if (_taxonomicRanks == null)
            _taxonomicRanks = new TaxonomicRanksPath(this, null, Keys.FK_TAXOMIC_RANK_HAS_TYPE.getInverseKey());

        return _taxonomicRanks;
    }

    @Override
    public TaxonomicRankTypes as(String alias) {
        return new TaxonomicRankTypes(DSL.name(alias), this);
    }

    @Override
    public TaxonomicRankTypes as(Name alias) {
        return new TaxonomicRankTypes(alias, this);
    }

    @Override
    public TaxonomicRankTypes as(Table<?> alias) {
        return new TaxonomicRankTypes(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public TaxonomicRankTypes rename(String name) {
        return new TaxonomicRankTypes(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TaxonomicRankTypes rename(Name name) {
        return new TaxonomicRankTypes(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public TaxonomicRankTypes rename(Table<?> name) {
        return new TaxonomicRankTypes(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public TaxonomicRankTypes where(Condition condition) {
        return new TaxonomicRankTypes(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public TaxonomicRankTypes where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public TaxonomicRankTypes where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public TaxonomicRankTypes where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public TaxonomicRankTypes where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public TaxonomicRankTypes where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public TaxonomicRankTypes where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public TaxonomicRankTypes where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public TaxonomicRankTypes whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public TaxonomicRankTypes whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
