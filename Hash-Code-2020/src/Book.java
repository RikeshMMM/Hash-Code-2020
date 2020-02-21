
public class Book  implements Comparable<Book>{
	public int id;
	public Integer score;
	public boolean isScanned = false;
	public int idLibrary = -1;

	public Book(int id, int score, boolean isScanned, int idLibrary) {
		this.id = id;
		this.score = score;
		this.isScanned = isScanned;
		this.idLibrary = idLibrary;
	}

	@Override
	public int compareTo(Book o) {
		return 	this.score.compareTo(o.score);

//		if (this.libraryScore < o.libraryScore) {
//			return 1;
//		} else if (this.libraryScore > o.libraryScore) {
//			return -1;
//		}
//		return 0;
	}
}
