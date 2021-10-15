import java.util.HashMap;
import java.util.InputMismatchException;

/** Undergrad.java
 *
 * This is a class for Undergrad Students
 * @author Rahul Sura
 * @author sura@chapman.edu
 * CPSC 231-01 - Dr. Stevens
 * Project Chapman Affiliates Database
 * @version 1.0
 */

public class Undergrad extends Students{
	/** The number of courses taken */
	private int numCoursesTaken;
	/** The annual scholarship amount */
	private int scholarshipAmt;

	/**
	 * Default constructor for the Undergrad class
	 */
	public Undergrad() {
		numCoursesTaken = 0;
		scholarshipAmt = 0;
	}

	/**
	 *
	 * @param name String representing name
	 * @param age int representing age
	 * @param address String representing address
	 * @param phoneNumber long representing phone number
	 * @param yearCameToChapman int representing the year the Undergrad Student came to Chapman
	 * @param studentId int representing ID
	 * @param major String representing major
	 * @param minor String representing minor
	 * @param classStanding String representing class standing
	 * @param numCoursesTaken int representing number of courses taken
	 * @param scholarshipAmt int representing annual scholarship amount
	 */
	public Undergrad(String name, int age, String address, long phoneNumber, int yearCameToChapman, int studentId, String major, String minor, String classStanding, int numCoursesTaken, int scholarshipAmt) {
		super(name, age, address, phoneNumber, yearCameToChapman, studentId, major, minor, classStanding);
		this.numCoursesTaken = numCoursesTaken;
		this.scholarshipAmt = scholarshipAmt;
	}

	/**
	 * Returns number of courses taken
	 * @return an int representing number of courses taken
	 */
	public int getNumCoursesTaken() {
		return numCoursesTaken;
	}

	/**
	 * Sets number of courses taken
	 * @param numCoursesTaken an int representing number of courses taken
	 */
	public void setNumCoursesTaken(int numCoursesTaken) {
		this.numCoursesTaken = numCoursesTaken;
	}

	/**
	 * Returns Undergrad's annual scholarship amount
	 * @return an int representing annual scholarship amount
	 */
	public int getScholarshipAmt() {
		return scholarshipAmt;
	}

	/**
	 * Sets Undergrad's annual scholarship amount
	 * @param scholarshipAmt an int representing annual scholarship amount
	 */
	public void setScholarshipAmt(int scholarshipAmt) {
		this.scholarshipAmt = scholarshipAmt;
	}

	/**
	 * Prints the attributes of the Affiliates class, Student class and Undergrad class
	 */
	public void print() {
		System.out.println(Affiliates.divider2);
		System.out.println("Information about the Undergrad Student with ID: " + getId());
		System.out.println(Affiliates.divider3);
		super.print();
		System.out.println("Number of course taken: " + numCoursesTaken);
		System.out.println("Scholarship Amount: " + scholarshipAmt);
		System.out.println(Affiliates.divider2);
	}

	/**
	 * Changes the String representation of the Undergrad Student object to a comma separated value format for the database
	 * @return a String representing the Undergrad object
	 */
	public String toString() {
		return "Undergrad, " + address + ", " + age + ", " + name + ", " +
				phoneNumber + ", " + yearCameToChapman + ", " + classStanding + ", " +
				major + ", " + minor + ", " + studentId + ", " + numCoursesTaken + ", " + scholarshipAmt;
	}

	/**
	 * Creates an instance of an Undergrad Student from a line in the database
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
			String classStanding = AffiliatesDriver.getNextValueFromCSV(input);

			input = AffiliatesDriver.updateString(input);
			String major = AffiliatesDriver.getNextValueFromCSV(input);

			input = AffiliatesDriver.updateString(input);
			String minor = AffiliatesDriver.getNextValueFromCSV(input);

			input = AffiliatesDriver.updateString(input);
			int studentId = Integer.parseInt(AffiliatesDriver.getNextValueFromCSV(input));

			input = AffiliatesDriver.updateString(input);
			int numCoursesTaken = Integer.parseInt(AffiliatesDriver.getNextValueFromCSV(input));

			input = AffiliatesDriver.updateString(input);
			int scholarshipAmt = Integer.parseInt(AffiliatesDriver.getNextValueFromCSV(input));

			input = "";
			records.put(studentId, new Undergrad(name,age,address,phoneNumber,yearCameToChapman,studentId,major,minor,classStanding,numCoursesTaken,scholarshipAmt));

		} catch (InputMismatchException | NumberFormatException e){
			System.err.println("There was an error in the file's inputs");
		}
	}
}
