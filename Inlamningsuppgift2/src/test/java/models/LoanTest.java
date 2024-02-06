package models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import utilities.GenderType;

public class LoanTest {

	// VG
	@Test
	public void testDueDate() {
		LocalDate startDate = LocalDate.now();


		Book book = new Book(1, "Sample Title", "Sample Author", "Sample Genre", "Sample ISBN", 200);

		Customer customer = new Customer("Mr", "John", "Doe", "123 Main St", "123456789", "john.doe@example.com", 123, GenderType.MALE);

		Loan loan = new Loan(1, customer, book);

		LocalDate expectedDueDate = startDate.plusDays(14);

		assertEquals(expectedDueDate, loan.getDueDate());
	}
}
