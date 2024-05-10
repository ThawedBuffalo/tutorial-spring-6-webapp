package tbs.spring6webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tbs.spring6webapp.domain.Author;
import tbs.spring6webapp.domain.Book;
import tbs.spring6webapp.domain.Publisher;
import tbs.spring6webapp.repository.AuthorRepository;
import tbs.spring6webapp.repository.BookRepository;
import tbs.spring6webapp.repository.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setIsbn("987654321");
        noEJB.setTitle("J2EE Dev without EJBs");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        Publisher publisher = new Publisher();
        publisher.setPublisherName("Random House");
        publisher.setAddress("255 Main Street");
        Publisher savedpublisher = publisherRepository.save(publisher);

        dddSaved.setPublisher(savedpublisher);
        noEJBSaved.setPublisher(savedpublisher);


        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);

        System.out.println("In BootstrapData");
        System.out.println("Author count:" + authorRepository.count());
        System.out.println("Book count:" + bookRepository.count());
        System.out.println("Publisher count:" + publisherRepository.count());

    }
}
