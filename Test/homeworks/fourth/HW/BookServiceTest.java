package homeworks.fourth.HW;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class BookServiceTest {

    BookService bookService;
    BookRepository bookRepository;
    Book mockBook;
    List<Book> books;
    String id, author, title;

    Book realBook;

    @BeforeEach
    void setUp() {
        bookRepository = mock(MemoryBookRepository.class);
        mockBook = mock(Book.class);
        bookService = new BookService(bookRepository);
        books = new ArrayList<>();
        books.add(mockBook);
        id = "1";
        author = "Robert Greene";
        title = "The 48 Laws Of Power";

        realBook = new Book("2", "The House of Morgan: An American Banking Dynasty and the Rise of Modern Finance", "Ron Chernow");
    }

    @Test
    void findBookByIdTest() {
        when(bookRepository.findById(id)).thenReturn(mockBook);

        Book fineBook = bookService.findBookById(id);

        verify(bookRepository, times(1)).findById(id);
        assertThat(fineBook).isEqualTo(mockBook);
    }

    @Test
    void findAllBooksTestListBooks() {
        when(bookRepository.findAll()).thenReturn(books);

        List<Book> foundBooks = bookService.findAllBooks();

        verify(bookRepository, times(1)).findAll();
        assertThat(foundBooks).isEqualTo(books);
    }

    @Test
    void findAllBooksTestBook() {
        when(bookRepository.findAll()).thenReturn(books);

        List<Book> foundBooks = bookService.findAllBooks();

        verify(bookRepository, times(1)).findAll();
        assertThat(foundBooks.get(0)).isEqualTo(mockBook);
    }

    @Test
    void findAllBooksTestListLength() {
        books.add(mock(Book.class));
        books.add(mock(Book.class));
        when(bookRepository.findAll()).thenReturn(books);

        List<Book> foundBooks = bookService.findAllBooks();

        verify(bookRepository, times(1)).findAll();
        assertThat(foundBooks.size()).isEqualTo(3);
    }

    /**---------------------------------------------------------------------*/

    @Test
    void bookTestGetAuthor() {
        String foundAuthor = realBook.getAuthor();

        assertThat(foundAuthor).isEqualTo("Ron Chernow");
    }

    @Test
    void bookTestGetTitle() {
        String foundTitle = realBook.getTitle();

        assertThat(foundTitle).isEqualTo("The House of Morgan: An American Banking Dynasty and the Rise of Modern Finance");
    }

    @Test
    void bookTestGetId() {
        String foundId = realBook.getId();

        assertThat(foundId).isEqualTo("2");
    }

    @Test
    void bookTestSetId() {
        realBook.setId("3");

        assertThat(realBook.getId()).isEqualTo("3");
    }

    @Test
    void bookTestSetAuthor() {
        realBook.setAuthor("Andrew Ross Sorkin");

        assertThat(realBook.getAuthor()).isEqualTo("Andrew Ross Sorkin");
    }

    @Test
    void bookTestSetTitle() {
        realBook.setTitle("Too Big to Fail");

        assertThat(realBook.getTitle()).isEqualTo("Too Big to Fail");
    }
}
