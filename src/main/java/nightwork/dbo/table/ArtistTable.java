package nightwork.dbo.table;

import javax.persistence.*;

/**
 * Created by IvaMA on 02.03.2019
 */

@Entity
@Table(name = "artist")
public class ArtistTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name_artist")
    private String name_artist;
    //можно не указывать Column name, если оно совпадает с названием столбца в таблице
    private String album;

    public ArtistTable() {
    }

    public ArtistTable(String name, String album) {
        this.name_artist = name;
        this.album = album;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name_artist;
    }

    public void setName(String name) {
        this.name_artist = name;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }


    @Override
    public String toString() {
        return "models.User{" +
                "id=" + id +
                ", name='" + name_artist + '\'' +
                ", album=" + album +
                '}';
    }
}
