package si.fri.rso.endpoints;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import si.fri.rso.models.entities.Customer;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookQuery {
    public Integer token;
    public Customer customer;
}
