package com.sistemadelocacao.build.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelefoneValidator implements ConstraintValidator<TelefoneValidation, String>{
	private Pattern padrao = Pattern.compile("^\\(\\d{2}\\) \\d{5}-\\d{4}$");
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		Matcher matcher = padrao.matcher(value);
		return matcher.matches();
	}
}
