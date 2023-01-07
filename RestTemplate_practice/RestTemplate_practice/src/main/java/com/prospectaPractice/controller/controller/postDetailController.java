package com.prospectaPractice.controller.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prospectaPractice.controller.model.PostOfficeResponseBean;

@RestController
@RequestMapping("/postal")
public class postDetailController {

	@RequestMapping(value ="/byCity", method = RequestMethod.GET,
			consumes = MediaType.ALL_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public PostOfficeResponseBean getPostalByCity(@RequestParam String city) {
		
		return null;
	}
}
