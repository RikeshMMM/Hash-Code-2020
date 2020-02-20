import java.util.ArrayList;

public class Main {

	public static int totalBooks;
	public static int totalLibraries;
	public static int maxScanningDays;

	public static ArrayList<Book> books = new ArrayList<Book>();
	public static ArrayList<Library> libraries = new ArrayList<Library>();

	public static void main(String[] args) {

		FileUtils.readFile();

		System.out.println("ended");

//		ArrayList<String> lines = new ArrayList<>();
//		lines.add("hellooo");
//		FileUtils.writeFile(lines);
	}
}
