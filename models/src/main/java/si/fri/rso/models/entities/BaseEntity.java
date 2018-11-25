package si.fri.rso.models.entities;

//import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Date;

//@Entity
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 7)
    protected int id;

    //@JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    protected Date updatedAt;

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public void setUpdatedAt(Date date) {
        this.updatedAt = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId(){return id;}
}
