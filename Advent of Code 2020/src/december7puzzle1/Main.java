package december7puzzle1;

import java.io.FileInputStream;
import java.util.regex.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static ArrayList<String[]> keyvals = new ArrayList<String[]>();
	private static ArrayList<String> alreadyChecked = new ArrayList<String>();
	
	private static final String FILENAME = "december7";
	private static Scanner fileScanner = null;

	private static void initializeFileScanner(String filename) {
		try {
			fileScanner = new Scanner(new FileInputStream(filename));
		} catch (IOException e) {
			System.out.println("IOException");
		}
	}
	
	private static int recursiveFind(String s) {
		int count = 0;
		for (String[] kv : keyvals) {
			if (kv[1].contains(s) && !alreadyChecked.contains(kv[0])) {
				System.out.println("Found a match for: " + s + " in: " + kv[0]);
				alreadyChecked.add(kv[0]);
				count++;
				count += recursiveFind(kv[0]);
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		initializeFileScanner(FILENAME);
		while (fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();
			String[] kv = new String[2];
			Pattern pattern = Pattern.compile("^([A-Za-z0-9]+ ){2}");
			Matcher matcher = pattern.matcher(line);
			if (matcher.find()) {
				kv[0] = matcher.group();
				line = line.replaceAll("^([A-Za-z0-9]+ ){4}", "");
				kv[1] = line;
				keyvals.add(kv);
			}
		}
		fileScanner.close();
		System.out.println(recursiveFind("shiny gold"));
	}
}
