package in.kiosk.shared.db.converter;

import java.io.IOException;

import javax.persistence.AttributeConverter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.kiosk.shared.model.VendorOrderItems;

import lombok.extern.java.Log;

@Log
public class VendorOrderItemsConverter implements AttributeConverter<VendorOrderItems, String>{

	private static ObjectMapper jsonObjectMapper = new ObjectMapper();
	
	@Override
	public String convertToDatabaseColumn(VendorOrderItems vendorOrderItems) {
		
		try {
        	return jsonObjectMapper.writeValueAsString(vendorOrderItems);
        } 
		catch (final JsonProcessingException e) {
            log.severe("JSON writing error" + e.getMessage());
            return "";
        }
	}

	@Override
	public VendorOrderItems convertToEntityAttribute(String dbData) {
		
		VendorOrderItems vendorOrderItems = new VendorOrderItems();
		
		try {
			vendorOrderItems = jsonObjectMapper.readValue(dbData, VendorOrderItems.class);
		} 
		catch (IOException e) {
			log.severe("Unable to concvert CustomerOrderItems column data to object");
		}
		return vendorOrderItems;
	}

}
