package com.neuedu.util;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class PropertyPlaceholderConfigurerExnted extends PropertyPlaceholderConfigurer{

	@Override
	protected String convertProperty(String propertyName, String propertyValue){
		if(propertyName.equals("username")||propertyName.equals("password")){
			return EncryDecode.decode(propertyValue);
		}else{
			return propertyValue;
		}
	}
	
	
}
