package si.fri.rso.endpoints;

import si.fri.rso.dtos.BookQuery;
import si.fri.rso.dtos.CustomerQuery;
import si.fri.rso.models.dtos.Price;
import si.fri.rso.models.entities.Booking;
import si.fri.rso.models.entities.Customer;
import si.fri.rso.services.beans.BookingBean;
import si.fri.rso.services.beans.CustomerBean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;


@Path("book")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class BookEndpoint {
    private Logger log = Logger.getLogger(BookEndpoint.class.getName());


    @Inject
    private BookingBean bookingBean;

    @Inject
    private CustomerBean customerBean;

    @Path("customers")
    @GET
    public Response getCustomers() {
        List allCustomers = customerBean.get();
        return Response.ok(allCustomers).build();
    }

    @Path("bookings")
    @GET
    public Response getBookings() {
        List allBookings = bookingBean.get();
        return Response.ok(allBookings).build();
    }

    @POST
    public Response book(BookQuery bookQuery){
        CustomerQuery customerQuery = bookQuery.customer;
        if (customerQuery != null) {
            Customer customer = customerBean.getCustomer(customerQuery.firstName, customerQuery.lastName, customerQuery.mail);
            if (customer != null) {
                Price price = bookingBean.getPrice(bookQuery.token);
                if (price != null) {
                    log.info(price.toString());
                    Booking booking = bookingBean.create(customer, 1, price, 99);
                    return Response.ok(booking).build();
                }
                return Response.status(400, "There was problem").build();
            }
            else return Response.status(403, "Customer does not exists!").build();
        }
        else return Response.status(400, "Please provide a customer").build();
    }

}
