package org.superbiz.moviefun.moviesapi.albums;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestOperations;
import java.util.List;

import static org.springframework.http.HttpMethod.GET;

public class AlbumsClientImpl implements AlbumsClient {
    private static ParameterizedTypeReference<List<AlbumInfo>> albumListType = new ParameterizedTypeReference<List<AlbumInfo>>() {
    };
    private String albumsUrl;
    private RestOperations restOperations;

    public AlbumsClientImpl(String albumsUrl, RestOperations restOperations) {
        this.albumsUrl = albumsUrl;
        this.restOperations = restOperations;
    }

    @Override
    public List<AlbumInfo> getAlbums() {
        return restOperations.exchange(albumsUrl, GET, null, albumListType).getBody();
    }

    @Override
    public AlbumInfo find(long albumId) {
        return restOperations.exchange(albumsUrl + "/" + albumId, GET, null, AlbumInfo.class).getBody();
    }

    @Override
    public void addAlbum(AlbumInfo album) {
        restOperations.postForEntity(albumsUrl, album, AlbumInfo.class);
    }
}
