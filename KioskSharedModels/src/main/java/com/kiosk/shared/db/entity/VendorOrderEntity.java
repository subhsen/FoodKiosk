package com.kiosk.shared.db.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.kiosk.shared.OrderStatus;
import com.kiosk.shared.db.converter.VendorOrderItemsConverter;
import com.kiosk.shared.model.OrderMetaData;
import com.kiosk.shared.model.VendorOrderItems;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_vendor_order", schema = "schema_qiosk")
@Data @NoArgsConstructor @AllArgsConstructor
public class VendorOrderEntity extends OrderMetaData{

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	
	@Transient 
	//@NotEmpty(message = "VendorOrderEntity: tenantId cannot be Blank or Null in VendorOrderEntity")
	private String tenantIdentifier;
	
	
	@NotNull 
	private final Date createdDate = new Date();
	
	private Date modifiedDate;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	 
	@Convert(converter = VendorOrderItemsConverter.class)
	@NotNull @Column(nullable = false, length = 1000000)
	private VendorOrderItems vendorOrderItems;
	
	

	/**
	 * 
	 * @param vendorOrderItems
	 */
	public VendorOrderEntity(VendorOrderItems vendorOrderItems) {
		super();

		this.vendorOrderItems 	= vendorOrderItems;

		this.customerOrderId 	= vendorOrderItems.getOrderMetadata().getCustomerOrderId();
		this.kioskIdentifier 	= vendorOrderItems.getOrderMetadata().getKioskIdentifier();
		this.vendorIdentifier 	= vendorOrderItems.getOrderMetadata().getVendorIdentifier();
		this.kotIdentifier 		= vendorOrderItems.getOrderMetadata().getKotIdentifier();
		//this.orderStatus 		= vendorOrderItems.getOrderStatus();
	}


	/**
	 * @param vendorIdentifier
	 * @param kotIdentifier
	 * @param orderStatus
	 */
	public VendorOrderEntity(String vendorIdentifier, String kotIdentifier, OrderStatus orderStatus) {

		super();
		this.vendorIdentifier = vendorIdentifier;
		this.kotIdentifier = kotIdentifier;
		this.orderStatus = orderStatus;
	}

	/**
	 * @param customerId
	 * @param vendorIdentifier
	 * @param kotIdentifier
	 * @param orderStatus
	 */
	public VendorOrderEntity(Long customerOrderId, String vendorIdentifier, String kotIdentifier, OrderStatus orderStatus) {

		this(vendorIdentifier, kotIdentifier, orderStatus);
		this.customerOrderId = customerOrderId;
	}
}
