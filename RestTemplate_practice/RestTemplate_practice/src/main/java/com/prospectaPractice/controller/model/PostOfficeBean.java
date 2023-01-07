package com.prospectaPractice.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Getter
@Setter
@Data
public class PostOfficeBean {

	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("Description")
	private String description;
	
	@JsonProperty("BranchType")
	private String branchType;
	
	@JsonProperty("DeliveryStatus")
	private String deliveryStatus;
	
	@JsonProperty("Circle")
	private String circle;
	
	@JsonProperty("District")
	private String district;
	
	@JsonProperty("Division")
	private String division;
	
	@JsonProperty("Region")
	private String region;
	
	@JsonProperty("State")
	private String state;
	
	@JsonProperty("Country")
	private String country;
	
	@JsonProperty("Pincode")
	private String pincode;

	
}

/*
 * "Name": "Airport (Mumbai)",
"Description": null,
"BranchType": "Sub Post Office",
"DeliveryStatus": "Non-Delivery",
"Circle": "Maharashtra",
"District": "Mumbai",
"Division": "Mumbai  North",
"Region": "Mumbai",
"State": "Maharashtra",
"Country": "India",
"Pincode": "400099"
 */
