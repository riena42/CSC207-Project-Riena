package java_use_case.rec_album;

import entity.Album;
import use_case.rec_album.RecAlbumDataAccessInterface;

import java.util.ArrayList;

class TestAlbumDataAccessObject implements RecAlbumDataAccessInterface {
    private final boolean returnEmptyList;

    public TestAlbumDataAccessObject() {
        this(false);
    }

    public TestAlbumDataAccessObject(boolean returnEmptyList) {
        this.returnEmptyList = returnEmptyList;
    }

    @Override
    public ArrayList<Album> getNewReleases() {
        if (returnEmptyList) {
            return new ArrayList<>();
        }
        ArrayList<Album> albums = new ArrayList<>();
        albums.add(new Album("1", "Album1", 90, new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        return albums;
    }
}
