package tbs.spring6webapp.repository;

import org.springframework.data.repository.CrudRepository;
import tbs.spring6webapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
