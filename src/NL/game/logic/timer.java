package NL.game.logic;


public class timer {
    String answerPlayer1 = " ";
    String answerPlayer2 = " ";

    public class time {
        public static void main(String[] args) {
            int count =60;
            long startTime = 0;
            System.out.println("vous avez 60 secondes pour réfléchir");
            while (count > 0) {
                System.out.print("\033[H\033[2J");
                System.out.println(count-- );
                startTime = System.currentTimeMillis();
                while ((System.currentTimeMillis() - startTime) < 1000) {
                }
            }
            count =30;
            System.out.println("vous avez 30 secondes pour entrer vos réponses");
            startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < 6000 /* || (player1.answer is valid && player2.answer is valid*/) {
                //Menu.PlayerTurn <=> qui répond joueur 1 ou 2?
                //Player1/2.answer <=> stock réponse dans objet user?
            }
            System.out.println("Le temps est écoulé");
            //appel game.result

        }
    }

}
