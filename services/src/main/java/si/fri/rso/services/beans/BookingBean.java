package si.fri.rso.services.beans;

import com.kumuluz.ee.discovery.annotations.DiscoverService;
import si.fri.rso.models.dtos.Price;
import si.fri.rso.models.entities.Booking;
import si.fri.rso.models.entities.Customer;
import si.fri.rso.services.configuration.AppProperties;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import java.util.Optional;
import java.util.logging.Logger;

@RequestScoped
public class BookingBean extends EntityBean<Booking> {
    public BookingBean() {
        super(Booking.class);
    }

    private Logger log = Logger.getLogger(BookingBean.class.getName());

    @Inject
    private AppProperties appProperties;

    private Client httpClient;

//    @Inject
//    @DiscoverService("rso-orders")
    private Optional<String> baseUrl;

    @PostConstruct
    private void init() {
        httpClient = ClientBuilder.newClient();
        baseUrl = Optional.of("http://localhost:8081"); // TODO: Discover Service
    }

    public Booking create(Customer customer, int status, Price price, int userEvaluation){
        Booking a = new Booking();
        a.setCustomer(customer);
        a.setStatus(status);
        a.setPrice(price);
        a.setUserEvaluation(userEvaluation);
        add(a);
        return a;
    }

    public Price getPrice(Integer token) {

        if (appProperties.isExternalServicesEnabled() && baseUrl.isPresent()) {
            try {
                log.info("URL: " + baseUrl.get() + "/v1/search/price/" + token);
                return httpClient
                        .target(baseUrl.get() + "/v1/search/price/" + token)
                        .request().get(new GenericType<Price>() {
                        });
            } catch (WebApplicationException | ProcessingException e) {
                log.severe(e.getMessage());
                throw new InternalServerErrorException(e);
            }
        }

        return null;

    }
}