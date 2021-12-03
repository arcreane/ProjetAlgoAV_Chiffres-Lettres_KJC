package NL.game.logic;

import NL.game.Game;
import java.io.IOException;

public class Timer {

    public static void timer(Game game) throws IOException {
        int count = 1;
        long startTime;
        System.out.println("\nYou have 60 seconds to think about your answer.");
        while (count > 0) {
            System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
            System.out.print("Time left : " + "\033[H\033[2J");
            System.out.print(count-- );
            startTime = System.currentTimeMillis();
            while ((System.currentTimeMillis() - startTime) < 1000) {
            }
        }

        count = 1;
        boolean tryingToStop = true;
        System.out.println("\nYou have 30 seconds left to enter your answer.\n");
        startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < (count*1000)) {
            if(tryingToStop) {
                for(int user = 0; user < 2; user++) {
                    game.whichPlayerAnswer();
                }
                tryingToStop = false;
            }
        }
        System.out.println("Time is up !");
    }
}
