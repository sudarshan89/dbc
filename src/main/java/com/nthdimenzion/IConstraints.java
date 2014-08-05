package com.nthdimenzion;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Nthdimenzion
 * Date: 15/9/13
 * Time: 7:04 PM
 */
public interface IConstraints {

    Set<ConstraintViolation> getConstraintViolations();

}
