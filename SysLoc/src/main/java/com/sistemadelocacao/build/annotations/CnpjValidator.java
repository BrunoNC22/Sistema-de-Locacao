package com.sistemadelocacao.build.annotations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CnpjValidator implements ConstraintValidator<CnpjValidation, String>{
	private Pattern padrao = Pattern.compile("^\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}$");
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value.equalsIgnoreCase("")) return true;
		Matcher matcher = padrao.matcher(value);
		return matcher.matches();
	}
}
