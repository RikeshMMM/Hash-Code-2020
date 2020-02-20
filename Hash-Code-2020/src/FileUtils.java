import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {

    static String fileName = "input.txt";
    static String separator = "";

    public static void readFile() {

        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {

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
}
