package liamohara.view;

import liamohara.controller.DecoderController;
import java.util.Scanner;

public class MainActivity {

    private static DecoderController decoderController = new DecoderController();

    public static void Run() {

        String welcomeMsg = "Welcome to the Morse Code Decoder!\n\n";
        String guidance = "Morse code letters must be separated by a SINGLE space and word by a TRIPLE space.\n";
        String question = "Are you ready to decode morse code? [Y / N] and hit ENTER.";
        String questionAgain = "Do you want to decode more morse code? [Y / N] and hit ENTER.";
        String enterMorse = "Please enter the morse code you wish to decode and hit ENTER.";
        String resultPrefix = "Decoded morse code: ";
        String thanks = "Thank you for using the Morse Code Decoder. Goodbye.";
        boolean isUserInputtingData = true;

        String answer = "";
        String morseInput = "";


        System.out.println(welcomeMsg + guidance);

        System.out.println(question);

        try (Scanner scanner = new Scanner(System.in)) {
            answer = scanner.nextLine();

            while (isUserInputtingData) {

                if (answer.equalsIgnoreCase("N")) {
                    isUserInputtingData = false;
                    System.out.println(thanks);

                } else {
                    System.out.println(enterMorse);
                    morseInput = scanner.nextLine();

                    System.out.println(resultPrefix + decode(morseInput));

                    System.out.println(questionAgain);
                    answer = scanner.nextLine();
                }
            }
        }
    }

    public static String decode(String morseCode) {

        return decoderController.decode(morseCode);
    }

}
