package com.nthdimenzion.example;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.nthdimenzion.Contract;
import com.nthdimenzion.invariant.ICheckInvariant;
import com.nthdimenzion.invariant.InvariantFailedException;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: Nthdimenzion
 * Date: 22/9/13
 * Time: 1:34 PM
 */
public class ShoppingCart implements ICheckInvariant{

    private Multiset<Book> books = HashMultiset.create();
    private static BigDecimal MAX_CART_VALUE = new BigDecimal(100);

    public void addBooks(Book book, int copies) {
        Contract.requires(book);
        Contract.requires(copies > 0);
        int initialCount = books.count(book);
        /**
         * In cases where the post condition can only be verified using the past state of the object the past state needs to be captured explicitly
         */
        books.add(book, copies);
        Contract.checkInvariants(this);
        Contract.ensures(books.count(book) == initialCount + copies);
    }

    public void removeBooks(Book book, int copies) {
        Contract.requires(book);
        Contract.requires(books.count(book) > copies);
        int initialCount = books.count(book);
        /**
         * In cases where the post condition can only be verified using the past state of the object the past state needs to be captured explicitly
         */
        books.remove(book, copies);
        Contract.checkInvariants(this);
        Contract.ensures(books.count(book) == initialCount - copies);

    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (Book book : books) {
            total = total.add(book.getPrice());
        }
        return total;
    }

    @Override
    public void checkInvariant() throws InvariantFailedException {
        if(books==null){
            throw new InvariantFailedException("Shopping cart cannot be empty");
        }
        if(getTotal().compareTo(MAX_CART_VALUE) > 0){
            throw new InvariantFailedException("Shopping cart value cannot exceed " + MAX_CART_VALUE);
        }
    }
}
