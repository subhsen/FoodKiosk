package com.kiosk.shared.model;

import com.kiosk.shared.db.entity.CustomerOrderEntity;
import com.kiosk.shared.db.entity.VendorOrderEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class Order {

	private CustomerOrderEntity customerOrderEntity;
	
	private List<VendorOrderEntity> vendorOrderEntityList;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [\ncustomerOrderEntity=");
		builder.append(customerOrderEntity);
		builder.append(", \nvendorOrderEntityList=");
		builder.append(vendorOrderEntityList);
		builder.append("]");
		return builder.toString();
	}
	
	
}
