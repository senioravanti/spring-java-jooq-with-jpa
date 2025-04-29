package ru.manannikov.jooqjpa.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.manannikov.jooqjpa.entities.AnimalEntity;

public interface AnimalRepo
    extends JpaRepository<AnimalEntity, Integer>
{
}