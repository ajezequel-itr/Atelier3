package com.sp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.sp.model.Card;

public interface CardRepository extends CrudRepository<Card, Integer> {
	
	public Optional<Card> findByName(String name);
	
	public Iterable<Card> findAllByName(String name);
	
	public Iterable<Card> findAllBySuperPowerName(String superPowerName);
}