import com.baeldung.gson.entities.ActorGson;
import com.baeldung.gson.entities.Movie;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class Serializacao {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        ActorGson rudyYoungblood = new ActorGson(
                "nm2199632",
                sdf.parse("21-09-1982"),
                Arrays.asList("Apocalypto",
                        "Beatdown", "Wind Walkers")
        );
        Movie movie = new Movie(
                "tt0472043",
                "Mel Gibson",
                Arrays.asList(rudyYoungblood));

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                //.excludeFieldsWithoutExposeAnnotation()
                //.serializeNulls()
                //.disableHtmlEscaping()
                //.registerTypeAdapter(ActorGson.class, new ActorGsonSerializer())
                .create();

        String serializedMovie = gson.toJson(movie);

        System.out.println(serializedMovie);
    }
}
