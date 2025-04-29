package ru.manannikov.jooqjpa;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jooq.AutoConfigureJooq;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import ru.manannikov.jooqjpa.daos.AnimalDao;
import ru.manannikov.jooqjpa.daos.TaxonomicRankDao;
import ru.manannikov.jooqjpa.daos.impl.AnimalDaoImpl;
import ru.manannikov.jooqjpa.daos.impl.TaxonomicRankDaoImpl;
import ru.manannikov.jooqjpa.entities.AnimalEntity;
import ru.manannikov.jooqjpa.entities.TaxonomicRankEntity;
import ru.manannikov.jooqjpa.repos.AnimalRepo;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureJooq
@Import(value = { TaxonomicRankDaoImpl.class, AnimalDaoImpl.class })
class JooqJpaApplicationTests {

	@Autowired
	AnimalRepo animalRepo;

	@Autowired
	TaxonomicRankDao taxonomicRankDao;
	@Autowired
	AnimalDao animalDao;

	@Test
	void testFindAll() {
		final List<AnimalEntity> r = animalDao.findAll(
			0, 100, null
		);
		assertEquals(12, r.size());
	}

	@Test
	void testFindByRussianName() {
		final Optional<AnimalEntity> r = animalDao.findByRussianName("Амурский тигр");
		logger.info("animal: {}", r);
		assertFalse(r.isEmpty());
	}

	@Test
	void testSave() {
		final TaxonomicRankEntity taxonomicRank = taxonomicRankDao.findByName("Млекопитающие").orElseThrow(() -> new RuntimeException("taxonomic rank not found"));

		final long beforeInsertCount = animalRepo.count();

		final var animal = AnimalEntity.builder()
			.russianName("Бобр")
			.latinName("Bebrus")
			.naturalHabitat("Везде и повсюду")
			.taxonomicRank(taxonomicRank)
		.build();
		animalRepo.save(animal);

		final long afterInsertCount = animalRepo.count();
		assertEquals(1, afterInsertCount - beforeInsertCount);
	}
}