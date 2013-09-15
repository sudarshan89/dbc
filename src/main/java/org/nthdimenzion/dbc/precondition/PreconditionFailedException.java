package org.nthdimenzion.dbc.precondition;

import org.nthdimenzion.IConstraints;

import javax.validation.ConstraintViolation;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Nthdimenzion
 * Date: 15/9/13
 * Time: 6:45 PM
 */
public class PreconditionFailedException extends RuntimeException implements IConstraints {

    Set<ConstraintViolation> constraintViolations = new HashSet();

    public PreconditionFailedException() {
    }

    public PreconditionFailedException (String s) {
        super(s);
    }

    public PreconditionFailedException(Set<ConstraintViolation> constraintViolations) {
        this.constraintViolations = constraintViolations;
    }

    @Override
    public Set<ConstraintViolation> getConstraintViolations() {
        return constraintViolations;
    }
}
