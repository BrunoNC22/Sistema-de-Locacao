package com.sistemadelocacao.build.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator implements ConstraintValidator<EmailValidation, String>{
	private Pattern padrao = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Matcher matcher = padrao.matcher(value);
		return matcher.matches();
	}
}
