DROP TABLE IF EXISTS animals;
DROP TABLE IF EXISTS taxonomic_ranks;
DROP TABLE IF EXISTS taxonomic_rank_types;

CREATE TABLE taxonomic_rank_types (
    taxonomic_rank_type_id smallint GENERATED BY DEFAULT AS IDENTITY,
    taxonomic_rank_type_name text NOT NULL UNIQUE,

    PRIMARY KEY (taxonomic_rank_type_id)
);

CREATE TABLE taxonomic_ranks (
    taxonomic_rank_id smallint GENERATED BY DEFAULT AS IDENTITY,

    taxonomic_rank_parent_id smallint DEFAULT NULL,
    taxonomic_rank_type smallint NOT NULL,

    taxonomic_rank_name text NOT NULL UNIQUE,

    CONSTRAINT fk_taxomic_rank_has_type
        FOREIGN KEY (taxonomic_rank_type) REFERENCES taxonomic_rank_types (taxonomic_rank_type_id)
            ON DELETE CASCADE
            ON UPDATE RESTRICT,

    CONSTRAINT fk_taxomic_rank_level
        FOREIGN KEY (taxonomic_rank_parent_id) REFERENCES taxonomic_ranks (taxonomic_rank_id)
            ON DELETE CASCADE
            ON UPDATE RESTRICT,

    PRIMARY KEY (taxonomic_rank_id)
);