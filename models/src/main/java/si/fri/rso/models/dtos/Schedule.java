package si.fri.rso.models.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Schedule {

    private int day_of_week;
    private Time start_time;
    private Time end_time;

    public int getDay_of_week() {
        return day_of_week;
    }

    public void setDay_of_week(int day_of_week) {
        this.day_of_week = day_of_week;
    }

    public Time getStart_time() {
        return start_time;
    }

    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }

    public Time getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Time end_time) {
        this.end_time = end_time;
    }

    public long GetDuration(){
        long diff = end_time.getTime() - start_time.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.SECONDS);
    }
}

