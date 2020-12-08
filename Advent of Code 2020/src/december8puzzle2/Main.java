package december8puzzle2;

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
			Instruction cur = new Instruction("err", -1);
			try {
				cur = instructions.get(p);
			} catch (Exception e) {
				break;
			}
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
		path.clear();
		return acc;
	}
	
	public static int testFlips() {
		for (int i = 0; i < instructions.size(); i++) {
			Instruction cur = instructions.get(i);
			int val = Integer.MAX_VALUE;
			if (cur.instruction.contains("nop")) {
				cur.instruction = "jmp";
				val = execute();
				cur.instruction = "nop";
			}
			else if (cur.instruction.contains("jmp")) {
				cur.instruction = "nop";
				val = execute();
				cur.instruction = "jmp";
			}
			if (p == instructions.size()) {
				return val;
			} else {
				p = 0;
				acc = 0;
			}
		}
		return -1;
	}
	

	public static void main(String[] args) {
		initializeFileScanner(FILENAME);
		initializeInstructions();
		fileScanner.close();
		System.out.println(testFlips());
	}
}
