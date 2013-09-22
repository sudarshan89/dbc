package org.nthdimenzion.example;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


/**
 * Created by IntelliJ IDEA.
 * User: Nthdimenzion
 * Date: 22/9/13
 * Time: 1:23 PM
 */

@Target( {TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = BookValidator.class)
@Documented
public @interface BookInvariant {

    String message() default "{corg.nthdimenzion.example}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
