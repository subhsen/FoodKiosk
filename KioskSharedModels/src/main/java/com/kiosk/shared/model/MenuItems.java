package com.kiosk.shared.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @NoArgsConstructor @AllArgsConstructor
public class MenuItems {
	
	@NotEmpty
	private String itemId;
	
	@NotEmpty
	private String itemName;
	
	private String itemCategory;
	
	@PositiveOrZero(message = "Validate MenuItems: itemPrice cannot be Negetive")
	private Double itemPrice;
	
	@PositiveOrZero(message = "Validate MenuItems: itemPrice cannot be Negetive")
	private Double itemTax;
	
	@Min(value = 1, message  = "Minimum items in Menu must be atleast 1") 
	@Max(value = 50, message = "Maximum items in Menu must be atmost 50")
	private Integer itemQuantity;
}
