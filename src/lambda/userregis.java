package lambda;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern
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
	

	private static void email(String mail) {
		Pattern pattern = Pattern.compile("\"^[0-9a-zA-Z]+([._+-][0-9a-zA-Z]+)*@([0-9a-zA-Z][-]?)+[.][a-zA-Z]{2,4}([.][a-zA-Z]{2,4})?$\"");
		Pattern pattern = Pattern.compile(
				"\"^[0-9a-zA-Z]+([._+-][0-9a-zA-Z]+)*@([0-9a-zA-Z][-]?)+[.][a-zA-Z]{2,4}([.][a-zA-Z]{2,4})?$\"");
		Matcher matcher = pattern.matcher(mail);
		if (matcher.matches() == true) {
			System.out.println("Entered email is valid");
		} else {
			System.out.println("Entered email is invalid");
		}
	}



	private static void mobile(String mobile) {
		Pattern pattern = Pattern.compile("^[1-9][0-9]\s[1-9][0-9]{9}");
		Matcher matcher = pattern.matcher(mobile);
		if (matcher.matches() == true) {
			System.out.println("Entered number is valid");
		} else {
			System.out.println("Entered number is invalid");
		}

	}

	public static void main(String[] args) {
		// First Name input
@@ -40,13 +50,17 @@ public static void main(String[] args) {
		System.out.println("Please enter first name");
		String lname = sc.next();
		firstname(lname);
		
		//Email input

		// Email input
		System.out.println("Please enter email");
		String mail = sc.next();
		email(mail);

		// Mobile Number Input
		System.out.println("Please enter mobile number");
		String mobile = sc.next();
		mobile(mobile);

	}


} 
