CREATE EXTENSION IF NOT EXISTS pg_trgm;
CREATE INDEX taxonomic_rank_name_trgm_idx ON taxonomic_ranks
    USING GIN ("taxonomic_rank_name" gin_trgm_ops);