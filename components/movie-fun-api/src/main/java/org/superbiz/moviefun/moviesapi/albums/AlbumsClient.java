package org.superbiz.moviefun.moviesapi.albums;

import java.util.List;

public interface AlbumsClient {
    List<AlbumInfo> getAlbums();

    AlbumInfo find(long albumId);

    void addAlbum(AlbumInfo album);
}
