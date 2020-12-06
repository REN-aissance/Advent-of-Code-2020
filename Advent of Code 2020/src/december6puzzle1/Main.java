package december6puzzle1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static ArrayList<Character> chars = new ArrayList<Character>();
	private static final String FILENAME = "december6";
	private static Scanner fileScanner = null;

	private static void initializeFileScanner(String filename) {
		try {
			fileScanner = new Scanner(new FileInputStream(filename));
		} catch (IOException e) {
			System.out.println("IOException");
		}
	}
	
	private static int getLines(String filename) {
		initializeFileScanner(FILENAME);
		int i = 0;
		while (fileScanner.hasNextLine() == true) {
			fileScanner.nextLine();
			i++;
		}
		fileScanner.close();
		return i + 1;
	}

	public static void main(String[] args) {
		int total = 0;
		int lines = getLines(FILENAME);
		initializeFileScanner(FILENAME);
		do {
			String nextLine = fileScanner.nextLine();
			if (nextLine.isEmpty()) {
				total += chars.size();
				System.out.println(chars.size());
				chars.clear();
			} else {
				char[] questions = nextLine.toCharArray();
				System.out.println(nextLine);
				for (char c : questions) {
					if (!chars.contains(c)) {
						chars.add(c);
					}
				}
			}
		} while ((fileScanner.hasNextLine()));
		total += chars.size(); //last line
		fileScanner.close();
		System.out.println(total);
		
	}
}
