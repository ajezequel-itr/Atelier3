package com.sp.service;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sp.model.UserDB;
import com.sp.model.UserDTO;
import com.sp.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository uRepository;
	
	// FAire une requette à l'adresse 8081/card/generatecards pour obtenir des cards pour chaque user, puis virer la dépendance au service cards
	
	private RestTemplate restTemplate = new RestTemplate();
	private static final String CARDS_SERVICE_URL = "http://localhost:8081/card/generatecards";

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addUser(UserDB u) {
		Set<Integer> maliste = (Set<Integer>) u.getIdList();
		int alreadyExists = getUserId(u);
		System.out.println(alreadyExists);
		if (alreadyExists == -1) {
			// Code pour faire un fetch en Java vers l'url du service des cards
			ResponseEntity<Set> responseEntity = restTemplate.exchange(
					CARDS_SERVICE_URL,
					HttpMethod.GET,
					null,
					Set.class
			);
			
			maliste = responseEntity.getBody();
			u.setIdList(maliste);
			UserDB createdUser=uRepository.save(u);
			// Liste de 5 entiers = CardService.gene5cartes()
			// Set l'attribut idList de User (vide de base)
			System.out.println(createdUser);
		}
		else {
			System.out.println("L'utilisateur existe déjà dans la BDD, Sorry");
		}
	}

	public int getUserId(UserDB u) {
		String username = u.getUsername();
		UserDB myuser = uRepository.findByUsername(username);
		System.out.println(u);
		System.out.println(username);
		System.out.println(myuser);
		if (myuser != null) {
			return myuser.getId();
		}
		else {
			return -1;
		}
	}
	
	
	public UserDB getUser(int id) {
		Optional<UserDB> cOpt = uRepository.findById(id);
		if (cOpt.isPresent()) {
			return cOpt.get();
		}
		else {
			return null;
		}
	}
	
	public UserDB getUser(String id) {
		Optional<UserDB> cOpt = uRepository.findById(Integer.valueOf(id));
		if (cOpt.isPresent()) {
			return cOpt.get();
		}
		else {
			return null;
		}
	}

	public int getWallet(UserDB u) {
		String username = u.getUsername();
		UserDB myuser = uRepository.findByUsername(username);
		return myuser.getWallet();
	}

	public void changeWallet(UserDB u, int amount) {
		String username = u.getUsername();
		UserDB myuser = uRepository.findByUsername(username);
		myuser.setWallet(amount);
	}
	
	// ============= login =============	
	
	public int login(UserDB user) {
		return getUserId(user);
	}
	
	// ============= DTO =============
	
	public UserDB DTOConvert(UserDTO c) {
		int id = c.getId();
		Optional<UserDB> cOpt = uRepository.findById(id);
		if (cOpt.isPresent()) {
			return cOpt.get();
		} else {
			return null;
		}
	}

}