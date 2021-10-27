package es.upm.grise.profundizacion.control_1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class LibraryTest {
	
	private Library library;
	
	private Book book;
	
	@Before
	public void configure() {
		library = new Library();
		book = new Book("Legends");
	}
	
	@Test
	public void testAddBookOne() throws DuplicatedBookException {	
		library.addBook(book);
		assertTrue(true);
	}
	
	@Test(expected = DuplicatedBookException.class)
	public void testAddBookRepeated() throws DuplicatedBookException {
		library.addBook(book);
		library.addBook(book);
	}
	
	@Test
	public void testRemoveBook() throws DuplicatedBookException {
		library.addBook(book);
		library.removeBook(book);
		assertTrue(true);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveBookNoExist() {
		library.removeBook(book);
	}
	
	@Test
	public void testGetBook() throws DuplicatedBookException, NonExistingBookException, EmptyLibraryException {
		Book expectedBook = new Book("Legends");
		library.addBook(book);
		Book response = library.getBook("Legends");
		assertEquals(expectedBook.getTitle(), response.getTitle());
	}
	
	@Test(expected = EmptyLibraryException.class)
	public void testGetBookEmty() throws NonExistingBookException, EmptyLibraryException {
		library.getBook("Legends");
	}
	
	@Test(expected = NonExistingBookException.class)
	public void testGetBookNoExist() throws NonExistingBookException, EmptyLibraryException, DuplicatedBookException {
		library.addBook(book);
		library.getBook("The Mayor");
	}

}
