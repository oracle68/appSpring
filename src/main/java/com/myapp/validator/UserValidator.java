/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.validator;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.myapp.entity.User;


@Component
public class UserValidator implements Validator {
	private final static Logger LOGGER = Logger.getLogger("UserValidator");
//which objects can be validated by this validator
	@Override
	/*public boolean supports(Class<?> paramClass) {
		return User.class.equals(paramClass);
	}*/    
    public boolean supports(Class clazz) {
        return User.class.isAssignableFrom(clazz);
    }
    @Override
    public void validate(Object obj, Errors errors) {
        //ValidationUtils.rejectIfEmpty(errors, "firstname", "required", "camp obligatori.");
        //ValidationUtils.rejectIfEmpty(errors, "lastname", "required", "Field is required.");
    	// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "user.firstname.required");
    	// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "user.lastname.required");
        
        User user = (User) obj;

        LOGGER.log(Level.INFO, "**********************************************");
        LOGGER.log(Level.INFO,"Validate "+ user.toString());
        LOGGER.log(Level.INFO,"**********************************************");
		
    	if (user.getFirstName().equals(""))
    	{	
    		 errors.rejectValue("firstName", "error.nom","error camp buit");

    	}        
        
    	if (user.getLastName().equals(""))
    	{	
    		 errors.rejectValue("lastName", "error.nom","error camp buit");

    	}        
    }
}