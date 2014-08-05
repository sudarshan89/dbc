package com.nthdimenzion.invariant;

/**
 * Class invariant can be checked either via custom annotations or by implementing the ICheckVariant interface
 *
 * Created by IntelliJ IDEA.
 * User: Nthdimenzion
 * Date: 15/9/13
 * Time: 9:57 PM
 */
public interface ICheckInvariant {

    void checkInvariant() throws InvariantFailedException;
}
