# JOOQ

## Примеры SQL запросов

```sql
WITH search_queries AS (
    SELECT to_tsquery('russian', 'бел:* & пол:*') "q1"
)
SELECT animal_id,
    ts_rank(search_vector, (SELECT q1 FROM search_queries)) "r",
    animal_russian_name, animal_latin_name,
    animal_natural_habitat
FROM public.animals

WHERE search_vector @@ (SELECT q1 FROM search_queries)
ORDER BY "r" DESC;
```

Нечёткий поиск

```sql
SELECT
     tr1_name "animalClass",
     tr2_name "animalOrder",
     tr3_name "animalFamily",
     tr4_name "animalGenus"
FROM
    (SELECT
         tr1.taxonomic_rank_name tr1_name,
         tr2.taxonomic_rank_name tr2_name,
         tr3.taxonomic_rank_name tr3_name,
         tr4.taxonomic_rank_name tr4_name

    FROM
        taxonomic_ranks tr1
            LEFT JOIN taxonomic_ranks tr2
                      ON tr1.taxonomic_rank_id = tr2.taxonomic_rank_parent_id
            LEFT JOIN taxonomic_ranks tr3
                      ON tr2.taxonomic_rank_id = tr3.taxonomic_rank_parent_id
            LEFT JOIN taxonomic_ranks tr4
                      ON tr3.taxonomic_rank_id = tr4.taxonomic_rank_parent_id

    WHERE
          tr1.taxonomic_rank_type = 1
      AND tr2.taxonomic_rank_type = 2
      AND tr3.taxonomic_rank_type = 3
      AND tr4.taxonomic_rank_type = 4) _
WHERE tr4_name % 'Енот';
```