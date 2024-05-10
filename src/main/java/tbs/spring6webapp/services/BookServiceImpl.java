package tbs.spring6webapp.services;

import org.springframework.stereotype.Service;
import tbs.spring6webapp.domain.Book;
import tbs.spring6webapp.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
