package nightwork;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

/**
 * Created by IvaMA on 01.03.2019
 */


public class Albums {

    public ArrayList getAlbums(String name) {
        try {
            name = name.replaceAll(" ", "%20");
            String JSON = "http://ws.audioscrobbler.com/2.0/?method=artist.gettopalbums&artist=" + name + "&api_key=c8b0af291a916983c205a7f1fbbd04bc&format=json";
            JSONObject jo = (JSONObject) new GetJson().getJsonObject(JSON).get("topalbums");
            JSONArray ja = (JSONArray) jo.get("album");
            ArrayList album = new ArrayList();

            for (int i = 0; i < ja.size(); ++i) {
                JSONObject nameAlbum = (JSONObject) ja.get(i);
                album.add(nameAlbum.get("name"));
            }

            return album;
        } catch (SecurityException e) {
            System.out.println(e);
        }
        return null;
    }
}
