//package in.kiosk.shared.db.entity;
//
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Convert;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//
//import com.kiosk.shared.db.converter.CustomerOrderItemsConverter;
//import com.kiosk.shared.model.CustomerOrderItems;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//
//@Entity
//@Table(name = "tbl_customer_order", schema = "schema_qiosk")
//@Data @NoArgsConstructor @AllArgsConstructor
//public class CustomerOrderEntity {
//
//	@Id @GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
//
//
//	@Column(nullable = false)
//	private Date createdDate;
//
//
//	@NotNull @Column(nullable = false, name = "customer_order", length = 10000000)
//	@Convert(converter = CustomerOrderItemsConverter.class)
//	private CustomerOrderItems customerOrderItems;
//
//
//	/**
//	 * Constructor
//	 * @param customerOrderItems
//	 * @param date
//	 */
//	public CustomerOrderEntity(CustomerOrderItems customerOrderItems, Date date) {
//		this.customerOrderItems = customerOrderItems;
//		this.createdDate = date;
//	}
//}
