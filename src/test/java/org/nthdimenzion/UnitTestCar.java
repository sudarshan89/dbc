package org.nthdimenzion;

import org.nthdimenzion.invariant.ICheckInvariant;
import org.nthdimenzion.invariant.InvariantFailedException;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA.
 * User: Nthdimenzion
 * Date: 15/9/13
 * Time: 6:59 PM
 */
public class UnitTestCar implements ICheckInvariant {
    @NotNull
    private String manufacturer;

    public UnitTestCar(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public void checkInvariant() throws InvariantFailedException {
        if(!manufacturer.startsWith("manu")){
            throw new InvariantFailedException();
        }
    }
}
