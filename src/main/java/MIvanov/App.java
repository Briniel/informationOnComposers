package MIvanov;

import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws SQLException {
        Musician[] musicians = new Artist().getArtist();

        for (int i = 0; i < musicians.length; ++i) {
            for (int a = 0; a < musicians[i].getAlbums().size(); ++a) {
                new DBConnect().INSERT(musicians[i].getName(), (String) musicians[i].getAlbums().get(a));
            }
        }
    }
}
