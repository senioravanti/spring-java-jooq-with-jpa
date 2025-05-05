ALTER TABLE animals
    ADD COLUMN IF NOT EXISTS search_vector tsvector GENERATED ALWAYS AS (
        setweight(to_tsvector('russian', animal_russian_name), 'A')
        || setweight(to_tsvector('english', animal_latin_name), 'B')
        || setweight(to_tsvector('russian', animal_natural_habitat), 'C')
    ) STORED;

CREATE INDEX animals_search_idx ON animals USING GIN (search_vector);
CREATE INDEX animals_russian_name_idx ON animals (animal_russian_name);
CREATE INDEX animals_taxonomic_rank_id_idx ON animals (taxonomic_rank_id);