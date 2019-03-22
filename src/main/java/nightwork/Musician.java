package nightwork;

import java.util.ArrayList;

/**
 * Created by IvaMA on 01.03.2019
 */


public class Musician {
    private String name;
    private ArrayList albums;

    public Musician(String name, ArrayList albums) {
        this.name = name;
        this.albums = albums;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList getAlbums() {
        return albums;
    }

    public void setAlbums(ArrayList albums) {
        this.albums = albums;
    }
}
