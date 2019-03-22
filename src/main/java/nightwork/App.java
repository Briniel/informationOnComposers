package nightwork;

import nightwork.dbo.services.UserServices;
import nightwork.dbo.table.ArtistTable;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        Musician[] musicians = new Artist().getArtist();
        UserServices userServices = new UserServices();

        for (int i = 0; i < musicians.length; ++i) {
            for (int a = 0; a < musicians[i].getAlbums().size(); ++a) {
                ArtistTable artistTable = new ArtistTable(musicians[i].getName(), (String) musicians[i].getAlbums().get(a));
                userServices.saveArtist(artistTable);
            }
        }

    }
}
