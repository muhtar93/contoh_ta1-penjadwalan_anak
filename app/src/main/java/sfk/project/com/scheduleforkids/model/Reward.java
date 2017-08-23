package sfk.project.com.scheduleforkids.model;

/**
 * Created by Toshiba-PC on 8/20/2017.
 */

public class Reward {
    public String title;
    public String reward;
    public String point;
    public int photo;

    public Reward(String title){
        this.title = title;
    }

    public Reward(String title, String reward, String point, int photo){
        this.title = title;
        this.reward = reward;
        this.point = point;
        this.photo = photo;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getReward() {
        return reward;
    }

    public void SetReward(String reward) {
        this.reward = reward;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}