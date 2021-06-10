//package in.kiosk.shared.db.entity;
//
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Convert;
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//
//import com.kiosk.shared.model.tenant.TenantProperties;
//import com.kiosk.shared.DatabaseType;
//import com.kiosk.shared.TenantStatus;
//import com.kiosk.shared.db.converter.TenantConverter;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Table(name = "tbl_tenant", schema = "schema_qiosk")
//@Data @NoArgsConstructor @AllArgsConstructor
//public class TenantEntity {
//
//	@Id @GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
//
//	@Column(name = "created_date", nullable = false)
//	private Date createdDate = new Date();
//
//
//	@NotNull @Column(name = "tenant_identifier", nullable = false, unique = true, length = 100)
//	private String tenantIdentifier;
//
//
//	@NotNull @Column(name = "database_type", nullable = false) @Enumerated(EnumType.STRING)
//	private DatabaseType databaseType;
//
//
//	@NotNull @Column(name = "database_ipaddress", nullable = false)
//	private String databaseIPAddress;
//
//
//	@NotNull @Column(nullable = false)
//	private Integer port;
//
//
//	@Column(nullable = false) @Enumerated(EnumType.STRING) @NotNull
//	private TenantStatus status = TenantStatus.ACTIVE;
//
//
//	@NotNull
//	@Column(name = "tenant_properties", nullable = false, length = 10000)
//	@Convert(converter = TenantConverter.class)
//	private TenantProperties tenantProperties;
//
//
//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("\nTenant [\nid=");
//		builder.append(id);
//		builder.append(", createdDate=");
//		builder.append(createdDate);
//		builder.append(", tenantIdentifier=");
//		builder.append(tenantIdentifier);
//		builder.append(", databaseType=");
//		builder.append(databaseType);
//		builder.append(", databaseIPAddress=");
//		builder.append(databaseIPAddress);
//		builder.append(", port=");
//		builder.append(port);
//		builder.append(", status=");
//		builder.append(status);
//		builder.append(", tenantProperties=");
//		builder.append(tenantProperties);
//		builder.append("]\n");
//		return builder.toString();
//	}
//}
