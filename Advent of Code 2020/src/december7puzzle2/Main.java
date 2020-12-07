package december7puzzle2;

import java.io.FileInputStream;
import java.util.regex.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static ArrayList<Bag> bags = new ArrayList<Bag>();
	
	private static final String FILENAME = "december7";
	private static Scanner fileScanner = null;

	private static void initializeFileScanner(String filename) {
		try {
			fileScanner = new Scanner(new FileInputStream(filename));
		} catch (IOException e) {
			System.out.println("IOException");
		}
	}
	
	private static int rCount(Bag b) {
		int total = 0;
		total += b.getCount();
		for (Pair p : b.children) {
			for (Bag b2 : bags) {
				if (b2.name.contains(p.name)) {
					total += (p.count * rCount(b2));
				}
			}
		}
		return total;
	}
	
	public static void main(String[] args) {
		initializeFileScanner(FILENAME);
		while (fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();
			Pattern pattern = Pattern.compile("^([A-Za-z0-9]+ ){2}");
			Matcher matcher = pattern.matcher(line);
			Bag b = new Bag();
			if (matcher.find()) {
				b.name = matcher.group();
				line = line.replaceAll("^([A-Za-z0-9]+ ){4}", "");
				Pattern pattern2 = Pattern.compile("[0-9] ([A-Za-z]+ ){2}");
				Matcher matcher2 = pattern2.matcher(line);
				while (matcher2.find()) {
					int i = Integer.parseInt(matcher2.group().substring(0, 1));
					String s = matcher2.group().substring(2);
					Pair p = new Pair(s, i);
					b.children.add(p);
				}
			}
			bags.add(b);
		}
		fileScanner.close();
		int total = 0;
		for (Bag b : bags) {
			System.out.println(b.name);
			if (b.name.contains("shiny gold")) {
				total += rCount(b);
			}
		}
		System.out.println(total);
	}
}
