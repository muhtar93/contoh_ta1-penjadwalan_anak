package sfk.project.com.scheduleforkids.model;

/**
 * Created by muhtar on 8/17/17.
 */

public class Notification {
    public String title;
    public String point;
    public String jam;
    public int img;

    public Notification(String title){
        this.title = title;
    }

    public Notification(String title, String point, int img){
        this.title = title;
        this.point = point;
        this.img = img;
    }

    public Notification(String title, String point, int img, String jam){
        this.title = title;
        this.point = point;
        this.img = img;
        this.jam = jam;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
