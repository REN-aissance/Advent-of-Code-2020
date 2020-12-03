package december3puzzle2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class UserInterface {

	public static Scanner makeFileScanner() throws IOException {
		return new Scanner(new FileInputStream("december3"));
	}

	public static int testSlopeDebug(int num1, int num2) throws IOException {
		Scanner fileScanner = makeFileScanner();
		int treeCount = 0;
		for (int i = 0; fileScanner.hasNextLine(); i++) {
			char[] currentLine = fileScanner.nextLine().toCharArray();
			int lineLen = currentLine.length;
			int treeIndex = (((i / num2) * num1) % lineLen);
			if (i % num2 == 0) {
				if (currentLine[treeIndex] == '#') {
					currentLine[treeIndex] = 'X';
					treeCount++;
				} else {
					currentLine[treeIndex] = 'O';
				}
			}
			System.out.println(currentLine);
		}
		System.out.println(treeCount);
		System.out.println();
		fileScanner.close();
		return treeCount;
	}

	public static int testSlope(int num1, int num2) throws IOException {
		Scanner fileScanner = makeFileScanner();
		int treeCount = 0;
		for (int i = 0; fileScanner.hasNextLine(); i++) {
			char[] currentLine = fileScanner.nextLine().toCharArray();
			int lineLen = currentLine.length;
			int treeIndex = (((i / num2) * num1) % lineLen);
			if (i % num2 == 0) {
				if (currentLine[treeIndex] == '#') {
					treeCount++;
				}
			}
		}
		fileScanner.close();
		return treeCount;
	}

	public static void main(String[] args) throws IOException {

		int[] trees = new int[5];
		trees[0] = testSlope(1, 1);
		trees[1] = testSlope(3, 1);
		trees[2] = testSlope(5, 1);
		trees[3] = testSlope(7, 1);
		trees[4] = testSlope(1, 2);

		long result = 1;
		for (int i : trees) {
			result *= (long) i;
		}

		System.out.println(result);
	}
}
