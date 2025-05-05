package ru.manannikov.jooqjpa.daos.testcontainers;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jooq.AutoConfigureJooq;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import ru.manannikov.jooqjpa.config.JooqConfig;
import ru.manannikov.jooqjpa.daos.AbstractIntegrationTest;
import ru.manannikov.jooqjpa.daos.AnimalDao;
import ru.manannikov.jooqjpa.daos.impl.AnimalDaoImpl;
import ru.manannikov.jooqjpa.pojos.AnimalPojo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@ActiveProfiles("test-testcontainers")
@DataJpaTest
@AutoConfigureJooq
@Import(value = { JooqConfig.class, AnimalDaoImpl.class })
public class AnimalDaoTestcontainersTests
    extends AbstractIntegrationTest
{
    @Autowired
    AnimalDao animalDao;

    @Test
    void testFindAllWithFetchIntoPojo() {
        final List<AnimalPojo> r = animalDao.findAll("Росс");
        logger.info(r);
        assertEquals(1, r.size());
    }
}