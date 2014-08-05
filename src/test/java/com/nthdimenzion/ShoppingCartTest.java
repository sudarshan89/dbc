package com.nthdimenzion;

import com.nthdimenzion.example.Book;
import com.nthdimenzion.example.ShoppingCart;
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
        Book book = new Book("", BigDecimal.ONE);
    }

    @Test(expected = PreconditionFailedException.class)
    public void whenCreatingABookWithNoPrice_itShouldFail(){
        Book book = new Book("DbC For Java", null);

    }

    @Test
    public void whenCreatingABookWithTitleAndPrice_itShouldReturnNewBook(){
        Book book = new Book("DbC For Java", BigDecimal.TEN);
        assertNotNull(book);
    }

    @Test(expected = PreconditionFailedException.class)
    public void whenThePriceOfTheBookIsUpdatedToANegativeValue_itShouldFail(){
        Book book = new Book("DbC For Java", BigDecimal.TEN);
        book.setPrice(new BigDecimal(-1));
    }

    @Test
    public void whenThePriceOfTheBookIsUpdatedToAPositiveValue_itShouldGetUpdated(){
        Book book = new Book("DbC For Java", BigDecimal.TEN);
        book.setPrice(BigDecimal.ONE);
        assertThat(BigDecimal.ONE,is(equalTo(BigDecimal.ONE)));
    }

    @Test(expected = PreconditionFailedException.class)
    public void whenBookAddedToShoppingCartIsNull_itShouldFail(){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addBooks(null,1);

    }

    @Test
    public void whenBookTenCopiesOfABookAreAddedToShoppingCart_itShouldPass(){
        Book book = new Book("DbC For Java", BigDecimal.TEN);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addBooks(book,10);
        /**
         * There is no need to check the post condition as the Contract ensures that if this is not met it will fail
         */

    }

    @Test(expected = PreconditionFailedException.class)
    public void givenShoppingCartHasThreeCopies_whenRemovedFourCopiesFromShoppingCart_itShouldFail(){
        Book book = new Book("DbC For Java", BigDecimal.TEN);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addBooks(book,3);

        shoppingCart.removeBooks(book,4);

    }

    @Test
    public void givenShoppingCartHasThreeCopies_whenRemovedTwoCopiesFromShoppingCart_itShouldPass(){
        Book book = new Book("DbC For Java", BigDecimal.TEN);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addBooks(book,3);
        /**
         * There is no need to check the post condition as the Contract ensures that if this is not met it will fail
         */
        shoppingCart.removeBooks(book,2);
    }

    @Test
    public void givenShoppingCartHasThreeCopies_whenWeCalculateTheTotalPriceOfShoppingCart_itShouldReturnTheTotalPrice(){
        Book book = new Book("DbC For Java", BigDecimal.TEN);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addBooks(book,4);
        shoppingCart.removeBooks(book,2);
        BigDecimal total = shoppingCart.getTotal();
        assertThat(total,is(new BigDecimal(20)));
    }


    @Test(expected = InvariantFailedException.class)
    public void givenShoppingCartWithMaxValueCap_whenShoppingCartValueExceedsCap_itShouldThrowInvariantFailedException(){
        Book book = new Book("DbC For Java", BigDecimal.TEN);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addBooks(book,11);
    }
}
