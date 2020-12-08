package december8puzzle1;

import java.io.FileInputStream;
import java.util.regex.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	private static final String FILENAME = "december8";
	private static Scanner fileScanner = null;
	
	private static ArrayList<Instruction> instructions = new ArrayList<Instruction>();
	private static int p = 0;
	private static int acc = 0;
	private static ArrayList<Integer> path = new ArrayList<Integer>();

	private static void initializeFileScanner(String filename) {
		try {
			fileScanner = new Scanner(new FileInputStream(filename));
		} catch (IOException e) {
			System.out.println("IOException");
		}
	}
	
	private static void initializeInstructions() {
		while (fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();
			String[] splitLine = line.split(" ");
			Instruction ins = new Instruction(splitLine[0], Integer.parseInt(splitLine[1]));
			instructions.add(ins);
		}
	}
	
	public static int execute() {
		while (!path.contains(p)) {
			path.add(p);
			Instruction cur = instructions.get(p);
			switch (cur.instruction) {
			case "acc":
				acc += cur.arg;
				p++;
				break;
			case "jmp":
				p += cur.arg;
				break;
			default:
				p++;
				break;
			}
		}
		return acc;
	}
	
	

	public static void main(String[] args) {
		initializeFileScanner(FILENAME);
		initializeInstructions();
		fileScanner.close();
		System.out.println(execute());
	}
}
