package com.kiosk.shared.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class CustomerOrderItems {
	
	@NotEmpty(message = "CustomerOrderItems: tenantId cannot be Blank or Null")
	private String tenantId;
	
	@NotNull 
	protected Date createdDate = new Date();
	
	@Valid @NotEmpty @Size(min = 1, message = "CustomerOrderItems: No Items in CustomerOrderEntity")
	private List<@NotNull VendorOrderItems> vendorOrderItemsList;


	public CustomerOrderItems(String tenant, List<VendorOrderItems> vendorOrderItemsList) {
		this.tenantId = tenant;
		this.vendorOrderItemsList = vendorOrderItemsList;
	}	
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nCustomerOrderItems [");
		builder.append(", \nvendorOrderItemsList=");
		builder.append(vendorOrderItemsList);
		builder.append("]\n");
		return builder.toString();
	}

}
