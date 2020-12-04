package december4puzzle1;

import java.util.ArrayList;

public class Passport {

	private int birthYear = -1;
	private int issueYear = -1;
	private int expirationYear = -1;
	private String height = "";
	private String hairColor = "";
	private String eyeColor = "";
	private String passportID = "";
	private String countryID = "";

	public Passport(ArrayList<String> passportData) {
		for (String s : passportData) {
			String[] splitData = s.split(":");
			switch (splitData[0]) {
			case "byr":
				birthYear = Integer.parseInt(splitData[1]);
				break;
			case "iyr":
				issueYear = Integer.parseInt(splitData[1]);
				break;
			case "eyr":
				expirationYear = Integer.parseInt(splitData[1]);
				break;
			case "hgt":
				height = splitData[1];
				break;
			case "hcl":
				hairColor = splitData[1];
				break;
			case "ecl":
				eyeColor = splitData[1];
				break;
			case "pid":
				passportID = splitData[1];
				break;
			case "cid":
				countryID = splitData[1];
				break;
			}
		}
	}

	private boolean hasAllRequiredFields() {
		boolean output = true;
		output &= birthYear != -1;
		output &= issueYear != -1;
		output &= expirationYear != -1;
		output &= height != "";
		output &= hairColor != "";
		output &= eyeColor != "";
		output &= passportID != "";
		return output;
	}

	public boolean isValid() {
		boolean total = true;
		total &= hasAllRequiredFields();
		total &= isValidBirthYear();
		total &= isValidIssueYear();
		total &= isValidExpirationYear();
		total &= isValidHeight();
		total &= isValidHairColor();
		total &= isValidEyeColor();
		total &= isValidPassportID();
		return total;
	}

	private boolean isValidBirthYear() {
		if (birthYear < 1920 || birthYear > 2002) {
			return false;
		}
		return true;
	}

	private boolean isValidExpirationYear() {
		try {
			if (Integer.toString(expirationYear).length() != 4 || expirationYear < 2020 || expirationYear > 2030) {
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private boolean isValidEyeColor() {
		switch (eyeColor) {
		case "amb":
		case "blu":
		case "brn":
		case "gry":
		case "grn":
		case "hzl":
		case "oth":
			return true;
		default:
			return false;
		}
	}

	private boolean isValidHairColor() {
		if (hairColor.matches("#[a-f0-9]{6}")) {
			return true;
		}
		return false;
	}

	private boolean isValidHeight() {
		if (height.matches("[0-9]+(in|cm)")) {
			String unit = height.substring(height.length() - 1 - 1, height.length());

			int heightWithoutUnit = Integer.parseInt(height.substring(0, height.length() - 1 - 1));
			switch (unit) {
			case "cm":
				return heightWithoutUnit >= 150 && heightWithoutUnit <= 193;
			case "in":
				return heightWithoutUnit >= 59 && heightWithoutUnit <= 76;
			}
		}
		return false;
	}

	private boolean isValidIssueYear() {
		if (issueYear < 2010 || issueYear > 2020) {
			return false;
		}
		return true;
	}

	private boolean isValidPassportID() {
		if (passportID.matches("[0-9]{9}")) {
			return true;
		}
		return false;
	}

	@Override // for debug
	public String toString() {
		String output = "";
		output += birthYear + " | ";
		output += issueYear + " | ";
		output += expirationYear + " | ";
		output += height + " | ";
		output += hairColor + " | ";
		output += eyeColor + " | ";
		output += passportID + " | ";
		output += countryID;
		return output;
	}
}
