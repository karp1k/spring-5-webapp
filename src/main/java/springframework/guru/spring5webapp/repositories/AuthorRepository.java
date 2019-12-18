package springframework.guru.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.guru.spring5webapp.model.Author;

/**
 * @author kas
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
