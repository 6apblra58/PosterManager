package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {
    private MovieManager manager = new MovieManager(10);
    MoviesLibrary first = new MoviesLibrary(1, "Боевик", "Бладшот");
    MoviesLibrary second = new MoviesLibrary(2, "Мультфильм", "Вперед");
    MoviesLibrary third = new MoviesLibrary(3, "Комедия", "ОтельБелград");
    MoviesLibrary fourth = new MoviesLibrary(4, "Боевик", "Джентльмены");
    MoviesLibrary fifth = new MoviesLibrary(5, "Ужасы", "ЧеловекНеведимка");
    MoviesLibrary sixth = new MoviesLibrary(6, "Мультфильм", "ТроллиМировойТур");
    MoviesLibrary seventh = new MoviesLibrary(7, "Комедия", "НомерОдин");
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }

   @Test
   public void addMoviesToEmpty() {
       manager.add(first);
       assertArrayEquals(new MoviesLibrary[]{first}, manager.getAll());
   }

    @Test
    public void addMoviesToExisted() {
        manager.add(first);
        MoviesLibrary[] expected = new MoviesLibrary[]{first};
        MoviesLibrary[] actual = manager.getAll();
        assertArrayEquals(new MoviesLibrary[]{first}, manager.getAll());

        manager.add(second);
        MoviesLibrary[] expectedAdded = new MoviesLibrary[]{second, first};
        MoviesLibrary[] actualAdded = manager.getAll();
        assertArrayEquals(expectedAdded, actualAdded);
    }

    @Test
    void moviesForFeed() {
        setUp();
        MoviesLibrary[] expected = new MoviesLibrary[]{fifth, fourth, third, second, first};
        MoviesLibrary[] actual = manager.getMovies();
        assertArrayEquals(expected, actual);
    }

    @Test
    void MoviesMinFeed() {
        manager = new MovieManager(3);
        setUp();
        MoviesLibrary[] expected = new MoviesLibrary[]{fifth, fourth, third};
        MoviesLibrary[] actual = manager.getMovies();
        assertArrayEquals(expected, actual);
    }


}
