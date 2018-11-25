package si.fri.rso.models.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


public class Price {

    private int id;
    private float price;
    private Schedule schedule;
    private String date;
    private int ticketClass;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    @Override
    public String toString() {
        return "id: " + id + "\nprice: " + price + "\nSchedule: " + schedule.toString() + "\nDate: " + date.toString()
            + "\n Ticket Class: " + ticketClass;
    }
}
