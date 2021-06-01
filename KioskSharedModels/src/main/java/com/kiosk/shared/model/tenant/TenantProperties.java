package com.kiosk.shared.model.tenant;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class TenantProperties {

	@NotEmpty
	private String jdbcUrl;
	
	@NotEmpty
	private String userName;
	
	@NotEmpty
	private String password;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nTenantProperties [\njdbcUrl=");
		builder.append(jdbcUrl);
		builder.append(", userName=");
		builder.append(userName);
		builder.append("]");
		return builder.toString();
	}	
}
