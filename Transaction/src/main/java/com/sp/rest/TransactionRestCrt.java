  package com.sp.rest;

  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.web.bind.annotation.PathVariable;
  import org.springframework.web.bind.annotation.RequestBody;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RequestMethod;
  import org.springframework.web.bind.annotation.RestController;

  import com.sp.model.Transaction;
import com.sp.model.Card;
import com.sp.model.Payload;
  import com.sp.service.TransactionService;

  @RestController
  public class TransactionRestCrt {
      @Autowired
      TransactionService tService;
      
      @RequestMapping(method=RequestMethod.POST,value="/transaction")
      public void addTransaction(@RequestBody Transaction transaction) {
          tService.addTransaction(transaction);
      }
      
      @RequestMapping(method=RequestMethod.GET,value="/transaction/{id}")
      public Transaction getTransaction(@PathVariable String id) {
          Transaction t = tService.getTransaction(Integer.valueOf(id));
          return t;
      }
      
      @RequestMapping(method=RequestMethod.POST,value="/buy")
      public void demandeAchat(@RequestBody Payload payload) {
    	  tService.demandeAchat(payload.getIdCard(), payload.getIdBuyer());
      }
      
      /*
      @RequestMapping(method=RequestMethod.GET,value="/cardcmoi/{id}")
      public Card testRecupCarte(@PathVariable String id) {
          Card c = tService.testRecupCarte(Integer.valueOf(id));
          return c;
      }
      */
      
  }
