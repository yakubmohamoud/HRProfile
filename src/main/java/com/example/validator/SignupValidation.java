package com.example.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.form.UserForm;
import com.example.service.UserService;

@Component
public class SignupValidation implements Validator {
	@Autowired
	UserService userService;
	

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserForm.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		UserForm user = (UserForm) target;
		ValidationUtils.rejectIfEmpty(errors, "username","notEmpty.username");
		ValidationUtils.rejectIfEmpty(errors, "password","notEmpty.password");
		ValidationUtils.rejectIfEmpty(errors, "confirmPassword","notEmpty.confirmPassword");
		//If condition here is to ensure both Password and confirm password are the same
		if (user.getPassword() != null && user.getConfirmPassword() != null && user.getPassword().equals(user.getConfirmPassword())) {
			errors.rejectValue("password","NotMatch.confirmPassword");
			
		}
		if(userService.userExist(user.getUser())) {
			errors.rejectValue("username","exists.username");
			
		}
		
		
	}

	
}
