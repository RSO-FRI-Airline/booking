package si.fri.rso.models.dtos;

import java.util.Date;


public class Price {

    private int id;
    private float price;
    private Schedule schedule;
    private Date date;
    private int ticketClass;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(int ticketClass) {
        this.ticketClass = ticketClass;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
