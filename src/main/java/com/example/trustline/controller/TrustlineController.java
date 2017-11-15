package com.example.trustline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.trustline.bo.TrustlineBO;

@RestController
public class TrustlineController {
	
	@Autowired
	private TrustlineBO trustlineBO;
	
	
	
	@RequestMapping("/balance")
	public String getBalance(){
		return trustlineBO.getBalance();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/{amount}/receive")
	public String receive(@PathVariable("amount") int amount,
			@RequestParam("user") String user){
		return trustlineBO.recieve(amount, user);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/{amount}/pay")
	public @ResponseBody String pay(@PathVariable("amount") int amount,
			@RequestParam("user") String user){
		return trustlineBO.pay(amount, user);
	}
	
	
	
	
}
