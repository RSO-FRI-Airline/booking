package si.fri.rso.services.beans;

import org.eclipse.microprofile.metrics.annotation.Timed;
import si.fri.rso.models.entities.Customer;

import javax.enterprise.context.RequestScoped;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;
import java.util.logging.Logger;

@RequestScoped
public class CustomerBean extends EntityBean<Customer> {
    public CustomerBean() {
        super(Customer.class);
    }
    private Logger log = Logger.getLogger(CustomerBean.class.getName());

    public Customer create(int id, String firstName, String lastName, String mail){
        Customer a = new Customer();
        a.setId(id);
        a.setName(firstName, lastName);
        a.setMail(mail);
        add(a);
        return a;
    }

    @Timed
    public Customer getCustomer(String firstName, String lastName, String mail) {
        Object obj = null;
        try {
            obj = em.createQuery("SELECT c FROM " + Customer.class.getSimpleName() + " c " +
                    " WHERE c.firstName= :firstName " +
                    " AND c.lastName= :lastName " +
                    " AND c.mail= :mail ")
                    .setParameter("firstName", firstName)
                    .setParameter("lastName", lastName)
                    .setParameter("mail", mail)
                    .getSingleResult();
        } catch (NoResultException e) {
            log.info("Customer " + firstName + " " + lastName + " " + mail + " does not exist");
        }
        return (Customer) obj;
    }

    public boolean exists(Integer customerId) {
        Customer curr = em.find(Customer.class, customerId);
        return curr != null;
    }
}
