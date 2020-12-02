package december2puzzle1;

public class Password {

	private char[] password;
	private char requiredChar;
	private int rangeStart;
	private int rangeEnd;

	Password(String s) {
		String[] params = s.split(" ");
		String[] range = params[0].split("-");
		rangeStart = Integer.parseInt(range[0]);
		rangeEnd = Integer.parseInt(range[1]);
		requiredChar = params[1].substring(0, 1).charAt(0);
		password = params[2].toCharArray();
	}
	
	public boolean isValid() {
		int count = 0;
		for (char c : password) {
			if (c == requiredChar) {
				count++;
			}
		}
		if (count >= rangeStart && count <= rangeEnd) {
			return true;
		} else {
			return false;
		}
	}
}
