package december4;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

	/*
	 * Accidentally killed part1's files. Luckily they are very similar. Rename
	 * Passport.hasAllRequiredFields() to isValid() (and delete it) and delete all
	 * private helper methods and the code should output part 1's solution
	 */

	private static Scanner fileScanner;
	private static ArrayList<Passport> passports = new ArrayList<Passport>();

	private static void initializeFileScanner(String filename) {
		try {
			fileScanner = new Scanner(new FileInputStream(filename));
		} catch (IOException e) {
			System.out.println("There was an error opening your file");
		}
	}

	private static void initializePassports() {
		initializeFileScanner("december4");
		ArrayList<String> passportData = new ArrayList<String>();
		writePassportsToArrayList(passportData);
	}

	private static void writePassportsToArrayList(ArrayList<String> passportData) {
		while (fileScanner.hasNextLine()) {
			String nextLine = fileScanner.nextLine();
			if (!nextLine.isEmpty()) {
				String[] splitElements = nextLine.split(" ");
				for (String s : splitElements) {
					passportData.add(s);
				}
			} else {
				passports.add(new Passport(passportData));
				passportData.clear();
			}
		}
		passports.add(new Passport(passportData)); // nextline is empty, but there is still a passport left behind
		fileScanner.close();
	}

	public static void main(String[] args) {
		initializePassports();
		int validPassports = 0;
		for (Passport passport : passports) {
			if (passport.isValid()) {
				validPassports++;
			} else {
			}
		}
		System.out.println(validPassports);
	}
}
