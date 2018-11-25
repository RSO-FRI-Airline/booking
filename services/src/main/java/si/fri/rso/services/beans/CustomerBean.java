package si.fri.rso.services.beans;

import si.fri.rso.models.entities.Customer;

public class CustomerBean extends EntityBean<Customer> {
    public CustomerBean() {
        super(Customer.class);
    }

    public Customer create(int id, String firstName, String lastName, String mail){
        Customer a = new Customer();
        a.setId(id);
        a.setName(firstName, lastName);
        a.setMail(mail);
        add(a);
        return a;
    }
}
