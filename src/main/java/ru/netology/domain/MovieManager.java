package ru.netology.domain;
public class MovieManager {
    private MoviesLibrary[] movies = new MoviesLibrary[0];
    private int feedCount = 10;

    public void add(MoviesLibrary movie) {

        int length = movies.length + 1;
        MoviesLibrary[] tmp = new MoviesLibrary[length];

        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public MoviesLibrary[] getAll() {
        MoviesLibrary[] result = new MoviesLibrary[movies.length];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public MoviesLibrary[] getMovies() {
        int feed = this.feedCount;
        if (feed > movies.length)
            feed = movies.length;
        MoviesLibrary[] result = new MoviesLibrary[feed];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];

        }
        return result;
    }
    public MovieManager(int feedCount) {
        this.feedCount = feedCount;
    }
}
