package NL.game;

public class User {
    String username;

    public User(String name) {
        this.username = name;
    }

    public String getPlayer() {
        System.out.println("Bonjour");
        return username;
    }
}
