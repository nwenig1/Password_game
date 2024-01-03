
package passwordpuzzle;

import java.util.Scanner;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }
    public static void main(String[] args) {
        boolean invalid_password = true;
        boolean try_again = true;
        Scanner scanner = new Scanner(System.in);
        while (invalid_password && try_again) {
            System.out.println("Enter your password: ");
            String guess = scanner.nextLine();
            String feedback = checkWord_str(guess); 
            System.out.println(feedback);
            if(feedback.equals("Password Accepted")){
                invalid_password = false; 
                System.out.println("invalid password set to false");
            } else{
                  System.out.println("Try another guess? (yes/no)");
                String repeat_char = scanner.nextLine();
                repeat_char = repeat_char.toUpperCase();
                if (repeat_char.equals("NO")) {
                    try_again = false;
                }
            }
            //     invalid_password = isValid(guess); // check to see if word is valid
       //     if (invalid_password) {
       //         System.out.println(checkWord_str(guess)); // say why its invalid
       //         System.out.println("Try another guess? (yes/no)");
       //         String repeat_char = scanner.nextLine();
       //         repeat_char = repeat_char.toUpperCase();
       //         if (repeat_char.equals("NO")) {
       //             try_again = false;
       //         }
       //     }
        }
        scanner.close();
        
        if (invalid_password == true) {

            System.out.println("Thanks for Playing");
        }

    }

    public static boolean isValid(String guess) { 
        if (checkWord_str(guess).contains("Rule:")) {
            return false;
        } else {
            return true;
        }
    }

    public static String checkWord_str(String guess) {

        if (guess.length() < 5) {
            return "Rule 1: Password must have more than 5 or more characters";
        } else if (guess.replaceAll("[^0-9]", "").length() == 0) {
            return "Rule 2: Password must contain at least one number";
        } else if (guess.charAt(0) != 'A') {
            return "Rule 3: Password must start with an A";
        } else if (!guess.contains("password")) {
            return "Rule 4: Password must contain password";
        } else if (guess.contains(" ")) {
            return "Rule 5: Password can't contain a space";
        } else if (rule4(guess) != 19) {
            return "Rule 6: Sum of the digits must add up to 19";
        } else if (guess.charAt(guess.length() - 1) != 'A') {
            return "Rule 7: Password must start and end with the same character";
        } else if ((guess.contains("State Farm") ||
                guess.contains("Liberty Mutual") ||
                guess.contains("IBM")) == false) {
            return "Rule 8: Password must contain the name of one of our sponsors \n sponsors include:State Farm, Liberty Mutual, IBM ";
        } else if (guess.replaceAll("[a-zA-Z0-9]", "").length() != 6) {
            return "Rule 9: Password must contain 6 special characters";
            // } else if(!guess.contains("10♥J♥Q♥K♥A♥")){
            // return "Rule 10: Password must contain a royal flush of hearts written in the
            // format: \n number, suit, number suit";
        } else if (!guess.contains("Bb4Nd3")) {
            return "Rule 11: Password must contain the 43rd move of game 1 of the 2023 world chess championship \n in algebraic notation (altered in compliance of rule 5)";
        } else if ((guess.contains("UnitedStates") || guess.contains("GreatBritain")
                || guess.contains("SovietUnion")) == false) {
            return "Rule 12: Password must contain one of the members of the allied powers";
        } else if ((guess.contains("$13.80") || guess.contains("$7.25")) == false) {
            return "Rule 13: Password must contain the federal minimum wage or the minumum wage in Maine (as of 2023)";
        }

        else {
            return "Password Accepted";
        }

    }

    public static int rule4(String guess) {
        int sum = 0;
        String guess_nums = guess.replaceAll("[^0-9]", "");
        if (guess_nums.length() != 0) {
            int nums = Integer.parseInt(guess_nums);
            while (nums != 0) {
                sum = sum + nums % 10;
                nums = nums / 10;

            }
        }

        return sum;
    }
}
