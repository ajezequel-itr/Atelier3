package com.sp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
public class RequestCrt {

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index(Model model) {
		return "index";
	}
	
	@RequestMapping(value = {"/display" }, method = RequestMethod.GET)
	public String display(Model model) {
		return "display";
	}
	
	@RequestMapping(value = {"/search" }, method = RequestMethod.GET)
	public String search(Model model) {
		return "search";
	}
	
	@RequestMapping(value = {"/browse" }, method = RequestMethod.GET)
	public String browse(Model model) {
		return "search";
	}
	
	@RequestMapping(value = {"/addCard" }, method = RequestMethod.GET)
	public String addCard(Model model) {
		return "addCard";
	}
	
	@RequestMapping(value = {"/login" }, method = RequestMethod.GET)
	public String login(Model model) {
		return "addCard";
	}

}

