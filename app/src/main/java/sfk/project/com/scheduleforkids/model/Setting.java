package sfk.project.com.scheduleforkids.model;

/**
 * Created by Toshiba-PC on 8/20/2017.
 */

public class Setting {
    public String title;
    public String schedule;
    public String date;
    public String times;
    public String mom;
    public String point;

    public Setting(String title){
        this.title = title;
    }

    public Setting(String title, String schedule, String date, String times, String mom,String point){
        this.title = title;
        this.schedule = schedule;
        this.date = date;
        this.times = times;
        this.times = mom;
        this.point = point;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getSchedule() {
        return schedule;
    }

    public void SetSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getDate() {
        return date;
    }

    public void SetDate(String date) {
        this.date = date;
    }

    public String getTimes() {
        return times;
    }

    public void SetTimes(String times) {
        this.times = times;
    }

    public String getMom() {
        return mom;
    }

    public void SetMom(String mom) {
        this.mom = mom;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}