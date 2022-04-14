package soop;

import java.util.*;

public class userRespUtils {
    private static boolean inputValid;

    private static Scanner in = new Scanner(System.in);

    /**
     * Toggle whether or not the input is valid or not
     * @param in Whether or not the input is valid or not
     */
    public static void setInValidity(boolean in) {
        inputValid = in;
    }

    /**
     * Returns the validity of the input
     */
    public static boolean getInValidity() {
        return inputValid;
    }

    /**
     * Takes a String array of options, prints them out, prompts the user to select one from them, and returns the user's response
     * @param options A String array of menu options
     * @return the user's pick
     */
    public static int displayOptions(String[] options) {
        for (int i = 0; i < options.length; i++) {
			System.out.println("(" + i + ") " + options[i]);
		}

		int userPick = 0;
		do {
			try {
                inputValid = false;
				System.out.print("(");
				for (int i = 0; i < options.length; i++) {
					System.out.print(i);
					if (i != options.length-1) {
						System.out.print(", ");
					} else {
						System.out.print(") > ");
					}
				}
				userPick = in.nextInt();

                if (userPick < 0 || userPick >= options.length) {
                    System.err.println("That is not a valid option.");
                } else {
                    inputValid = true;
                }
			} catch (Exception e) {
				System.out.println("That is not a valid option.");
				clearScanner();
			}
		} while (!inputValid);

		return userPick;
    }

    /**
     * Asks the user a question, prompts them for an answer, and returns their response
     * @param question Question to ask the user
     * @return The user's response
     */
    public static String askQuestion(String question) {
        System.out.println(question);
        System.out.print("> ");
        return in.nextLine();
    }

    /**
     * Asks the user a question that expects a double, prompts them for an answer, and returns a valid reponse
     * @param question Question to ask the user
     * @return The user's response
     */
    public static double askQuestionDbl(String question) {
        double response = 0;
        do {
            inputValid = false;
            try {
                System.out.println(question);
                System.out.print("[dbl] > ");
                response = in.nextDouble();
            } catch (Exception e) {
                System.out.println("That is not a valid number"); 
                clearScanner(); 
            }
        } while (!inputValid);

        return response;
    }

    /**
     * Asks the user a question that expects an integer, prompts them for an answer, and returns a valid response
     * @param question Question to ask the user
     * @return The user's resposne
     */
    public static int askQuestionInt(String question) {
        int response = 0;
        do {
            inputValid = false;
            try {
                System.out.println(question);
                System.out.print("(int) > ");
                response = in.nextInt();
            } catch (Exception e) {
                System.out.println("That is not a valid number"); 
                clearScanner(); 
            }
        } while (!inputValid);

        return response;
    }

    /**
     * Asks the user a y/n (yes or no) question, prompts them for an answer, and returns "true" if their answer is yes, "false" if their answer is no.
     * @param question Question to ask the user
     * @param answerDefault the answer to default to if the user doesn't enter anything. "true" for yes, "false" for no.
     * @return The user's response. "true" for yes, "false" for no. 
     */
    public static boolean askQuestionYN(String question, boolean answerDefault) {
        System.out.println(question);
        if (answerDefault) {
            System.out.print("[Y/n] > ");
        } else {
            System.out.print("[y/N] > ");
        }

        String response = in.nextLine();

        if (response == null || response.length() == 0) {
            if (answerDefault) {
                response = "y";
            } else {
                response = "n";
            }
        }

        if (response.toLowerCase().charAt(0) == 'y') {
            System.out.println("I'll take that as a \"yes.\"");
            return true;
        }

        System.out.println("I'll take that as a \"no.\"");
        return false;
    }

    /**
     * Redefines a Scanner, especially in the event that one is caught by an exception
     */
    public static void clearScanner() {
        in = new Scanner(System.in);
    }
}
