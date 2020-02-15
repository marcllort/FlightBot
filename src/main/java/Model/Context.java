package Model;

public enum Context {

    WELCOME(null, null, null, new WordList("sda", "asd"));

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

    public String getBotResponse() {
        return botResponse.getResponse();
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
