import java.util.HashMap;
import java.util.InputMismatchException;

/** Associate.java
 *
 * This is a class for Associate Professors
 * @author Rahul Sura
 * @author sura@chapman.edu
 * CPSC 231-01 - Dr. Stevens
 * Project Chapman Affiliates Database
 * @version 1.0
 */

public class Associate extends Faculty{
	/** The number of years since the Associates professor's tenure */
	private int yearsSinceTenure;

	/**
	 * Default constructor for the Associate class
	 */
	public Associate(){
		super();
		yearsSinceTenure = 0;
	}

	/**
	 * Overloaded constructor for the Associate class
	 * @param name String representing name
	 * @param age int representing age
	 * @param address String representing address
	 * @param phoneNumber long representing phone number
	 * @param yearCameToChapman int representing the year the Associate professor came to Chapman
	 * @param facultyId int representing ID
	 * @param department String representing department
	 * @param yearlySalary int representing yearly salary
	 * @param numberOfPapers int representing number of papers
	 * @param yearsSinceTenure int representing years since tenure
	 */
	public Associate(String name, int age, String address, long phoneNumber, int yearCameToChapman, int facultyId, String department, int yearlySalary, int numberOfPapers, int yearsSinceTenure) {
		super(name, age, address, phoneNumber, yearCameToChapman, facultyId, department, yearlySalary, numberOfPapers);
		this.yearsSinceTenure = yearsSinceTenure;
	}

	/**
	 * Returns years since tenure
	 * @return an int representing number of years since the Associate professor's tenure
	 */
	public int getYearsSinceTenure() {
		return yearsSinceTenure;
	}

	/**
	 * Sets years since tenure
	 * @param yearsSinceTenure an int representing number of years since the Associate professor's tenure
	 */
	public void setYearsSinceTenure(int yearsSinceTenure) {
		this.yearsSinceTenure = yearsSinceTenure;
	}

	/**
	 * Prints the attributes of the Affiliates class, Faculty class and Associate class
	 */
	public void print() {
		System.out.println(Affiliates.divider2);
		System.out.println("Information about the Associate Professor with ID: " + getId());
		System.out.println(Affiliates.divider3);
		super.print();
		System.out.println("Years since tenure: " + yearsSinceTenure);
		System.out.println(Affiliates.divider2);
	}

	/**
	 * Changes the String representation of the Associate Professor object to a comma separated value format for the database
	 * @return a String representing the Associate object
	 */
	public String toString() {
		return "Associate, " + address + ", " + age + ", " + name + ", " +
				phoneNumber + ", " + yearCameToChapman + ", " + department + ", " +
				facultyId + ", " + numberOfPapers + ", " + yearlySalary + ", " + yearsSinceTenure;
	}

	/**
	 * Creates an instance of an Associate Professor from a line in the database
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
			int yearsSinceTenure = Integer.parseInt(AffiliatesDriver.getNextValueFromCSV(input));

			input = "";
			records.put(facultyId,new Associate(name,age,address,phoneNumber,yearCameToChapman,facultyId,department,yearlySalary,numberOfPapers,yearsSinceTenure));

		} catch (InputMismatchException | NumberFormatException e){
			System.err.println("There was an error in the file's inputs");
		}

	}
}
