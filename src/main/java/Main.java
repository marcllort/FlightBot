import Model.FlightBot;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean run = true;
        FlightBot bot = new FlightBot();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Ask me something:");

        while (run) {
            String question = keyboard.nextLine();
            String response = bot.getResponse(question);

            if ('!' == response.charAt(0)) {
                run = false;
                StringBuilder sb = new StringBuilder(response);
                sb.deleteCharAt(0);
                System.out.println(sb.toString());
            } else {
                System.out.println(response);
            }
        }

    }
}
