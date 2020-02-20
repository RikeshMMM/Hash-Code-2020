import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileUtils {

    static String inputFileName = "input.txt";
    static String separator = "\\s";

    static String outputFileName = "output.txt";


    public static void readFile() {

        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(inputFileName))) {
            String line;
            line = br.readLine();
            String[] firstLine = line.split(separator);

            Main.totalBooks = Integer.parseInt(firstLine[0]);
            Main.totalLibraries = Integer.parseInt(firstLine[1]);
            Main.maxScanningDays = Integer.parseInt(firstLine[2]);


            line = br.readLine();
            String[] booksScores = line.split(separator);
            for (int i = 0; i < booksScores.length; i++) {
                Main.books.add(new Book(i, Integer.parseInt(booksScores[i]), false, -1));
            }

            for (int i = 0; i < Main.totalLibraries; i++) {
                line = br.readLine();
                String[] libInput = line.split(separator);

                Main.libraries.add(new Library(i, Integer.parseInt(libInput[1]), Integer.parseInt(libInput[2]), Integer.parseInt(libInput[0])));

                line = br.readLine();
                String[] booksInLib = line.split(separator);
                for (int i1 = 0; i1 < booksInLib.length; i1++) {
                    Main.libraries.get(i).booksId[i1] = Integer.parseInt(booksInLib[i1]);
                }
                Main.libraries.get(Main.libraries.size()-1).addBookstoList();


            }
//            while ((line = br.readLine()) != null) {
//
//                stringBuilder.append(line).append("\n");
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(stringBuilder.toString());
    }

    public static void writeFile(ArrayList<String> lines) {
        try {
            Files.write(Paths.get(outputFileName), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
