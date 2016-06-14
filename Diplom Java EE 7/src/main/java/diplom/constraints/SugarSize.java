package diplom.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
@Constraint(validatedBy = SugarSizeConstraint.class)
public @interface SugarSize {
	String message() default "Сахар должен быть 3.5 или больше";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
