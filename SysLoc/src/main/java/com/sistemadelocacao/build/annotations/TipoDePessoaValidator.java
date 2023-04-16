package com.sistemadelocacao.build.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TipoDePessoaValidator implements ConstraintValidator<TipoDePessoaValidation, String>{
	
	private Pattern padrao = Pattern.compile("^(PF|PJ)$");
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if((value==null) | (value.equalsIgnoreCase(""))) return false;
		
		Matcher matcher = padrao.matcher(value);
		return matcher.matches();
	}
}
