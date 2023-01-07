package com.prospectaPractice.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prospectaPractice.controller.model.PostOfficeBean;
import com.prospectaPractice.controller.model.PostOfficeResponseBean;

@Service("PostalServiceImpl")
public class IpostServiceImpl implements IPostService{

	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public 	PostOfficeResponseBean fetchpostofficeDetailsByCity(String cityValue) {
		
		String url = "https://api.postalpincode.in/postoffice/{city}"
				;
		url = url.replace("{city}", cityValue);
		
		ResponseEntity<PostOfficeResponseBean[]> postalRespononseEntity=
		
		restTemplate.getForEntity(url,PostOfficeResponseBean[].class );
		
		PostOfficeResponseBean[] responseBeanArray=postalRespononseEntity.getBody();
		
		for(PostOfficeResponseBean responseBean:responseBeanArray) {
			  List<PostOfficeBean> postOfficeListBean=responseBean.getPostOffice();		
			  
		}
		
		return responseBeanArray[0];
		
	}
}
