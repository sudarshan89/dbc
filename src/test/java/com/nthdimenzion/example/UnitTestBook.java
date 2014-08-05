package com.nthdimenzion.example;

import org.hibernate.validator.constraints.NotBlank;
import com.nthdimenzion.Contract;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * User: Nthdimenzion
 * Date: 22/9/13
 * Time: 1:04 PM
 */
@BookInvariant
public class UnitTestBook {

    @NotBlank
    private final String title;

    @NotNull
    private BigDecimal price;

    public UnitTestBook(String title,BigDecimal price) {
        Contract.requires(title!=null && title.length() > 0);
        Contract.requires(price != null);
        this.title = title;
        this.price = price;
        // We could also check if the object has been constructed according to its invariants
        Contract.ensures(this);
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        Contract.requires(price.intValue() > 0);
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final UnitTestBook other = (UnitTestBook) obj;
        return Objects.equals(this.getPrice(),other.getPrice()) && Objects.equals(this.getTitle(),other.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrice(),getTitle());

    }
}
