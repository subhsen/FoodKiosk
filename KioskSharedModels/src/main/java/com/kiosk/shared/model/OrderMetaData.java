package com.kiosk.shared.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

@MappedSuperclass
@Data @NoArgsConstructor @AllArgsConstructor
public class OrderMetaData {

	@NonNull
	protected Long customerOrderId;
		
	@NotBlank
	protected String kioskIdentifier;
	
	@NotBlank 
	protected String vendorIdentifier;
	
	@NotBlank 
	protected String kotIdentifier;
	}
