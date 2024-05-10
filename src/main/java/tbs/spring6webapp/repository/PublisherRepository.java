package tbs.spring6webapp.repository;

import org.springframework.data.repository.CrudRepository;
import tbs.spring6webapp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
