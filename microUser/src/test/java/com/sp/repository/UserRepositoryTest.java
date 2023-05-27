package com.sp.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import com.sp.model.UserDB;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	UserRepository hrepo;

	@BeforeEach
	public void setUp() {
		hrepo.save(new UserDB("jdoe", "strong"));
	}

	@AfterEach
	public void cleanUp() {
		hrepo.deleteAll();
	}

	@Test
	public void saveHero() {
		hrepo.save(new UserDB("test", "testPower"));
		assertTrue(true);
	}

	@Test
	public void saveAndGetHero() {
		hrepo.deleteAll();
		hrepo.save(new UserDB("test1", "testPower1"));
		List<UserDB> heroList = new ArrayList<>();
		hrepo.findAll().forEach(heroList::add);
		assertTrue(heroList.size() == 1);
		assertTrue(heroList.get(0).getUsername().equals("test1"));
		assertTrue(heroList.get(0).getPassword().equals("testPower1"));
		assertTrue(heroList.get(0).getWallet().equals(100));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void getHero() {
		List<UserDB> heroList = (List<UserDB>) hrepo.findByUsername("jdoe");
		assertTrue(heroList.size() == 1);
		assertTrue(heroList.get(0).getUsername().equals("jdoe"));
		assertTrue(heroList.get(0).getPassword().equals("strong"));
		assertTrue(heroList.get(0).getWallet().equals(100));
	}

	@Test
	public void findByUsername() {
		hrepo.save(new UserDB("test1", "testPower1"));
		hrepo.save(new UserDB("test2", "testPower2"));
		hrepo.save(new UserDB("test2", "testPower2"));
		hrepo.save(new UserDB("test2", "testPower2"));
		assertTrue(hrepo.findByUsername("test2") == new UserDB("test1", "testPower1"));
	}

}