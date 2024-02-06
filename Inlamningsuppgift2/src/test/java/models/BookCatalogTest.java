package models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class BookCatalogTest {

	private BookCatalog bc;
	private Book book1;

	public BookCatalogTest() {
		bc = new BookCatalog();
		book1 = new Book(1, "Learning Java", "Author", "ISBN", "Genre", 200);
		bc.addBook(book1);
	}

    // G
	@Test
	public void testAddABook() {
		Book bookToAdd = new Book(2, "Advanced Java", "Author", "ISBN", "Genre", 200);
		bc.addBook(bookToAdd);

		assertTrue(bookIsInCatalog(bookToAdd));
	}

	private boolean bookIsInCatalog(Book book) {
		for (int i = 0; i < bc.getNumberOfBooks(); i++) {
			if (bc.getBookArray()[i].equals(book)) {
				return true;
			}
		}
		return false;
	}

	// G
	@Test
	public void testFindBook() throws BookNotFoundException {
		Book foundBook = bc.findBook("Learning Java");

		assertNotNull(foundBook);
		assertEquals(book1, foundBook);
	}

	// G
	@Test
	public void testFindBookIgnoringCase() throws BookNotFoundException {
		Book foundBook = bc.findBook("learning java");

		assertNotNull(foundBook);
		assertEquals(book1, foundBook);
	}

	// G
	@Test
	public void testFindBookWithExtraSpaces() throws BookNotFoundException {
	Book book = new Book(1, "Learning Java","","","",0);
	bc.addBook(book);
	Book book2 = bc.findBook("learning java");

	assertEquals(book, book2);
	}




    // VG
	@Test
	public void testFindBookThatDoesntExist() {
		assertThrows(BookNotFoundException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				bc.findBook("Nonexistent Book");
			}
		});
	}
}
