package lambda;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern
public class userregis {
	static Scanner sc = new Scanner(System.in);

	public static void firstname(String fname) {
		Pattern pattern = Pattern.compile("^[A-Z][a-z]{2,}$");
		Matcher matcher = pattern.matcher(fname);
		if (matcher.matches() == true) {
			System.out.println("Entered name is valid");
		} else {
			System.out.println("Entered name is not valid");
		}
	}

	public static void main(String[] args) {
		// First Name input
		System.out.println("Please enter first name");
		String fname = sc.next();
		firstname(fname);

	}
} 

