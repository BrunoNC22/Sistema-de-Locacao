package com.sistemadelocacao.build.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CpfValidator implements ConstraintValidator<CpfValidation, String>{
	private Pattern padrao = Pattern.compile("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$");
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value.equalsIgnoreCase("")) return true;
		Matcher matcher = padrao.matcher(value);
		return matcher.matches();
	}

}
