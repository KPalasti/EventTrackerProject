package com.skilldistillery.lift.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.lifts.entities.Lift;

class LiftTets {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Lift lift;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPALifts");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		lift = em.find(Lift.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		lift = null;
	}

	@Test
	void test_Lift_entity_mapping() {
		assertNotNull(lift);
		assertEquals("Deadlift", lift.getName());
	}

}
