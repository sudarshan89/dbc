package com.nthdimenzion.example;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by IntelliJ IDEA.
 * User: Nthdimenzion
 * Date: 22/9/13
 * Time: 1:24 PM
 */
public class BookValidator implements ConstraintValidator<BookInvariant,UnitTestBook>{
    @Override
    public void initialize(BookInvariant constraintAnnotation) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isValid(UnitTestBook book, ConstraintValidatorContext context) {
        return book.getTitle()!=null && book.getTitle().length() > 0 && book.getPrice()!=null && book.getPrice().intValue() > 0;
    }

}
