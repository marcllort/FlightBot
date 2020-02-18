import Model.FlightBot;

public class Main {
    public static void main(String[] args) {

        FlightBot bot = new FlightBot();
        String response = bot.getResponse("travel");
        System.out.println(response);

    }
}
