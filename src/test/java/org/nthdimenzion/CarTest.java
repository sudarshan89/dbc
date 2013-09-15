package org.nthdimenzion;

import org.junit.Assert;
import org.junit.Test;
import org.nthdimenzion.dbc.postcondition.PostconditionFailedException;
import org.nthdimenzion.dbc.precondition.PreconditionFailedException;
import org.nthdimenzion.invariant.InvariantFailedException;

/**
 * Created by IntelliJ IDEA.
 * User: Nthdimenzion
 * Date: 15/9/13
 * Time: 6:59 PM
 */
public class CarTest {

    @Test(expected = PreconditionFailedException.class)
    public void givenAObject_whenABeanValidationIsViolated_itShouldThrowAException() {
        UnitTestCar car = new UnitTestCar(null);
        Contract.requires(car);

    }

    @Test(expected = PreconditionFailedException.class)
    public void givenAObject_whenABeanValidationIsViolated_itShouldCaptureTheViolationsInTheCustomException() {
        UnitTestCar car = new UnitTestCar(null);
        try {
            Contract.requires(car);
        } catch (PreconditionFailedException exception) {
            Assert.assertEquals(1, exception.getConstraintViolations().size());
            throw exception;
        }

    }

    @Test(expected = PreconditionFailedException.class)
    public void whenPreconditionIsNotSatisfied_itShouldThrowAException() {
        final boolean preconditionNotSatisfied = false;
        Contract.requires(preconditionNotSatisfied);
    }

    @Test(expected = InvariantFailedException.class)
    public void test() {
        UnitTestCar unitTestCar = new UnitTestCar("New car");
        Contract.checkInvariants(unitTestCar);
    }

    @Test(expected = PostconditionFailedException.class)
    public void givenAObject_whenAPostConditionBeanValidationIsViolated_itShouldThrowAException() {
        UnitTestCar car = new UnitTestCar(null);
        Contract.ensures(car);

    }

    @Test(expected = PostconditionFailedException.class)
    public void givenAObject_whenAPostConditionBeanValidationIsViolated_itShouldCaptureTheViolationsInTheCustomException() {
        UnitTestCar car = new UnitTestCar(null);
        try {
            Contract.ensures(car);
        } catch (PreconditionFailedException exception) {
            Assert.assertEquals(1, exception.getConstraintViolations().size());
            throw exception;
        }

    }

    @Test(expected = PostconditionFailedException.class)
    public void whenPostConditionIsNotSatisfied_itShouldThrowAException() {
        final boolean postCondition = false;
        Contract.ensures(postCondition);
    }






}
