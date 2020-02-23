package Model;

import Utils.Utilities;

import java.util.List;
import java.util.Random;

public enum BotResponse {

    SALUTE("Hello! Where do you want to travel next?", "Hi, how may I assist you?"),
    TRAVEL("Where do you want to go? Maybe ", "I think you could like "),
    BYE("Goodbye!", "Bye, enjoy your vacation!"),
    UNKNOWN("Sorry, I didn't understand what you said.", "I can't understand this.", "I don't know what you mean.", "Try explaining it with other words please.");

    private String[] botResponses;

    BotResponse(String... botResponses) {
        this.botResponses = botResponses;
    }

    public ResponseData getResponse(BotResponse botResponse) {
        int random = new Random().nextInt(botResponses.length);

        ResponseData response = new ResponseData();

        if (botResponse.equals(TRAVEL)) {
            List<String> responses = Utilities.httpRequest("denmark");
            response.setResponse(responses.get(0) + " (" + responses.get(1) + ")");
            response.setCity(responses.get(0));
            response.setCountry(responses.get(1));
        } else {
            response.setResponse(botResponses[random]);
        }

        return response;
    }

}
