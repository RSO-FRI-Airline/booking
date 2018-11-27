package si.fri.rso.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerQuery {

    public String firstName;
    public String lastName;
    public String mail;

}
