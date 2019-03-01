package MIvanov;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

/**
 * Created by IvaMA on 01.03.2019
 */


public class Artist {

    public Musician[] getArtist() {
        String JSON = "http://ws.audioscrobbler.com/2.0/?method=artist.search&artist=cher&api_key=c8b0af291a916983c205a7f1fbbd04bc&format=json";
        JSONObject jo = (JSONObject) new GetJson().getJsonObject(JSON).get("results");
        JSONObject ja = (JSONObject) jo.get("artistmatches");
        JSONArray jsonArray = (JSONArray) ja.get("artist");
        Musician[] musician = new Musician[jsonArray.size()];

        for (int i = 0; i < jsonArray.size(); ++i) {

            JSONObject nameArtist = (JSONObject) jsonArray.get(i);
            String name = (String) nameArtist.get("name");

            ArrayList album = new Albums().getAlbums(name);
            musician[i] = new Musician(name, album);
        }

        return musician;
    }
}
