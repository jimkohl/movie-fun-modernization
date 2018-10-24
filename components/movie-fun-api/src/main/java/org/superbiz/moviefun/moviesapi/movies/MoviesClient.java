package org.superbiz.moviefun.moviesapi.movies;

import java.util.List;

public interface MoviesClient {
    void addMovie(MovieInfo movie);

    void deleteMovieId(long id);

    int countAll();

    int count(String field, String searchTerm);

    List<MovieInfo> findAll(int firstResult, int maxResults);

    List<MovieInfo> findRange(String field, String searchTerm, int firstResult, int maxResults);

    List<MovieInfo> getMovies();
}
