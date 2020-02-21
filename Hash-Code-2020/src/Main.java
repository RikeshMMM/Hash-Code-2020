//import org.apache.xpath.operations.Bool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Main {

	public static int totalBooks;
	public static int totalLibraries;
	public static int maxScanningDays;

	public static ArrayList<Book> books = new ArrayList<Book>();
	public static ArrayList<Library> libraries = new ArrayList<Library>();

	public static void main(String[] args) {

		FileUtils.readFile();

		//update library scores
		for (Library library : libraries) {
			library.libraryScore = Utils.libraryScore(library);
		}


		/*
		//order libraries by library score
		int[] libScores = new int[totalLibraries];
		int[] libIds = new int[totalLibraries];
		int currentMaxScore = 0;
		for (int i = 0; i < libraries.size(); i++) {
			Library library = libraries.get(i);
			library.libraryScore = Utils.libraryScore(library);
			if (library.libraryScore > currentMaxScore) {
				currentMaxScore = library.libraryScore;
			}
			libScores[i] = library.libraryScore;
			libIds[i] = library.id;

		}*/
		int copyMaxScanningDays = maxScanningDays;

		Collections.sort(libraries);
		Collections.reverse(libraries);
		ArrayList<Library> librariesToPrint = new ArrayList<Library>();
		for (Library library : libraries) {
			if (maxScanningDays == 0) {
				break;
			}
			maxScanningDays -= library.signUpTime;
			librariesToPrint.add(library);
		}

		maxScanningDays = copyMaxScanningDays;

		//print
		ArrayList<String> lines = new ArrayList<>();
		lines.add(Integer.toString(librariesToPrint.size()));
		for (Library libraryToPrint : librariesToPrint) {
			String line = Integer.toString(libraryToPrint.id) + " ";
			copyMaxScanningDays -= libraryToPrint.signUpTime;
			Iterator bit = libraryToPrint.books.iterator();
			if (copyMaxScanningDays > 0 && bit.hasNext()) {
				int remainingdays = copyMaxScanningDays;
				int booksToBePrinted = libraryToPrint.booksPerDay * remainingdays;
				if (booksToBePrinted > libraryToPrint.books.size() || booksToBePrinted < 0) {
					booksToBePrinted = libraryToPrint.books.size();
				}
				line = line + Integer.toString(booksToBePrinted);
				lines.add(line);

				String line2 = Integer.toString(((Book) bit.next()).id);
				for (int j = 0; j < booksToBePrinted -1; j++) {
					line2 = line2 + " " + Integer.toString(((Book) bit.next()).id);
				}
				lines.add(line2);
			}
		}

		FileUtils.writeFile(lines);



		/*for (Library library : libraries) {
			if (library.libraryScore == currentMaxScore) {
				librariesToPrint.add(library);
				for (int i = 0; i < libScores.length; i++) {
					if (libScores[i] == currentMaxScore) {
						libScores[i] = -1;
						libScores[i] = -1;
					}
				}
				currentMaxScore = 0;
				for (int i = 0; i < libScores.length; i++) {
					if (libScores[i] > currentMaxScore) {
						currentMaxScore = libScores[i];
					}
				}
			}
		}*/


		System.out.println("ended");


	}
}
