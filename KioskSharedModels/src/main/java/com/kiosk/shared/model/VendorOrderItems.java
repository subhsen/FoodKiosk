package com.kiosk.shared.model;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @NoArgsConstructor @AllArgsConstructor
public class VendorOrderItems {
	
	@Valid @NotNull(message = "CustomerOrderItems: orderMetadata cannot be null")
	private OrderMetaData orderMetadata;
	
	@NotNull 
	private final Date createdDate = new Date();
	
	private Date modifiedDate;
	
//	@Enumerated(EnumType.STRING)
//	private OrderStatus orderStatus;
	
	@NotNull 
	@PositiveOrZero(message = "Validate VendorOrderItems: totalAmount cannot be negetive")
	private Double totalAmount;
	
	
	@NotNull 
	@PositiveOrZero(message = "Validate VendorOrderItems: totalTax cannot be negetive")
	private Double totalTax;

	private String paymentId;

	@Valid 	@NotEmpty @Size(min = 1, max = 50, message = "VendorOrderItems.menuItemsList Minimum 1 Menu Item and Max 50 Items can be selected")
	private List<@NotNull MenuItems> menuItemsList;


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VendorOrderItems [orderMetadata=");
		builder.append(orderMetadata);
		builder.append(", createdDate=");
		builder.append(createdDate);
		builder.append(", modifiedDate=");
		builder.append(modifiedDate);
//		builder.append(", orderStatus=");
//		builder.append(orderStatus);
		builder.append(", totalAmount=");
		builder.append(totalAmount);
		builder.append(", totalTax=");
		builder.append(totalTax);
		builder.append(", paymentId=");
		builder.append(paymentId);
		builder.append(", menuItemsList=");
		builder.append(menuItemsList);
		builder.append("]");
		return builder.toString();
	}	
}
