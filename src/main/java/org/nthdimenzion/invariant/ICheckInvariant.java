package org.nthdimenzion.invariant;

import org.nthdimenzion.invariant.InvariantFailedException;

/**
 * Created by IntelliJ IDEA.
 * User: Nthdimenzion
 * Date: 15/9/13
 * Time: 9:57 PM
 */
public interface ICheckInvariant {

    void checkInvariant() throws InvariantFailedException;
}
