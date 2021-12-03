package NL.game;

public class User {
    String username;
    String answer;
    int point;

    public User(String name) {
        this.username = name;
    }

    public String getPlayer() {
        return username;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer(){
        return answer;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}