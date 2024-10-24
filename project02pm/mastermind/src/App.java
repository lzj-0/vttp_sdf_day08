package project02pm.mastermind.src;

import java.io.Console;
import java.util.*;

public class App {
    public static void main(String[] args) {
        Integer noOfTries = 10;
        if (args.length == 1) {
            noOfTries = Integer.parseInt(args[0]);
        }

        Mastermind mastermind = new Mastermind(noOfTries);
        Console cons = System.console();
        Random rand = new Random();
        String[] answer = new String[4];
        for (int i = 0; i < 4; i++) {
            answer[i] = String.valueOf(rand.nextInt(1, 7));
        }
        String answerString = String.join("", answer);
        int game = 0;
        Boolean win = false;
        Boolean error = false;
        //System.out.println(answerString);

        while (game < noOfTries) {
            int cp = 0;
            int c = 0;
            error = false;
            String[] guess = cons.readLine("Enter 4 digits from using digits 1 - 6: ").split("");
            for (int i = 0; i < guess.length; i++) {
                if (Integer.parseInt(guess[i]) > 6 || Integer.parseInt(guess[i]) == 0) {
                    error = true;
                    break;
                }
            }
            if (error) {
                System.out.println("Invalid input. Please try again.");
                continue;
            }
            ArrayList<String> answerLs = new ArrayList<String>(Arrays.asList(answer));
            ArrayList<Integer> correctPos = new ArrayList<Integer>();
            for (int i = 0; i < guess.length; i++) {
                mastermind.getBoard()[game][i] = Integer.parseInt(guess[i]);
                if (answer[i].equals(guess[i])) {
                    //System.out.println("cp: " + guess[i]);
                    cp++;
                    correctPos.add(i);
                    answerLs.remove(String.valueOf(guess[i]));
                }
            }

            for (int i = 0; i < guess.length; i++) {
                if (correctPos.contains(i)) {
                    continue;
                } else if (answerLs.contains(guess[i])) {
                    c++;
                    answerLs.remove(String.valueOf(guess[i]));
                }
            }

            mastermind.getCp()[game] = cp;
            mastermind.getC()[game] = c;
            mastermind.printBoard();
            game++;
            if (cp == 4) {
                win = true;
                break;
            }
        }
        if (win) {
            System.out.println("Congratulations! You have won!");
        } else {
            System.out.println("Game Over! Better luck next time.");
            System.out.printf("Correct answer: %s", answerString);
        }

    }
}
