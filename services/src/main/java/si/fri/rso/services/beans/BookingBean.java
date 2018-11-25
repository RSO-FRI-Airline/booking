package si.fri.rso.services.beans;

import si.fri.rso.models.dtos.Price;
import si.fri.rso.models.entities.Booking;
import si.fri.rso.models.entities.Customer;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class BookingBean extends EntityBean<Booking> {
    public BookingBean() {
        super(Booking.class);
    }

    public Booking create(int id, Customer customer, int status, Price price, int userEvaluation){
        Booking a = new Booking();
        a.setId(id);
        a.setCustomer(customer);
        a.setStatus(status);
        a.setPrice(price);
        a.setUserEvaluation(userEvaluation);
        add(a);
        return a;
    }
}