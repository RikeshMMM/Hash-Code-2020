import java.util.ArrayList;
import java.util.Collections;

public class Library implements Comparable<Library>{
	public int id;
	public int[] booksId;
	public ArrayList<Book> books = new ArrayList<Book>();

	public int signUpTime;
	public int booksPerDay;
	public int booksInLibrary;

	public Integer libraryScore = 0;

	public Library(int id, int signUpTime, int booksPerDay, int booksInLibrary) {
		this.id = id;
		this.signUpTime = signUpTime;
		this.booksPerDay = booksPerDay;
		this.booksInLibrary = booksInLibrary;
		booksId = new int[booksInLibrary];
	}

	public void addBookstoList() {
		for (int i = 0; i < booksId.length; i++) {
			for (Book book : Main.books) {
				if (book.id == booksId[i]) {
					books.add(book);
				}
			}
		}
		Collections.sort(books);
		Collections.reverse(books);
	}

	@Override
	public int compareTo(Library o) {
	return 	this.libraryScore.compareTo(o.libraryScore);

//		if (this.libraryScore < o.libraryScore) {
//			return 1;
//		} else if (this.libraryScore > o.libraryScore) {
//			return -1;
//		}
//		return 0;
	}
}
