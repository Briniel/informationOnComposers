package MIvanov;

import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws SQLException {
//        Artist artist = new Artist();
//        System.out.println(artist.getArtist().length);

        new DBConnect().SELECT("tewt");
    }
}
