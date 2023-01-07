package com.prospectaPractice.controller.service;

import com.prospectaPractice.controller.model.PostOfficeResponseBean;

public interface IPostService {

	public 	PostOfficeResponseBean fetchpostofficeDetailsByCity(String city);
}
