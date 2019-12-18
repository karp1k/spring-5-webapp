package springframework.guru.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import springframework.guru.spring5webapp.model.Author;
import springframework.guru.spring5webapp.model.Book;
import springframework.guru.spring5webapp.model.Publisher;
import springframework.guru.spring5webapp.repositories.AuthorRepository;
import springframework.guru.spring5webapp.repositories.BookRepository;
import springframework.guru.spring5webapp.repositories.PublisherRepository;

/**
 * @author kas
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository,
                        BookRepository bookRepository,
                        PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Author firstAuthor = new Author("Elena", "Freez");
        Publisher firstPublisher = new Publisher("AST", "Moscow");
        publisherRepository.save(firstPublisher);
        Book firstBook = new Book("Aloha", "1234", firstPublisher);
        firstAuthor.getBookSet().add(firstBook);
        firstBook.getAuthorSet().add(firstAuthor);

        authorRepository.save(firstAuthor);
        bookRepository.save(firstBook);

        Author secondAuthor = new Author("Rick", "Castle");
//        Publisher secondPublisher = new Publisher("NYT", "New York");
//        publisherRepository.save(secondPublisher);
        Book secondBook = new Book("Heat", "5678", firstPublisher);
        secondAuthor.getBookSet().add(secondBook);
        secondBook.getAuthorSet().add(secondAuthor);

        authorRepository.save(secondAuthor);
        bookRepository.save(secondBook);
    }
}
