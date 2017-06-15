package RockPaperScissors;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Łukasz on 2017-06-14.
 */
public class RockPaperScissors {
    enum handValue {
        ROCK,
        PAPER,
        SCISSORS;

        public static handValue getHandValueFromInt(int num){
            switch (num){
                case 1:
                    return ROCK;
                case 2:
                    return PAPER;
                case 3:
                    return SCISSORS;
            }
            return ROCK;
        }

        public static handValue getHandValueFromChar(char c){
            switch (c){
                case 'r':
                    return  ROCK;
                case 'p':
                    return PAPER;
                case 's':
                    return SCISSORS;
            }
            return ROCK;
        }

        public static int compare(handValue v1, handValue v2) {
            if (v1.equals(v2))
                return 0;
            else {
                switch (v1) {
                    case ROCK:
                        switch (v2) {
                            case PAPER:
                                return -1;
                            case SCISSORS:
                                return 1;
                        }
                    case PAPER:
                        switch (v2) {
                            case ROCK:
                                return 1;
                            case SCISSORS:
                                return -1;
                        }
                    case SCISSORS:
                        switch (v2) {
                            case ROCK:
                                return -1;
                            case PAPER:
                                return 1;
                        }
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        int score = 0;
        int opponentScore = 0;
        char select = ' ';
        handValue yourSelect;
        handValue opponentSelect;
        int comparision;
        Scanner load = new Scanner(System.in);
        Random randomHand = new Random();

        System.out.println("Welcome to Rock-Paper-Scissors game!");
        while(select!='e') {
            System.out.println("Your current Score: " + score);
            System.out.println("Opponents current Score: " + opponentScore);
            System.out.println("Type: \n" +
                    "r - for rock,\n" +
                    "p - for paper,\n" +
                    "s - for scissors\n" +
                    "e - for end.");
            select = load.next(".").charAt(0);
            while(select!='r' && select!='p' && select!='s' && select!='e' ) {
                System.out.println("Unsupported option, try again.");
                select = load.next(".").charAt(0);
            }

                if(select=='e')
                    break;

                yourSelect = handValue.getHandValueFromChar(select);
                opponentSelect = handValue.getHandValueFromInt(randomHand.nextInt(3)+1);

                System.out.println("You selected " + yourSelect);
                System.out.println("Your opponent selected " + opponentSelect);

                comparision = handValue.compare(yourSelect, opponentSelect);
                switch(comparision){
                    case 1:
                        score++;
                        System.out.println("You won!");
                        break;
                    case 0:
                        System.out.println("Draw!");
                        break;
                    case -1:
                        opponentScore++;
                        System.out.println("Your opponent won!");
                }

        }

        System.out.println("The game has ended, final score is:\n");
        System.out.println("Your Score: " + score);
        System.out.println("Opponents Score: " + opponentScore);
    }
}
