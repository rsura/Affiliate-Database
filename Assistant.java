import java.util.HashMap;
import java.util.InputMismatchException;

/** Assistant.java
 *
 * This is a class for Assistant Professors
 * @author Rahul Sura
 * @author sura@chapman.edu
 * CPSC 231-01 - Dr. Stevens
 * Project Chapman Affiliates Database
 * @version 1.0
 */

public class Assistant extends Faculty{
	/** The number of years until the Assistant professor reaches tenure */
	private int yearsUntilTenure;

	/**
	 * Default constructor for the Assistant class
	 */
	public Assistant(){
		super();
		yearsUntilTenure = 0;
	}

	/**
	 * Overloaded constructor for the Assistant class
	 * @param name String representing name
	 * @param age int representing age
	 * @param address String representing address
	 * @param phoneNumber long representing phone number
	 * @param yearCameToChapman int representing the year the Assistant professor came to Chapman
	 * @param facultyId int representing ID
	 * @param department String representing department
	 * @param yearlySalary int representing yearly salary
	 * @param numberOfPapers int representing number of papers
	 * @param yearsUntilTenure int representing years until tenure
	 */
	public Assistant(String name, int age, String address, long phoneNumber, int yearCameToChapman, int facultyId, String department, int yearlySalary, int numberOfPapers, int yearsUntilTenure) {
		super(name, age, address, phoneNumber, yearCameToChapman, facultyId, department, yearlySalary, numberOfPapers);
		this.yearsUntilTenure = yearsUntilTenure;
	}

	/**
	 * Returns years until tenure
	 * @return an int representing number of years until the Assistant professor reaches tenure
	 */
	public int getYearsUntilTenure() {
		return yearsUntilTenure;
	}

	/**
	 * Sets years until tenure
	 * @param yearsUntilTenure an int representing number of years until the Assistant professor reaches tenure
	 */
	public void setYearsUntilTenure(int yearsUntilTenure) {
		this.yearsUntilTenure = yearsUntilTenure;
	}

	/**
	 * Prints the attributes of the Affiliates class, Faculty class and Assistant class
	 */
	public void print() {
		System.out.println(Affiliates.divider2);
		System.out.println("Information about the Assistant Professor with ID: " + getId());
		System.out.println(Affiliates.divider3);
		super.print();
		System.out.println("Years until tenure: " + yearsUntilTenure);
		System.out.println(Affiliates.divider2);
	}

	/**
	 * Changes the String representation of the Assistant Professor object to a comma separated value format for the database
	 * @return a String representing the Assistant object
	 */
	public String toString() {
		return "Assistant, " + address + ", " + age + ", " + name + ", " +
				phoneNumber + ", " + yearCameToChapman + ", " + department + ", " +
				facultyId + ", " + numberOfPapers + ", " + yearlySalary + ", " + yearsUntilTenure;
	}

	/**
	 * Creates an instance of an Assistant Professor from a line in the database
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
			int yearsUntilTenure = Integer.parseInt(AffiliatesDriver.getNextValueFromCSV(input));

			input = "";
			records.put(facultyId,new Assistant(name,age,address,phoneNumber,yearCameToChapman,facultyId,department,yearlySalary,numberOfPapers,yearsUntilTenure));

		} catch (InputMismatchException | NumberFormatException e){
			System.err.println("There was an error in the file's inputs");
		}
	}

}
