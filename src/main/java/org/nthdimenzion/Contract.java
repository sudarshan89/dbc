package org.nthdimenzion;

import org.nthdimenzion.dbc.postcondition.PostconditionFailedException;
import org.nthdimenzion.dbc.precondition.PreconditionFailedException;
import org.nthdimenzion.invariant.ICheckInvariant;
import org.nthdimenzion.invariant.InvariantFailedException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Nthdimenzion
 * Date: 15/9/13
 * Time: 6:41 PM
 */
public final class Contract {

    private Contract(){}

    private static Validator validator;

    static {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    public static void requires(boolean precondition){
        requires(precondition,"");
    }

    public static void requires(boolean precondition,Object errorMessage){
        if (!precondition) {
            throw new PreconditionFailedException(String.valueOf(errorMessage));
        }
    }

    public static <T> void requires(T object, Class<?>... groups){
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(object, groups);
        if(constraintViolations!=null && constraintViolations.size() > 0){
            throw new PreconditionFailedException(new HashSet<ConstraintViolation>(constraintViolations));
        }
    }

    public static void checkInvariants(ICheckInvariant iCheckInvariant, Class<?>... groups){
        iCheckInvariant.checkInvariant();
        Set<ConstraintViolation<ICheckInvariant>> constraintViolations = validator.validate(iCheckInvariant, groups);
        if(constraintViolations!=null && constraintViolations.size() > 0){
            throw new InvariantFailedException(new HashSet<ConstraintViolation>(constraintViolations));
        }
    }

    public static void ensures(boolean postCondition){
        ensures(postCondition, "");
    }

    public static void ensures(boolean postCondition,Object errorMessage){
        if (!postCondition) {
            throw new PostconditionFailedException(String.valueOf(errorMessage));
        }
    }

    public static <T> void ensures(T object, Class<?>... groups){
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(object, groups);
        if(constraintViolations!=null && constraintViolations.size() > 0){
            throw new PostconditionFailedException(new HashSet<ConstraintViolation>(constraintViolations));
        }
    }


}
