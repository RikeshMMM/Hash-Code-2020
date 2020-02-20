
public class Book {
	public int id;
	public int score;
	public boolean isScanned = false;
	public int idLibrary = -1;

	public Book(int id, int score, boolean isScanned, int idLibrary) {
		this.id = id;
		this.score = score;
		this.isScanned = isScanned;
		this.idLibrary = idLibrary;
	}
}
