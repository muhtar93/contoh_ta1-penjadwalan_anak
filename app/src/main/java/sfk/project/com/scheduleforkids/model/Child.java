package sfk.project.com.scheduleforkids.model;

/**
 * Created by Toshiba-PC on 8/20/2017.
 */

public class Child {
    public String title;
    public String schedule;
    public String date;
    public String times;
    public String point;
    public int image;

    public Child(String title){
        this.title = title;
    }

    public Child(String title, String schedule, String date, String times, String point, int image){
        this.title = title;
        this.schedule = schedule;
        this.date = date;
        this.times = times;
        this.point = point;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
