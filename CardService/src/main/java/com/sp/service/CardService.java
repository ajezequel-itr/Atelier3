package com.sp.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import com.sp.model.CardDTO;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.repository.CardRepository;

//import antlr.collections.List;

import com.sp.model.Card;
import java.util.List;


@Service
@Transactional
public class CardService {
	@Autowired
	CardRepository cardRepo;
	
	public void addCard(Card card) {cardRepo.save(card);}
	
	public void addCards(Iterable<Card> cards) {cardRepo.saveAll(cards);}
	
	public Card getCard(int id) {
		Optional<Card> cOpt = cardRepo.findById(id);
		if (cOpt.isPresent()) {
			return cOpt.get();
		} else {
			return null;
		}
	}
	
	public Card getCard(String name) {
		Optional<Card> cOpt = cardRepo.findByName(name);
		if (cOpt.isPresent()) {
			return cOpt.get();
		} else {
			return null;
		}
	}
	
	public Set<Integer> create5RandCard(int userId) { // A AMELIORER
		Card card = new Card(userId, "Jose", "Pouvoir", 7, 14,15,16,17,58,"C'est Jose.",
				"https://imgc.allpostersimages.com/img/print/affiches/marvel-super-hero-squad-iron-man-standing_a-G-9448041-4985690.jpg))",
				true);
		this.addCard(card);
		Set<Integer> liste = new HashSet<Integer>();
		for (int i=0; i<5; i++) {
			liste.add(card.getId());
		}
		return liste;
	}
	
	public Iterable<Card> getCards(Iterable<Integer> listId) {return cardRepo.findAllById(listId);}
	
	public Iterable<Card> getAllCards(){return cardRepo.findAll();}
	
	public void delCard(int id) {cardRepo.deleteById(id);}
	
	public void delCard(Card c) {cardRepo.delete(c);}
}