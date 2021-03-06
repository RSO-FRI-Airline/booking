package si.fri.rso.models.entities;

import si.fri.rso.models.dtos.Price;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import java.util.List;

@Entity
public class Booking extends BaseEntity{

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Customer customer;
    private int status;

    @Transient
    private Price price;

    private int userEvaluation;
    private int price_id;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
        setPrice_id(price.getId());
    }

    public int getUserEvaluation() {
        return userEvaluation;
    }

    public void setUserEvaluation(int userEvaluation) {
        this.userEvaluation = userEvaluation;
    }

    public int getPrice_id() {
        return this.price_id;
    }

    public void setPrice_id(int price_id) {
        this.price_id = price_id;
    }
}
