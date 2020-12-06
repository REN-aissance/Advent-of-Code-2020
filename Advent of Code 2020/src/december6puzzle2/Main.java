package december6puzzle2;

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
		boolean firstLine = true;
		while ((fileScanner.hasNextLine())) {
			String nextLine = fileScanner.nextLine();
			ArrayList<Character> nextChars = new ArrayList<Character>();
			ArrayList<Character> charsToRemove = new ArrayList<Character>();
			for (char c : nextLine.toCharArray()) {
				nextChars.add(c);
			}
			if (firstLine) {
				for (char c : nextChars) {
					chars.add(c);
				}
				firstLine = false;
			} else if (nextLine.isEmpty()) {
				total += chars.size();
				chars.clear();
				firstLine = true;
			} else {
				for (char c : chars) {
					if (!nextChars.contains(c)) {
						charsToRemove.add(c);
					}
				}
				for (char c : charsToRemove) {
					chars.remove(chars.indexOf(c));
				}
			}
		}
		total += chars.size(); //don't forget
		fileScanner.close();
		System.out.println(total);

	}
}
