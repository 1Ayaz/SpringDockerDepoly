package com.aditya.leave;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CseEntityTest {

	@Test
	void testEntityCreation() {
		CseEntity entity = new CseEntity(1, "Aditya", "CSE", "ACET", "Hyderabad");
		assertEquals(1, entity.getId());
		assertEquals("Aditya", entity.getName());
		assertEquals("CSE", entity.getBranch());
		assertEquals("ACET", entity.getCollege());
		assertEquals("Hyderabad", entity.getCity());
	}

	@Test
	void testSettersAndGetters() {
		CseEntity entity = new CseEntity();
		entity.setId(2);
		entity.setName("Ravi");
		entity.setBranch("ECE");
		entity.setCollege("JNTU");
		entity.setCity("Vizag");

		assertEquals(2, entity.getId());
		assertEquals("Ravi", entity.getName());
		assertEquals("ECE", entity.getBranch());
		assertEquals("JNTU", entity.getCollege());
		assertEquals("Vizag", entity.getCity());
	}

	@Test
	void testToString() {
		CseEntity entity = new CseEntity(3, "Kumar", "IT", "VIT", "Chennai");
		String result = entity.toString();
		assertTrue(result.contains("Kumar"));
		assertTrue(result.contains("IT"));
		assertTrue(result.contains("VIT"));
		assertTrue(result.contains("Chennai"));
	}

	@Test
	void testDefaultConstructor() {
		CseEntity entity = new CseEntity();
		assertNotNull(entity);
		assertEquals(0, entity.getId());
		assertNull(entity.getName());
	}
}
