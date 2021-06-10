package in.kiosk.shared.db.converter;

import java.io.IOException;

import javax.persistence.AttributeConverter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.kiosk.shared.model.tenant.TenantProperties;

import lombok.extern.java.Log;

@Log
public class TenantConverter implements AttributeConverter<TenantProperties, String> {

	private static ObjectMapper jsonObjectMapper = new ObjectMapper();

	@Override
	public String convertToDatabaseColumn(TenantProperties tenantProperties) {

		try {
			return jsonObjectMapper.writeValueAsString(tenantProperties);
		} 
		catch (final JsonProcessingException e) {
			log.severe("TenantConverter.convertToDatabaseColumn: JSON writing error for tenantProperties" + e.getMessage());
			return "";
		}
	}

	@Override
	public TenantProperties convertToEntityAttribute(String dbData) {
		
		TenantProperties tenantProperties = new TenantProperties();

		try {
			tenantProperties = jsonObjectMapper.readValue(dbData, TenantProperties.class);
		} 
		catch (IOException e) {
			log.severe("TenantConverter.convertToEntityAttribute : Unable to concvert CustomerOrderItems column data to object");
		}
		return tenantProperties;
	}

}
