package MIvanov.dbo.Services;

import MIvanov.dbo.Table.ArtistTable;
import MIvanov.dbo.dao.UserDao;

import java.util.List;

/**
 * Created by IvaMA on 02.03.2019
 */


public class UserServices {

    private UserDao usersDao = new UserDao();

    public UserServices() {
    }

    public ArtistTable findArtist(int id) {
        return usersDao.findById(id);
    }

    public void saveArtist(ArtistTable artist) {
        usersDao.save(artist);
    }

    public void deleteArtist(ArtistTable artist) {
        usersDao.delete(artist);
    }

    public void updateArtist(ArtistTable artistTable) {
        usersDao.update(artistTable);
    }

    public List<ArtistTable> findAllArtists() {
        return usersDao.findAll();
    }

}
