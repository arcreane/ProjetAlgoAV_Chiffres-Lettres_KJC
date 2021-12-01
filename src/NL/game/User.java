package NL.game;

public class User {
    String username;
    String answer;

    public User(String name) {
        this.username = name;
    }

    public String getPlayer() {
        System.out.println("Bonjour");
        return username;
    }


    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer(){
        return answer;
    }



}
