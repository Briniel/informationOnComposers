package MIvanov;

import java.util.ArrayList;

/**
 * Created by IvaMA on 01.03.2019
 */


public class Musician {
    private String name;
    private ArrayList Albums;

    public String getName() {
        return name;
    }

    public Musician setName(String name) {
        this.name = name;
        return null;
    }

    public ArrayList getAlbums() {
        return Albums;
    }

    public Musician setAlbums(ArrayList albums) {
        Albums = albums;
        return null;
    }
}
