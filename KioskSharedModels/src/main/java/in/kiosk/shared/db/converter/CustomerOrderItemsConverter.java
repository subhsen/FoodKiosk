package in.kiosk.shared.db.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.kiosk.shared.model.CustomerOrder;
import lombok.extern.java.Log;

import javax.persistence.AttributeConverter;
import java.io.IOException;

@Log
public class CustomerOrderItemsConverter implements AttributeConverter<CustomerOrder, String>{

	private static ObjectMapper jsonObjectMapper = new ObjectMapper();
	
	@Override
	public String convertToDatabaseColumn(CustomerOrder customerOrder) {

		try {
        	return jsonObjectMapper.writeValueAsString(customerOrder);
        } 
		catch (final JsonProcessingException e) {
            log.severe("JSON writing error" + e.getMessage());
            return "";
        }
 	}
//package com.kiosk.shared.db.entity;
//
//import com.kiosk.shared.OrderStatus;
//import com.kiosk.shared.db.converter.VendorOrderItemsConverter;
//import com.kiosk.shared.model.OrderMetaData;
//import com.kiosk.shared.model.VendorOrderItems;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import java.util.Date;
//
//@Entity
//@Table(name = "tbl_vendor_order", schema = "schema_qiosk")
//@Data @NoArgsConstructor @AllArgsConstructor
//public class VendorOrderEntity extends OrderMetaData{
//
//	@Id @GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
//
//	@Transient
//	//@NotEmpty(message = "VendorOrderEntity: tenantId cannot be Blank or Null in VendorOrderEntity")
//	private String tenantIdentifier;
//
//
//	@NotNull
//	private final Date createdDate = new Date();
//
//	private Date modifiedDate;
//
//	@Enumerated(EnumType.STRING)
//	private OrderStatus orderStatus;
//
//
//	@Convert(converter = VendorOrderItemsConverter.class)
//	@NotNull @Column(nullable = false, length = 1000000)
//	private VendorOrderItems vendorOrderItems;
//
//
//	/**
//	 *
//	 * @param vendorOrderItems
//	 */
//	public VendorOrderEntity(VendorOrderItems vendorOrderItems) {
//		super();
//
//		this.vendorOrderItems 	= vendorOrderItems;
//
//		this.customerOrderId 	= vendorOrderItems.getOrderMetadata().getCustomerOrderId();
//		this.kioskId 	= vendorOrderItems.getOrderMetadata().getKioskId();
//		this.vendorId 	= vendorOrderItems.getOrderMetadata().getVendorId();
//		this.kitchenId 		= vendorOrderItems.getOrderMetadata().getKitchenId();
//		//this.orderStatus 		= vendorOrderItems.getOrderStatus();
//	}
//
//
//	/**
//	 * @param vendorIdentifier
//	 * @param kotIdentifier
//	 * @param orderStatus
//	 */
//	public VendorOrderEntity(String vendorIdentifier, String kotIdentifier, OrderStatus orderStatus) {
//
//		super();
//		this.vendorIdentifier = vendorIdentifier;
//		this.kotIdentifier = kotIdentifier;
//		this.orderStatus = orderStatus;
//	}
//
//	/**
//	 * @param customerId
//	 * @param vendorIdentifier
//	 * @param kotIdentifier
//	 * @param orderStatus
//	 */
//	public VendorOrderEntity(Long customerOrderId, String vendorIdentifier, String kotIdentifier, OrderStatus orderStatus) {
//
//		this(vendorIdentifier, kotIdentifier, orderStatus);
//		this.customerOrderId = customerOrderId;
//	}//package com.kiosk.shared.db.entity;
//
//import com.kiosk.shared.OrderStatus;
//import com.kiosk.shared.db.converter.VendorOrderItemsConverter;
//import com.kiosk.shared.model.OrderMetaData;
//import com.kiosk.shared.model.VendorOrderItems;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import java.util.Date;
//
//@Entity
//@Table(name = "tbl_vendor_order", schema = "schema_qiosk")
//@Data @NoArgsConstructor @AllArgsConstructor
//public class VendorOrderEntity extends OrderMetaData{
//
//	@Id @GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
//
//	@Transient
//	//@NotEmpty(message = "VendorOrderEntity: tenantId cannot be Blank or Null in VendorOrderEntity")
//	private String tenantIdentifier;
//
//
//	@NotNull
//	private final Date createdDate = new Date();
//
//	private Date modifiedDate;
//
//	@Enumerated(EnumType.STRING)
//	private OrderStatus orderStatus;
//
//
//	@Convert(converter = VendorOrderItemsConverter.class)
//	@NotNull @Column(nullable = false, length = 1000000)
//	private VendorOrderItems vendorOrderItems;
//
//
//	/**
//	 *
//	 * @param vendorOrderItems
//	 */
//	public VendorOrderEntity(VendorOrderItems vendorOrderItems) {
//		super();
//
//		this.vendorOrderItems 	= vendorOrderItems;
//
//		this.customerOrderId 	= vendorOrderItems.getOrderMetadata().getCustomerOrderId();
//		this.kioskId 	= vendorOrderItems.getOrderMetadata().getKioskId();
//		this.vendorId 	= vendorOrderItems.getOrderMetadata().getVendorId();
//		this.kitchenId 		= vendorOrderItems.getOrderMetadata().getKitchenId();
//		//this.orderStatus 		= vendorOrderItems.getOrderStatus();
//	}
//
//
//	/**
//	 * @param vendorIdentifier
//	 * @param kotIdentifier
//	 * @param orderStatus
//	 */
//	public VendorOrderEntity(String vendorIdentifier, String kotIdentifier, OrderStatus orderStatus) {
//
//		super();
//		this.vendorIdentifier = vendorIdentifier;
//		this.kotIdentifier = kotIdentifier;
//		this.orderStatus = orderStatus;
//	}
//
//	/**
//	 * @param customerId
//	 * @param vendorIdentifier
//	 * @param kotIdentifier
//	 * @param orderStatus
//	 */
//	public VendorOrderEntity(Long customerOrderId, String vendorIdentifier, String kotIdentifier, OrderStatus orderStatus) {
//
//		this(vendorIdentifier, kotIdentifier, orderStatus);
//		this.customerOrderId = customerOrderId;
//	}
//}

//}

	@Override
	public CustomerOrder convertToEntityAttribute(String dbData) {
		
		CustomerOrder customerOrder = new CustomerOrder();
		try {
			customerOrder = jsonObjectMapper.readValue(dbData, CustomerOrder.class);
		} 
		catch (IOException e) {
			log.severe("Unable to convert CustomerOrderItems column data to object");
		}
		return customerOrder;
	}

}
