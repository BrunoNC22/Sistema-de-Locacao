package com.sistemadelocacao.build.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = TelefoneValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TelefoneValidation {
	String message() default "Formato de telefone invalido. Formato esperado: '(XX) XXXXX-XXXX'";
    Class[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
