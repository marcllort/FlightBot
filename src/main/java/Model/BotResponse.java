package Model;

import java.util.ArrayList;
import java.util.Random;

public enum BotResponse {

    SALUTE("Hello! What is the problem?", "Hi, how may I assist you?"),
    UNKNOWN("Sorry, I didn't understand what you said.", "I can't understand this.", "I don't know what you mean.", "Try explaining it with other words please.");


    private String[] botResponses;

    BotResponse(String... botResponses) {
        this.botResponses = botResponses;
    }

    public String getResponse() {
        int random = new Random().nextInt(botResponses.length);
        return botResponses[random];
    }

}