package si.fri.rso.endpoints;

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

//    @Path("/{token}")
//    @GET
//    public Response info(@PathParam(value = "token") int token) {
//        Price price = bookingBean.getPrice(token);
//        log.info(price.toString());
//        return Response.ok(price).build();
//    }

    @POST
    public Response book(BookQuery bookQuery){
        if (customerBean.exists(bookQuery.customer)) {
            Price price = bookingBean.getPrice(bookQuery.token);
            log.info(price.toString());
            Booking booking = bookingBean.create(bookQuery.customer, 1, price, 99);
            return Response.ok(booking).build();
        }
        else return Response.notModified("Customer does not exists!").build();
    }

}