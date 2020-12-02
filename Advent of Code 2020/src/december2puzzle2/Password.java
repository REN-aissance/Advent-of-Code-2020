package december2puzzle2;

public class Password {

	private char[] password;
	private char requiredChar;
	private int positionOne;
	private int positionTwo;

	Password(String s) {
		String[] params = s.split(" ");
		String[] range = params[0].split("-");
		positionOne = Integer.parseInt(range[0]) - 1;
		positionTwo = Integer.parseInt(range[1]) - 1;
		requiredChar = params[1].substring(0, 1).charAt(0);
		password = params[2].toCharArray();
	}
	
	public boolean isValid() {
		return password[positionOne] == requiredChar ^ password[positionTwo] == requiredChar;
	}
}
