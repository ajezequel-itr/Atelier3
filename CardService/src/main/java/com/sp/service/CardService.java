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
	
	// ============= ADD =============
	
	public void addCard(Card card) {cardRepo.save(card);}
	
	public void addCards(Iterable<Card> cards) {cardRepo.saveAll(cards);}
	
	// ============= GET =============
	
	public Card getCard(int id) { //Card by id
		Optional<Card> cOpt = cardRepo.findById(id);
		if (cOpt.isPresent()) {
			return cOpt.get();
		} else {
			return null;
		}
	}
	
	public Iterable<Card> getCard(String name) { //Card by name
		Iterable<Card> cards = cardRepo.findAllByName(name);
		return cards;
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
	
	// ============= UPDATE =============
	
	public void udpateCardOwner(Card card, int ownerId) { //Update owner
		card.setOwnerId(ownerId);
		cardRepo.save(card);
	}
	
	public void udpateCardValue(int idCard, int value) { //Update owner
		Card card = getCard(idCard);
		card.setValue(value);
		cardRepo.save(card);
	}
	
	// ============= DELETE =============
	
	public void delCard(int id) {cardRepo.deleteById(id);} // Delete by id
	
	public void delCard(Card c) {cardRepo.delete(c);} //Delete by object
	
	// ============= DTO =============
	
	public Card DTOConvert(CardDTO c) {
		int id = c.getId();
		Optional<Card> cOpt = cardRepo.findById(id);
		if (cOpt.isPresent()) {
			return cOpt.get();
		} else {
			return null;
		}
	}
}