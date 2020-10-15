package lambda;
import java.util.Scanner;
import org.junit.Assert;
import org.junit.Test;
import com.bridgelabz.user.myException.ExceptionType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class myException extends Exception {
	private static final long serialVersionUID = 1L;

	enum ExceptionType { // enum code to diffrenciate error types
		FirstNameInvalid, LastNameInvalid, EmailInvalid, INVALID_mobileNo, PasswordInvalid;
	}

	ExceptionType type_of_exception;

	public myException(String message, ExceptionType type_of_exception) {
		super(message);
		this.type_of_exception = type_of_exception;
	}
}

public class userregis {
	static Scanner sc = new Scanner(System.in);

	// Method to validate first and last name
	
	private static boolean validateFirstName(String fname) throws myException {
		Pattern pattern = Pattern.compile("^[A-Z][a-z]{2,}$");
		Matcher matcher = pattern.matcher(fname);
		if (matcher.matches() == true) {
		if (matcher.matches()) {
			System.out.println("Entered name is valid");
		} else {
			System.out.println("Entered name is not valid");
			
		
	}

	// Method to validate email
	
	public static boolean validateEmail(String mail) throws myException {
		Pattern pattern = Pattern.compile(
				"\"^[0-9a-zA-Z]+([._+-][0-9a-zA-Z]+)*@([0-9a-zA-Z][-]?)+[.][a-zA-Z]{2,4}([.][a-zA-Z]{2,4})?$\"");
		Matcher matcher = pattern.matcher(mail);
		if (matcher.matches() == true) {
		if (matcher.matches()) {
			System.out.println("Entered email is valid");
		} else {
			System.out.println("Entered email is invalid");
			throw new myException("Entered Email is Invalid Exception", ExceptionType.EmailInvalid);
		}
		return pattern.matcher(mail).matches();
	}

	// Method to validate mobile
	
	private static boolean validatemobile(String mobile) throws myException {
		Pattern pattern = Pattern.compile("^[1-9][0-9]\s[1-9][0-9]{9}");
		Matcher matcher = pattern.matcher(mobile);
		if (matcher.matches() == true) {
			System.out.println("Entered number is valid");
		} else {
			System.out.println("Entered number is invalid");
			throw new myException("Entered Mobile Number Invalid Exception", ExceptionType.INVALID_mobileNo);
		}
		return pattern.matcher(mobile).matches();

	}

	// Method to validate password
	
	private static boolean validatepassword(String password) throws myException {
		Pattern pattern = Pattern.compile("^(?=.*?[0-9a-zA-Z])[0-9a-zA-Z]*[@#$%][0-9a-zA-Z]*$");
		Matcher matcher = pattern.matcher(password);
		if (matcher.matches() == true) {
			System.out.println("Entered password is valid");
		} else {
			System.out.println("Entered password is invalid");
			throw new myException("Password entered is Invalid Exception", ExceptionType.PasswordInvalid);

		}
		



	@Test
	public void givenLastName_WhenProper_ReturnTrue() {
		UserRegis validator = new UserRegis();

		boolean result = UserRegis.validateFirstName("Gupta");
		Assert.assertEquals(true, result);
	}

	@Test
	public void givenLastName_WhenShort_ReturnFalse() {
		UserRegis validator = new UserRegis();

		boolean result = UserRegis.validateFirstName("Gu");
		Assert.assertEquals(false, result);
	}

	@Test
	public void givenLastName_WhenSpecial_ReturnFalse() {
		UserRegis validator = new UserRegis();

		boolean result = UserRegis.validateFirstName("Gu!");
		Assert.assertEquals(false, result);
	}

	@Test
	public void givenEmailID_WhenProper_ReturnTrue() {
		UserRegis validator = new UserRegis();

		boolean result = UserRegis.validateEmail("arjun17697@gmail.com");
		Assert.assertEquals(true, result);
	}

	@Test
	public void givenEmailID_WhenATmissing_ReturnFalse() {
		UserRegis validator = new UserRegis();

		boolean result = UserRegis.validateEmail("arjun17697gmail.com");
		Assert.assertEquals(false, result);
	}

	@Test
	public void givenEmailID_WhenMandatoryPart1missing_ReturnFalse() {
		UserRegis validator = new UserRegis();

		boolean result = UserRegis.validateEmail("@gmail.com");
		Assert.assertEquals(false, result);
	}

	@Test
	public void givenEmailID_WhenMandatoryPart2missing_ReturnFalse() {
		UserRegis validator = new UserRegis();

		boolean result = UserRegis.validateEmail("arjun17697@.com");
		Assert.assertEquals(false, result);
	}

	@Test
	public void givenMobileNo_WhenProper_ReturnTrue() {
		UserRegis validator = new UserRegis();

		boolean result = UserRegis.validatemobile("91 8824347236");
		Assert.assertEquals(true, result);
	}

	@Test
	public void givenMobileNo_WhenCountryCodeMissing_ReturnFalse() {
		UserRegis validator = new UserRegis();

		boolean result = UserRegis.validatemobile("8824347236");
		Assert.assertEquals(false, result);
	}

	@Test
	public void givenMobileNo_WhenSpaceMissing_ReturnFalse() {
		UserRegis validator = new UserRegis();

		boolean result = UserRegis.validatemobile("918824347236");
		Assert.assertEquals(false, result);
	}

	@Test
	public void givenMobileNo_WhenDigitsMoreThan10_ReturnFalse() {
		UserRegis validator = new UserRegis();

		boolean result = UserRegis.validatemobile("91 88243472361");
		Assert.assertEquals(false, result);
	}
@@ -172,99 +190,91 @@ public void givenPassword_WhenDigitslessthan8_ReturnFalse() {

	@Test
	public void givenPassword_WhenDigitsare8_ReturnTrue() {
		UserRegis validator = new UserRegis();

		boolean result = UserRegis.validatepassword("12345678");
		Assert.assertEquals(true, result);

	}

	@Test
	public void givenPassword_WhenNoUpperCase_ReturnFalse() {
		UserRegis validator = new UserRegis();

		boolean result = UserRegis.validatepassword("12345678");
		Assert.assertEquals(false, result);

	}

	@Test
	public void givenPassword_WhenUpperCase_ReturnTrue() {
		UserRegis validator = new UserRegis();

		boolean result = UserRegis.validatepassword("ArjunGupta");
		Assert.assertEquals(true, result);
	}

	@Test
	public void givenPassword_WhenNumberPresent_ReturnTrue() {
		UserRegis validator = new UserRegis();

		boolean result = UserRegis.validatepassword("ArjunGupta1");
		Assert.assertEquals(true, result);
	}

	@Test
	public void givenPassword_WhenNumberNotPresent_ReturnFalse() {
		UserRegis validator = new UserRegis();

		boolean result = UserRegis.validatepassword("ArjunGupta");
		Assert.assertEquals(false, result);

	}

	@Test
	public void givenPassword_WhenSpecialCharNotPresent_ReturnFalse() {
		UserRegis validator = new UserRegis();

		boolean result = UserRegis.validatepassword("ArjunGupta1");
		Assert.assertEquals(false, result);
	}

	@Test
	public void givenPassword_WhenSpecialCharPresent_ReturnTrue() {
		UserRegis validator = new UserRegis();

		boolean result = UserRegis.validatepassword("ArjunGupta1.");
		Assert.assertEquals(true, result);
	}
	public class JUnit_ParameterizedTest{


	public class JUnit_ParameterizedTest {

	}
	//UC11 Parameterized Email Check

	// UC11 Parameterized Email Check
	@RunWith(Parameterized.class)
	public class JUnit_ParameterizedTestValidator {
		private String inputmail;
		private Boolean expectedResult;
		private JUnit_ParameterizedTest junittest;
		

		@Before
		public void initialize() {
			junittest= new JUnit_ParameterizedTest();
			junittest = new JUnit_ParameterizedTest();
		}
		public JUnit_ParameterizedTestValidator(String inputmail,Boolean expectedResult )
		{ this.inputmail=inputmail;
		this.expectedResult=expectedResult;

		public JUnit_ParameterizedTestValidator(String inputmail, Boolean expectedResult) {
			this.inputmail = inputmail;
			this.expectedResult = expectedResult;
		}
		

		@Parameterized.Parameters
		public Collection emails() {
			return Arrays.asList(new Object[][] {
				{"abc@yahoo.com", true},
				{"abc-100@yahoo.com",true},
				{"abc,100@yahoo.com", true},
				{"abc111@yahoo.com",true},
				{"abc.100@bac.com.au", true},
				{"abc+100@gmail.com",true},
				{"abc", false},
				{".abc@com.my",false},
				{"abc123@gmail.a",false},
				{"abc@.abc.com",false},
				{"abc@gmail.com.aa.au",false}
			});
			return Arrays.asList(new Object[][] { { "abc@yahoo.com", true }, { "abc-100@yahoo.com", true },
					{ "abc,100@yahoo.com", true }, { "abc111@yahoo.com", true }, { "abc.100@bac.com.au", true },
					{ "abc+100@gmail.com", true }, { "abc", false }, { ".abc@com.my", false },
					{ "abc123@gmail.a", false }, { "abc@.abc.com", false }, { "abc@gmail.com.aa.au", false } });
		}
		

		@Test
		public void testJunit_Paramaterized() {
			System.out.println("Parameterized Mail is:"+ inputmail);
			assertEquals(expectedResult,JUnit_ParameterizedTest.validateEmail(inputmail));

		}

			System.out.println("Parameterized Mail is:" + inputmail);
			assertEquals(expectedResult, JUnit_ParameterizedTest.validateEmail(inputmail));

		}

	}

	public static void main(String[] args) {
		// First Name input
		System.out.println("Please enter first name");
		String fname = sc.next();
		validateFirstName(fname);
		// Last Name Input
		System.out.println("Please enter first name");
		String lname = sc.next();
		validateFirstName(lname);
		// Email input
		System.out.println("Please enter email");
		String mail = sc.next();
		validateEmail(mail);
		// Mobile Number Input
		System.out.println("Please enter mobile number");
		String mobile = sc.next();
		validatemobile(mobile);
		// Password Input
		System.out.println("Please enter password");
		String password = sc.nextLine();
		validatepassword(password);
	}
}