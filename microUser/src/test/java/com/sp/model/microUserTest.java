package com.sp.model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class microUserTest {

	@BeforeEach
	public void setUp() {
		System.out.println("[BEFORE TEST] -- Add Hero to test");
	}

	@AfterEach
	public void tearDown() {
		System.out.println("[AFTER TEST] -- CLEAN hero list");
	}

	@Test
	public void createHero() {
		UserDB h=new UserDB("Arthur","Nalewajek");
		assertTrue(h.getId().intValue() == 0);
		assertTrue(h.getUsername() == "Arthur");
		assertTrue(h.getPassword() == "Nalewajek");
		assertTrue(h.getWallet() == 100);
		h.setUsername("Raph");
		assertTrue(h.getUsername() == "Raph");
		h.setPassword("Berthet");
		assertTrue(h.getPassword() == "Berthet");
		h.setWallet(200);
		assertTrue(h.getWallet() == 200);
	}
}
