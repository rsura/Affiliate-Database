import java.util.HashMap;
import java.util.InputMismatchException;

/** Full.java
 *
 * This is a class for Full time Professors
 * @author Rahul Sura
 * @author sura@chapman.edu
 * CPSC 231-01 - Dr. Stevens
 * Project Chapman Affiliates Database
 * @version 1.0
 */

public class Full extends Faculty{
	/** The number of years until the Full time professor reaches retirement */
	private int yearsUntilRetirement;

	/**
	 * Default constructor for the Full (Full time professor) class
	 */
	public Full(){
		yearsUntilRetirement = 0;
	}

	/**
	 * Overloaded constructor for the Full (Full time professor) class
	 * @param name String representing name
	 * @param age int representing age
	 * @param address String representing address
	 * @param phoneNumber long representing phone number
	 * @param yearCameToChapman int representing the year the Full time professor came to Chapman
	 * @param facultyId int representing ID
	 * @param department String representing department
	 * @param yearlySalary int representing yearly salary
	 * @param numberOfPapers int representing number of papers
	 * @param yearsUntilRetirement int representing years until retirement
	 */
	public Full(String name, int age, String address, long phoneNumber, int yearCameToChapman, int facultyId, String department, int yearlySalary, int numberOfPapers, int yearsUntilRetirement) {
		super(name, age, address, phoneNumber, yearCameToChapman, facultyId, department, yearlySalary, numberOfPapers);
		this.yearsUntilRetirement = yearsUntilRetirement;
	}

	/**
	 * Returns years until retirement
	 * @return an int representing years until retirement
	 */
	public int getYearsUntilRetirement() {
		return yearsUntilRetirement;
	}

	/**
	 * Sets years until retirement
	 * @param yearsUntilRetirement an int representing years until retirement
	 */
	public void setYearsUntilRetirement(int yearsUntilRetirement) {
		this.yearsUntilRetirement = yearsUntilRetirement;
	}

	/**
	 * Prints the attributes of the Affiliates class, Faculty class and Full class
	 */
	public void print() {
		System.out.println(Affiliates.divider2);
		System.out.println("Information about the Full time professor with ID: " + getId());
		System.out.println(Affiliates.divider3);
		super.print();
		System.out.println("Years until retirement: " + yearsUntilRetirement);
		System.out.println(Affiliates.divider2);
	}

	/**
	 * Changes the String representation of the Full time Professor object to a comma separated value format for the database
	 * @return a String representing the Full object
	 */
	public String toString() {
		return "Full, " + address + ", " + age + ", " + name + ", " +
				phoneNumber + ", " + yearCameToChapman + ", " + department + ", " +
				facultyId + ", " + numberOfPapers + ", " + yearlySalary + ", " + yearsUntilRetirement;
	}

	/**
	 * Creates an instance of a Full time Professor from a line in the database
	 * @param records a Hashmap containing the current list of Affiliates
	 * @param input the current line being read from in the database file
	 */
	public static void createInstance(HashMap<Integer, Affiliates> records, String input){
		try{
			input = AffiliatesDriver.updateString(input);
			String address = AffiliatesDriver.getNextValueFromCSV(input);

			input = AffiliatesDriver.updateString(input);
			int age = Integer.parseInt(AffiliatesDriver.getNextValueFromCSV(input));

			input = AffiliatesDriver.updateString(input);
			String name = AffiliatesDriver.getNextValueFromCSV(input);

			input = AffiliatesDriver.updateString(input);
			long phoneNumber = Long.parseLong(AffiliatesDriver.getNextValueFromCSV(input));

			input = AffiliatesDriver.updateString(input);
			int yearCameToChapman = Integer.parseInt(AffiliatesDriver.getNextValueFromCSV(input));

			input = AffiliatesDriver.updateString(input);
			String department = AffiliatesDriver.getNextValueFromCSV(input);

			input = AffiliatesDriver.updateString(input);
			int facultyId = Integer.parseInt(AffiliatesDriver.getNextValueFromCSV(input));

			input = AffiliatesDriver.updateString(input);
			int numberOfPapers = Integer.parseInt(AffiliatesDriver.getNextValueFromCSV(input));

			input = AffiliatesDriver.updateString(input);
			int yearlySalary = Integer.parseInt(AffiliatesDriver.getNextValueFromCSV(input));

			input = AffiliatesDriver.updateString(input);
			int yearsUntilRetirement = Integer.parseInt(AffiliatesDriver.getNextValueFromCSV(input));

			input = "";
			records.put(facultyId,new Full(name,age,address,phoneNumber,yearCameToChapman,facultyId,department,yearlySalary,numberOfPapers,yearsUntilRetirement));

		} catch (InputMismatchException | NumberFormatException e){
			System.err.println("There was an error in the file's inputs");
		}
	}
}
