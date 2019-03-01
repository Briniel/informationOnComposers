package MIvanov;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by IvaMA on 01.03.2019
 */


public class GetJson {

    public JSONObject getJsonObject(String query) {

        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) new URL(query).openConnection();

            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setConnectTimeout(2500);
            connection.setReadTimeout(2500);

            connection.connect();

            StringBuilder sd = new StringBuilder();

            if (sun.net.www.protocol.http.HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));


                String line;
                while ((line = in.readLine()) != null) {
                    sd.append(line);
                    sd.append("\n");
                }

                JSONParser parser = new JSONParser();
                Object obj = parser.parse(sd.toString());
                JSONObject jsonObject = (JSONObject) obj;
                return jsonObject;

            } else {
                System.out.print("FAIL: " + connection.getResponseCode() + ", " + connection.getResponseMessage());
            }
        } catch (Throwable cause) {
            cause.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }
}
