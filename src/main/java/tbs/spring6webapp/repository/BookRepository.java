package tbs.spring6webapp.repository;

import org.springframework.data.repository.CrudRepository;
import tbs.spring6webapp.domain.Book;

public interface BookRepository extends CrudRepository<Book,Long> {
}
