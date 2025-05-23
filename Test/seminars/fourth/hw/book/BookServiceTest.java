package seminars.fourth.hw.book;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import seminars.fourth.book.Book;
import seminars.fourth.book.BookRepository;
import seminars.fourth.book.BookService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookServiceTest {

    private static BookService bookService;

    private static Book book1;
    private static Book book2;
    private static List<Book> bookList;

    private static BookRepository mockBookRepository;

    @BeforeAll
    public static void init() {

        mockBookRepository = mock(BookRepository.class);
        bookService = new BookService(mockBookRepository);
        book1 = new Book("1", "Book1", "Author1");
        book2 = new Book("2", "Book2", "Author2");
        bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);

    }

    @Test
    public void findBookById() {

        when(mockBookRepository.findById("1")).thenReturn(book1);
        when(mockBookRepository.findById("2")).thenReturn(book2);
        assertThat(bookService.findBookById("1")).isEqualTo(book1);
        assertThat(bookService.findBookById("2")).isEqualTo(book2);

    }

    @Test
    public void findAllBooks() {

        when(mockBookRepository.findAll()).thenReturn(bookList);
        assertThat(bookService.findAllBooks()).isEqualTo(bookList);

    }

}