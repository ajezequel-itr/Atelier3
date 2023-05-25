package com.sp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.UserDB;
import com.sp.model.UserDTO;
import com.sp.service.UserService;

@RestController
public class UserRestControlleur {

    @Autowired
    UserService uService;
	
	@RequestMapping(method=RequestMethod.POST,value="/register")
	public void addUser(@RequestBody UserDTO user) {
		uService.addUser(uService.DTOConvert(user));
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/user")
	public void getUser(@RequestBody UserDB user) {
		uService.getUserId(user);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/wallet/{id}")
	public int getWallet(@PathVariable String id) {
		UserDB user = uService.getUser(Integer.valueOf(id));
		int myWallet = uService.getWallet(user);
		return myWallet;
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/wallet")
	public void changeWallet(@RequestBody UserDB user, int amount) {
		int amount = uService.getWallet(user);
		uService.changeWallet(user, amount);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/user/{id}")
	public UserDB getUser(@PathVariable String id) {
		UserDB u = uService.getUser(Integer.valueOf(id));
		return u;
	}	
	
	@RequestMapping(method=RequestMethod.POST, value="/login")
	public int login(@RequestBody UserDB user) {
		return uService.login(user);
	}
	
	
}
