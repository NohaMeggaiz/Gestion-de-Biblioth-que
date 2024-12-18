package com.library;

import com.library.dao.BookDAO;
import com.library.model.Book;
import com.library.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



public class BookServiceTest {

        private BookService bookService;
        private BookDAO bookDAO;

        @BeforeEach
        public void setUp() {
            bookDAO = new BookDAO(); // Assurez-vous d'avoir une instance correcte de DAO
            bookService = new BookService(bookDAO);
        }

        @Test
        public void testAddBook() {
            Book book = new Book(3, "1984", "George Orwell", "123456789", "Secker & Warburg", 1949);
            bookService.addBook(book);
            Book fetchedBook = bookService.getBookById(1);
            assertNotNull(fetchedBook);
            assertEquals("1984", fetchedBook.getTitle());
        }

        @Test
        public void testGetAllBooks() {
            Book book1 = new Book(4, "To Kill a Mockingbird", "Harper Lee", "987654321", "J.B. Lippincott & Co.", 1960);
            Book book2 = new Book(5, "Brave New World", "Aldous Huxley", "123987456", "HarperCollins", 1932);
            bookService.addBook(book1);
            bookService.addBook(book2);

            bookService.displayBooks(); // Verifier que les livres sont bien affichés
        }
}
