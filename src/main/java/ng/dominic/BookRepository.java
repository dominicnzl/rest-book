package ng.dominic;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    @ConfigProperty(name = "books.genre", defaultValue = "Roman")
    String genre;
    public List<Book> getAllBooks() {
        return List.of(
                new Book(1, "bla", "henk", 2020, genre),
                new Book(2, "floeps", "henk", 2020, genre),
                new Book(3, "bonk", "joep", 2012, genre),
                new Book(4, "ekki ekki", "teun", 2012, genre)
        );
    }
    public Optional<Book> findBook(int id) {
        return getAllBooks().stream().filter(book -> book.id == id).findFirst();
    }
}
