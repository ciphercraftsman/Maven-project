package models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BookTest {
    // G
	@Test
	public void test2EqualBooks() {
		Book book1 = new Book(1, "Title", "Author", "Genre", "Publisher", 2022);
		Book book2 = new Book(1, "Title", "Author", "Genre", "Publisher", 2022);

		assertEquals(book1, book2);
	}

    // G
	@Test
	public void test2NonEqualBooks() {
		Book book1 = new Book(1, "Java Programming", "John Doe", "1234567890", "Programming", 2022);
		Book book2 = new Book(2, "Python Basics", "Jane Smith", "0987654321", "Programming", 2021);

		assertNotEquals(book1, book2);
	}
}
