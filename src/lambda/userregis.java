package lambda;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class userregis {
	static Scanner sc = new Scanner(System.in);
	// Method to validate first and last name
	private static void firstname(String fname) {
		Pattern pattern = Pattern.compile("^[A-Z][a-z]{2,}$");
		Matcher matcher = pattern.matcher(fname);
		if (matcher.matches() == true) {
			System.out.println("Entered name is valid");
		} else {
			System.out.println("Entered name is not valid");
		}
	}

	// Method to validate email
	private static void email(String mail) {
		Pattern pattern = Pattern.compile(
				"\"^[0-9a-zA-Z]+([._+-][0-9a-zA-Z]+)*@([0-9a-zA-Z][-]?)+[.][a-zA-Z]{2,4}([.][a-zA-Z]{2,4})?$\"");
@@ -28,7 +28,7 @@ private static void email(String mail) {
			System.out.println("Entered email is invalid");
		}
	

	// Method to validate mobile
	private static void mobile(String mobile) {
		Pattern pattern = Pattern.compile("^[1-9][0-9]\s[1-9][0-9]{9}");
		Matcher matcher = pattern.matcher(mobile);
		{
			System.out.println("Entered number is invalid");
		}

	}
	// Method to validate password
	private static void password(String password) {
		Pattern pattern = Pattern.compile("^(?=.*?[0-9a-zA-Z])[0-9a-zA-Z]*[@#$%][0-9a-zA-Z]*$");
		Matcher matcher = pattern.matcher(password);
		if (matcher.matches() == true) {
			System.out.println("Entered password is valid");
		} else {
			System.out.println("Entered password is invalid");
		}

	}

	public static void main(String[] args) {
@@ -61,6 +72,11 @@ public static void main(String[] args) {
		String mobile = sc.next();
		mobile(mobile);

		// Password Input
		System.out.println("Please enter password");
		String password = sc.nextLine();
		password(password);

	}

} 