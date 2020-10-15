package lambda;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class userregis {
	static Scanner sc = new Scanner(System.in);

	// Method to validate first and last name
	 
	private static boolean validateFirstName(String fname) {
		Pattern pattern = Pattern.compile("^[A-Z][a-z]{2,}$");
		Matcher matcher = pattern.matcher(fname);
		if (matcher.matches() == true) {
			System.out.println("Entered name is valid");
		} else {
			System.out.println("Entered name is not valid");
		}
		return pattern.matcher(fname).matches();
	}

	// Method to validate email
	
	public static boolean validateEmail(String mail) {
		Pattern pattern = Pattern.compile(
				"\"^[0-9a-zA-Z]+([._+-][0-9a-zA-Z]+)*@([0-9a-zA-Z][-]?)+[.][a-zA-Z]{2,4}([.][a-zA-Z]{2,4})?$\"");
		Matcher matcher = pattern.matcher(mail);

		{
			else {
		}
			System.out.println("Entered email is invalid");
		}
		return pattern.matcher(mail).matches();
	}

	// Method to validate mobile
	
	private static boolean validatemobile(String mobile) {
		Pattern pattern = Pattern.compile("^[1-9][0-9]\s[1-9][0-9]{9}");
		Matcher matcher = pattern.matcher(mobile);
		if (matcher.matches() == true) {
			System.out.println("Entered number is valid");
		} else {
			System.out.println("Entered number is invalid");
		}
		return pattern.matcher(mobile).matches();

	}

	// Method to validate password
	
	private static boolean validatepassword(String password) {
		Pattern pattern = Pattern.compile("^(?=.*?[0-9a-zA-Z])[0-9a-zA-Z]*[@#$%][0-9a-zA-Z]*$");
		Matcher matcher = pattern.matcher(password);
		if (matcher.matches() == true) {
			System.out.println("Entered password is valid");
		} else {
			System.out.println("Entered password is invalid");
		}
		return pattern.matcher(password).matches();

	}

	// JUnit Test Cases
	@Test
	public static void givenFirstName_WhenProper_ReturnTrue() {

		boolean result = UserRegis.validateFirstName("Arjun");
		Assert.assertEquals(true, result);

	}

	@Test
	public void givenFirstName_WhenShort_ReturnFalse() {

		boolean result = UserRegis.validateFirstName("Ar");
		Assert.assertEquals(false, result);
	}

	@Test
	public void givenFirstName_WhenSpecial_ReturnFalse() {

		boolean result = UserRegis.validateFirstName("Ar!");
		Assert.assertEquals(false, result);

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

	@Test
	public void givenPassword_WhenDigitslessthan8_ReturnFalse() {

		boolean result = UserRegis.validatepassword("1234567");
		Assert.assertEquals(false, result);
	}

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

	}
	//UC11 Parameterized Email Check
	@RunWith(Parameterized.class)
	public class JUnit_ParameterizedTestValidator {
		private String inputmail;
		private Boolean expectedResult;
		private JUnit_ParameterizedTest junittest;

		@Before
		public void initialize() {
			junittest= new JUnit_ParameterizedTest();
		}
		public JUnit_ParameterizedTestValidator(String inputmail,Boolean expectedResult )
		{ this.inputmail=inputmail;
		this.expectedResult=expectedResult;
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
		}

		@Test
		public void testJunit_Paramaterized() {
			System.out.println("Parameterized Mail is:"+ inputmail);
			assertEquals(expectedResult,JUnit_ParameterizedTest.validateEmail(inputmail));

		}



	}

 {
		// First Name input
		System.out.println("Please enter first name");
		String fname = sc.next();
		firstname(fname);
		validateFirstName(fname);

		// Last Name Input
		System.out.println("Please enter first name");
		String lname = sc.next();
		firstname(lname);
		validateFirstName(lname);

		// Email input
		System.out.println("Please enter email");
		String mail = sc.next();
		email(mail);
		validateEmail(mail);

		// Mobile Number Input
		System.out.println("Please enter mobile number");
		String mobile = sc.next();
		mobile(mobile);
		validatemobile(mobile);

		// Password Input
		System.out.println("Please enter password");
		String password = sc.nextLine();
		password(password);
		validatepassword(password);

	}
} 