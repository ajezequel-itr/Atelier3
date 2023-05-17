package com.sp.service;

import java.util.Optional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import com.sp.model.Transaction;
import com.sp.model.UserDTO;
import com.sp.model.CardDTO;
import com.sp.repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	TransactionRepository tRepository;
	@Autowired
	RestTemplate restTemplate = new RestTemplate();
	
	public void addTransaction(Transaction t) {
		Transaction createdTransaction=tRepository.save(t);
		System.out.println(createdTransaction);
	}
	
	public Transaction getTransaction(int id) {
		Optional<Transaction> hOpt =tRepository.findById(id);
		if (hOpt.isPresent()) {
			return hOpt.get();
		}else {
			return null;
		}
	}
	

	public void demandeAchat(int idCard, int idBuyer) {
	    // On récupère les objets Card et User correspondant aux ID.
	    CardDTO cardDTO = restTemplate.getForObject("http://localhost:8081/card/" + idCard, CardDTO.class);
	    UserDTO buyer = restTemplate.getForObject("http://localhost:8082/user/" + idBuyer, UserDTO.class);

	    // On récupère le montant de la carte.
	    int cardValue = cardDTO.getValue();

	    // Cas où l'acheteur possède assez d'argent pour acheter la carte.
	    if (cardValue <= buyer.getWallet()) {
	        // On récupère l'objet User de l'acheteur.
	        int idSeller = cardDTO.getOwnerId();
	        UserDTO seller = restTemplate.getForObject("http://localhost:8082/user/" + idSeller, UserDTO.class);

	        // Transaction d'argent.
	        buyer.setWallet(buyer.getWallet() - cardValue);
	        seller.setWallet(seller.getWallet() + cardValue);

	        // On change le propriétaire de la carte.
	        cardDTO.setOwnerId(buyer.getId());
	        restTemplate.postForObject("http://localhost:8081/card/" + idCard, cardDTO, CardDTO.class);

	        // On met à jour les informations des utilisateurs dans la base de données.
	        restTemplate.put("http://localhost:8082/wallet", buyer);
	        restTemplate.put("http://localhost:8082/wallet", seller);
	        
	        // On récupère la date de la transaction.
	        LocalDateTime currentDateTime = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String formattedDateTime = currentDateTime.format(formatter);

	        // On créer un objet Transaction pour enregistrer l'achat dans les logs.
	        Transaction transaction = new Transaction(idBuyer, idSeller, cardValue, formattedDateTime);
	        // On ajoute la transaction nouvellement crée dans le Repository.
	        this.addTransaction(transaction);
	    }
	    // Cas où l'acheteur ne possède pas assez d'argent pour acheter la carte.
	    else {
	        System.out.println("L'acheteur n'a pas assez d'argent.");
	    }
	}
}
