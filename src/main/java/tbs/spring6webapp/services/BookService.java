package tbs.spring6webapp.services;

import tbs.spring6webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
