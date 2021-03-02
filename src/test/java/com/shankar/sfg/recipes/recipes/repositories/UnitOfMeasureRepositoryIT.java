package com.shankar.sfg.recipes.recipes.repositories;

import com.shankar.sfg.recipes.recipes.controllers.IndexController;
import com.shankar.sfg.recipes.recipes.domain.UnitOfMeasure;
import jdk.nashorn.internal.ir.Optimistic;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @implNote This integration test class tests the Uom Repository with test data loaded in H2.
 * From the docs - " Using this annotation will disable full auto-configuration
 * and instead apply only configuration relevant to JPA tests."
 * The first test method (findByDescriptionTeaspoon()) takes more time to run, since it loads the JPA related beans.
 * The second method findByDescriptionCup() is faster, but still takes some time since the context is reloaded.
 * The thrid test is very fast, since it does need to load, or reload context.
 * @see UnitOfMeasureRepository
 */

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Test
    @Order(3)
    @DirtiesContext
    void findByDescriptionTeaspoon() {
        Optional<UnitOfMeasure> uom = unitOfMeasureRepository.findByDescription("Teaspoon");
        assert("Teaspoon".equals(uom.get().getDescription()));
    }
    @Test
    @Order(2)
    void findByDescriptionCup() {
        Optional<UnitOfMeasure> uom = unitOfMeasureRepository.findByDescription("Cup");
        assert("Cup".equals(uom.get().getDescription()));
    }

    @Test
    @Order(1)
    void findByDescriptionUnknown() {
        Optional<UnitOfMeasure> uom = unitOfMeasureRepository.findByDescription("Random");
        assert(!uom.isPresent());
    }

}