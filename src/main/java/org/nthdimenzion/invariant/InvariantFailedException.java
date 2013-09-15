package org.nthdimenzion.invariant;

import org.nthdimenzion.IConstraints;

import javax.validation.ConstraintViolation;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Nthdimenzion
 * Date: 15/9/13
 * Time: 9:58 PM
 */
public class InvariantFailedException extends RuntimeException implements IConstraints {
    Set<ConstraintViolation> constraintViolations = new HashSet();

    public InvariantFailedException() {
    }

    public InvariantFailedException (String s) {
        super(s);
    }

    public InvariantFailedException(HashSet<ConstraintViolation> constraintViolations) {
        this.constraintViolations = constraintViolations;
    }

    @Override
    public Set<ConstraintViolation> getConstraintViolations() {
        return constraintViolations;
    }
}
