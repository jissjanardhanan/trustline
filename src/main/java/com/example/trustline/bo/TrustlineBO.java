package com.example.trustline.bo;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.trustline.util.HttpUtil;

@Component
public class TrustlineBO {
	
	private static Logger LOGGER = LoggerFactory.getLogger(TrustlineBO.class);
	
	private AtomicInteger balance = new AtomicInteger(0) ;
	
	@Value("${reciever.port}")
	private String port;
	
	public String recieve(int amount,String user){
		LOGGER.info("You were paid "+amount+"$!");
		balance.updateAndGet(val-> val+amount);
		String response  = getBalance();
		LOGGER.info(response);
		return response;
	}
	
	public String pay(int amount,String user){
		LOGGER.info("Paying "+amount+"$ to "+user);
		int status = HttpUtil.post(user, amount, port);
		if(status==200){
			balance.updateAndGet(val-> val-amount);
		}else{
			LOGGER.error("Unable to update "+user);
		}
		String response  = getBalance();
		LOGGER.info(response);
		return response;
	}
	
	
	public String getBalance(){
		return "Trustline balance is : "+balance.get();
	}

}
