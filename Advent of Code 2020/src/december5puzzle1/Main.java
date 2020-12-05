package december5puzzle1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static final String FILENAME = "december5";
	private static int lines;
	private static Scanner fileScanner = null;
	private static ArrayList<Integer> seatIDs = new ArrayList<Integer>();

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
		return i;
	}

	private static char[] prepNextCharArray(char[] c) {
		char[] newChars = new char[c.length - 1];
		for (int i = 1; i < c.length; i++) {
			newChars[i - 1] = c[i];
		}
		return newChars;
	}

	private static int getRow(char[] chars, int lowerLimit, int upperLimit) {
		char c = chars[0];
		char[] newChars = prepNextCharArray(chars);
		if (c == 'F') {
			if (upperLimit - lowerLimit == 1) {
				return lowerLimit;
			} else {
				return getRow(newChars, lowerLimit, (upperLimit + lowerLimit) / 2);
			}
		} else {
			if (upperLimit - lowerLimit == 1) {
				return upperLimit;
			} else {
				return getRow(newChars, ((lowerLimit + upperLimit) / 2) + 1, upperLimit);
			}
		}
	}

	private static int getColumn(char[] chars, int lowerLimit, int upperLimit) {
		char c = chars[0];
		char[] newChars = prepNextCharArray(chars);
		if (c == 'L') {
			if (upperLimit - lowerLimit == 1) {
				return lowerLimit;
			} else {
				return getColumn(newChars, lowerLimit, (upperLimit + lowerLimit) / 2);
			}
		} else {
			if (upperLimit - lowerLimit == 1) {
				return upperLimit;
			} else {
				return getColumn(newChars, ((lowerLimit + upperLimit) / 2) + 1, upperLimit);
			}
		}
	}

	private static int getSeatID(String s) {
		int row = getRow(s.substring(0, 7).toCharArray(), 0, 127);
		int col = getColumn(s.substring(7, s.length()).toCharArray(), 0, 7);
		return (row * 8) + col;
	}

	public static void main(String[] args) {
		lines = getLines(FILENAME);
		initializeFileScanner(FILENAME);
		for (int i = 0; i < lines; i++) {
			seatIDs.add(getSeatID(fileScanner.nextLine()));
		}
		fileScanner.close();
		seatIDs.sort(null);
		System.out.println(seatIDs.get(seatIDs.size() - 1));
	}
}
