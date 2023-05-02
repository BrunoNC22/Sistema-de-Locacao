package com.sistemadelocacao.build.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = TipoDePessoaValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TipoDePessoaValidation {
	
	String message() default "Formato invalido. Insira 'PF' ou 'PJ'";
    Class[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
