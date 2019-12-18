package springframework.guru.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.guru.spring5webapp.model.Book;

/**
 * @author kas
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
