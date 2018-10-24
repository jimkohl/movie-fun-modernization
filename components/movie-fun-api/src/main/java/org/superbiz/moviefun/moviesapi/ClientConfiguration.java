package org.superbiz.moviefun.moviesapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.superbiz.moviefun.moviesapi.albums.AlbumsClient;
import org.superbiz.moviefun.moviesapi.albums.AlbumsClientImpl;
import org.superbiz.moviefun.moviesapi.movies.MoviesClient;
import org.superbiz.moviefun.moviesapi.movies.MoviesClientImpl;

@SuppressWarnings({"unused", "WeakerAccess"})
@Configuration
public class ClientConfiguration {

    @Value("${MOVIES_URL}")
    String moviesUrl;
    @Value("${ALBUMS_URL}")
    String albumsUrl;

    @Bean
    public RestOperations restOperations() {
        return new RestTemplate();
    }

    @Bean
    public MoviesClient moviesClient(RestOperations restOperations) {
        return new MoviesClientImpl(moviesUrl, restOperations);
    }

    @Bean
    public AlbumsClient albumsClient(RestOperations restOperations) {
        return new AlbumsClientImpl(albumsUrl, restOperations);
    }
}