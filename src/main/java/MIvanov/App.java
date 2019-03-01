package MIvanov;

import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws SQLException {
        Musician[] musicians = new Artist().getArtist();

        for (int i = 0; i < musicians.length; ++i) {
            musicians[i].getName();
        }

//        new DBConnect().INSERT("werwerwer", "werwerwewwerwe");


    }
}
