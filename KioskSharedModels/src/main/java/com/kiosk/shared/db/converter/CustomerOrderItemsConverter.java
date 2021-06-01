package com.kiosk.shared.db.converter;

import java.io.IOException;

import javax.persistence.AttributeConverter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kiosk.shared.model.CustomerOrderItems;

import lombok.extern.java.Log;

@Log
public class CustomerOrderItemsConverter implements AttributeConverter<CustomerOrderItems, String>{

	private static ObjectMapper jsonObjectMapper = new ObjectMapper();
	
	@Override
	public String convertToDatabaseColumn(CustomerOrderItems customerOrderItems) {

		try {
        	return jsonObjectMapper.writeValueAsString(customerOrderItems);
        } 
		catch (final JsonProcessingException e) {
            log.severe("JSON writing error" + e.getMessage());
            return "";
        }
 	}

	@Override
	public CustomerOrderItems convertToEntityAttribute(String dbData) {
		
		CustomerOrderItems customerOrderItems = new CustomerOrderItems();
		try {
			customerOrderItems = jsonObjectMapper.readValue(dbData, CustomerOrderItems.class);
		} 
		catch (IOException e) {
			log.severe("Unable to convert CustomerOrderItems column data to object");
		}
		return customerOrderItems;
	}

}
