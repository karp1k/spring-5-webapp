package springframework.guru.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.guru.spring5webapp.model.Publisher;

/**
 * @author kas
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
