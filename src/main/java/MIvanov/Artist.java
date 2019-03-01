package MIvanov;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

/**
 * Created by IvaMA on 01.03.2019
 */


public class Artist {

    public ArrayList getArtist() {
        String JSON = "http://ws.audioscrobbler.com/2.0/?method=artist.search&artist=cher&api_key=c8b0af291a916983c205a7f1fbbd04bc&format=json";
        JSONObject jo = (JSONObject) new GetJson().getJsonObject(JSON).get("results");
        JSONObject ja = (JSONObject) jo.get("artistmatches");
        JSONArray jsonArray = (JSONArray) ja.get("artist");
        ArrayList artist = new ArrayList();

        for (int i = 0; i < jsonArray.size(); ++i) {
            Musician musician = new Musician();

            JSONObject nameArtist = (JSONObject) jsonArray.get(i);
            String name = (String) nameArtist.get("name");
            musician.setName(name);

            ArrayList album = new Albums().getAlbums(name);
            musician.setAlbums(album);
            artist.add(musician);
        }

        return artist;
    }
}
