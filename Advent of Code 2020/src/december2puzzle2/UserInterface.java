package december2puzzle2;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class UserInterface {

	public static ArrayList<Password> passwords = new ArrayList<Password>();
	
	public static Scanner makeFileScanner() throws IOException {
		return new Scanner(new FileInputStream("december2"));
	}
	
	public static void initializePasswords() throws IOException {
		Scanner fileScanner = makeFileScanner();
		while (fileScanner.hasNextLine()) {
			passwords.add(new Password(fileScanner.nextLine()));
		}
	}
	
	public static void main(String[] args) throws IOException {
		initializePasswords();

		int validPasswords = 0;
		for (Password password : passwords) {
			if (password.isValid()) {
				validPasswords++;
			}
		}
		System.out.println(validPasswords);
	}
}
