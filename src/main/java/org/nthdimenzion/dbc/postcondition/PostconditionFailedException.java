package org.nthdimenzion.dbc.postcondition;

import com.google.common.collect.Sets;
import org.nthdimenzion.IConstraints;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Nthdimenzion
 * Date: 15/9/13
 * Time: 6:45 PM
 */
public class PostconditionFailedException extends RuntimeException implements IConstraints {

    Set<ConstraintViolation> constraintViolations = Sets.newHashSet();

    public PostconditionFailedException() {
    }

    public PostconditionFailedException(String s) {
        super(s);
    }

    public PostconditionFailedException(Set<ConstraintViolation> constraintViolations) {
        this.constraintViolations = constraintViolations;
    }

    @Override
    public Set<ConstraintViolation> getConstraintViolations() {
        return constraintViolations;
    }
}
