package com.mb.security.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.TYPE_USE})
@Constraint(validatedBy = UsernameValidator.class)
public @interface ValidUsername
{

	String message() default "Username can only use small letter, numbers, underscore";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
