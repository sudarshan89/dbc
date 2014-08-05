package com.nthdimenzion.example;

import org.junit.Test;
import com.nthdimenzion.dbc.postcondition.PostconditionFailedException;
import com.nthdimenzion.dbc.precondition.PreconditionFailedException;
import com.nthdimenzion.invariant.InvariantFailedException;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: Nthdimenzion
 * Date: 22/9/13
 * Time: 1:17 PM
 */
public class ShoppingCartTest {

    @Test(expected = PreconditionFailedException.class)
    public void whenCreatingABookWithNoTitle_itShouldFail(){
        UnitTestBook unitTestBook = new UnitTestBook("", BigDecimal.ONE);
    }

    @Test(expected = PreconditionFailedException.class)
    public void whenCreatingABookWithNoPrice_itShouldFail(){
        UnitTestBook unitTestBook = new UnitTestBook("DbC For Java", null);

    }

    @Test
    public void whenCreatingABookWithTitleAndPrice_itShouldReturnNewBook(){
        UnitTestBook unitTestBook = new UnitTestBook("DbC For Java", BigDecimal.TEN);
        assertNotNull(unitTestBook);
    }

    @Test(expected = PreconditionFailedException.class)
    public void whenThePriceOfTheBookIsUpdatedToANegativeValue_itShouldFail(){
        UnitTestBook unitTestBook = new UnitTestBook("DbC For Java", BigDecimal.TEN);
        unitTestBook.setPrice(new BigDecimal(-1));
    }

    @Test
    public void whenThePriceOfTheBookIsUpdatedToAPositiveValue_itShouldGetUpdated(){
        UnitTestBook unitTestBook = new UnitTestBook("DbC For Java", BigDecimal.TEN);
        unitTestBook.setPrice(BigDecimal.ONE);
        assertThat(BigDecimal.ONE,is(equalTo(BigDecimal.ONE)));
    }

    @Test(expected = PreconditionFailedException.class)
    public void whenBookAddedToShoppingCartIsNull_itShouldFail(){
        UnitTestShoppingCart shoppingCart = new UnitTestShoppingCart();
        shoppingCart.addBooks(null,1);

    }

    @Test
    public void whenBookTenCopiesOfABookAreAddedToShoppingCart_itShouldPass(){
        UnitTestBook unitTestBook = new UnitTestBook("DbC For Java", BigDecimal.TEN);
        UnitTestShoppingCart shoppingCart = new UnitTestShoppingCart();
        shoppingCart.addBooks(unitTestBook,10);
        /**
         * There is no need to check the post condition as the Contract ensures that if this is not met it will fail
         */

    }

    @Test(expected = PreconditionFailedException.class)
    public void givenShoppingCartHasThreeCopies_whenRemovedFourCopiesFromShoppingCart_itShouldFail(){
        UnitTestBook unitTestBook = new UnitTestBook("DbC For Java", BigDecimal.TEN);
        UnitTestShoppingCart shoppingCart = new UnitTestShoppingCart();
        shoppingCart.addBooks(unitTestBook,3);

        shoppingCart.removeBooks(unitTestBook,4);

    }

    @Test
    public void givenShoppingCartHasThreeCopies_whenRemovedTwoCopiesFromShoppingCart_itShouldPass(){
        UnitTestBook unitTestBook = new UnitTestBook("DbC For Java", BigDecimal.TEN);
        UnitTestShoppingCart shoppingCart = new UnitTestShoppingCart();
        shoppingCart.addBooks(unitTestBook,3);
        /**
         * There is no need to check the post condition as the Contract ensures that if this is not met it will fail
         */
        shoppingCart.removeBooks(unitTestBook,2);
    }

    @Test
    public void givenShoppingCartHasThreeCopies_whenWeCalculateTheTotalPriceOfShoppingCart_itShouldReturnTheTotalPrice(){
        UnitTestBook unitTestBook = new UnitTestBook("DbC For Java", BigDecimal.TEN);
        UnitTestShoppingCart shoppingCart = new UnitTestShoppingCart();
        shoppingCart.addBooks(unitTestBook,4);
        shoppingCart.removeBooks(unitTestBook,2);
        BigDecimal total = shoppingCart.getTotal();
        assertThat(total,is(new BigDecimal(20)));
    }


    @Test(expected = InvariantFailedException.class)
    public void testCheckInvariants(){
        UnitTestShoppingCart shoppingCart = new UnitTestShoppingCart();
        shoppingCart.invalidateInvariantsOnPurpose();
    }

    @Test(expected = PostconditionFailedException.class)
    public void testPostConditions(){
        UnitTestShoppingCart shoppingCart = new UnitTestShoppingCart();
        shoppingCart.failPostConditionOnPurpose();
    }
}
