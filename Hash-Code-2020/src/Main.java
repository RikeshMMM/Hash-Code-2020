import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		System.out.println("hello");

		FileUtils.readFile();

		ArrayList<String> lines = new ArrayList<>();
		lines.add("hellooo");
		FileUtils.writeFile(lines);
	}
}
