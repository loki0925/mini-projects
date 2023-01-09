package com.prospecta.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController

public class ApiController {

	@Autowired
	RestTemplate restTem;
	
	@GetMapping("/entries/{category}")
	public List<Output> getHandler(@PathVariable("category") String category){
		
		
		AllData d= restTem.getForObject("https://api.publicapis.org/entries", AllData.class);
		
		List<Input> input= d.getInput();
		
		List<Output> list = new ArrayList<>();
		
		for(Input i:input) {
			if(category.equals(i.getCategory()))
			  list.add(new Output(i.getApi(),i.getDescription()));	
		}
		
		return list;
		
	}
	
	
}
