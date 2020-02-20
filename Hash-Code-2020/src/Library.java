public class Library {
	public int id;
	public int[] booksId;
	public int signUpTime;
	public int booksPerDay;
	public int booksInLibrary;


	public Library(int id, int signUpTime, int booksPerDay, int booksInLibrary) {
		this.id = id;
		this.signUpTime = signUpTime;
		this.booksPerDay = booksPerDay;
		this.booksInLibrary = booksInLibrary;
		booksId = new int[booksInLibrary];
	}
}
