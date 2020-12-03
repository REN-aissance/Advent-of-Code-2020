package december3puzzle1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class UserInterface {

	public static Scanner makeFileScanner() throws IOException {
		return new Scanner(new FileInputStream("december3"));
	}

	public static void main(String[] args) throws IOException {
		
		Scanner fileScanner = makeFileScanner();
		int treeCount = 0;

		// discard first row and get length
		int len = fileScanner.nextLine().length();

		for (int i = 3; fileScanner.hasNextLine(); i = (i + 3) % len) {
			char[] nextLine = fileScanner.nextLine().toCharArray();
			if (nextLine[i] == '#') {
				treeCount++;
			}
		}
		System.out.println(treeCount);
	}
}
