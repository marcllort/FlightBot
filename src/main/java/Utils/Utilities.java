package Utils;

import Model.Place;
import Model.Places;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utilities {

    public static String httpRequest(String destination) {
        try {
            HttpResponse<String> response = Unirest.get("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/autosuggest/v1.0/UK/GBP/en-GB/?query=" + destination)
                    .header("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
                    .header("x-rapidapi-key", "6596d5c78dmsha7a707a09a23029p1a74c8jsndf266d167c11")
                    .asString();
            //System.out.println(response.getBody());
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Place>>(){}.getType();

            Places places = gson.fromJson(response.getBody(),Places.class);

            int random = new Random().nextInt(places.getPlaces().size());
            return places.getPlaces().get(random).getPlaceName()+" ("+places.getPlaces().get(random).getCountryName()+")";
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return "error";
    }
}
