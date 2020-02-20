import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileUtils {

    static String inputFileName = "a_example.txt";
    static String separator = "";

    static String outputFileName = "output.txt";


    public static void readFile() {

        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(inputFileName))) {

            // read line by line
            String line;
            while ((line = br.readLine()) != null) {

                stringBuilder.append(line).append("\n");
            }
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
