package Model;

import static Model.BotResponse.SALUTE;
import static Model.BotResponse.TRAVEL;

public enum Context {

    WELCOME(null, null, SALUTE, new WordList("hey", "asd")),
    TRAVELTO(null, null, TRAVEL, new WordList("travel"));

    private WordList wordList;
    private BotResponse botResponse;
    private Context context;
    private Suggestions suggestions;

    Context(Context context, Suggestions suggestions, BotResponse botResponse, WordList wordList) {
        this.context = context;
        this.suggestions = suggestions;
        this.botResponse = botResponse;
        this.wordList = wordList;
    }

    public boolean isWordInList(String word) {
        return wordList.contains(word);
    }

    public WordList getWordList() {
        return wordList;
    }

    public ResponseData getBotResponse() {
        return botResponse.getResponse(this.botResponse);
    }

    public Context getNextContext() {
        return context;
    }

    public Suggestions getSuggestions() {
        return suggestions;
    }

    public Context wordExists(String word) {

        for (Context con : Context.values()) {
            if (con.isWordInList(word)) {
                return con;
            }
        }

        return null;

    }

}
