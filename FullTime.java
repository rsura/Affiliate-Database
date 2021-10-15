import java.util.HashMap;
import java.util.InputMismatchException;

/** FullTime.java
 *
 * This is a class for Full Time staff
 * @author Rahul Sura
 * @author sura@chapman.edu
 * CPSC 231-01 - Dr. Stevens
 * Project Chapman Affiliates Database
 * @version 1.0
 */

public class FullTime extends Staff{
	/** The yearly salary */
	private int yearlySalary;

	/**
	 * Default constructor for the FullTime class
	 */
	public FullTime() {
		yearlySalary = 0;
	}

	/**
	 * Overloaded constructor for the FullTime class
	 * @param name String representing name
	 * @param age int representing age
	 * @param address String representing address
	 * @param phoneNumber long representing phone number
	 * @param yearCameToChapman int representing the year the Full time Staff member came to Chapman
	 * @param staffId int representing ID
	 * @param title String representing title
	 * @param building String representing building
	 * @param yearlySalary int representing yearly salary
	 */
	public FullTime(String name, int age, String address, long phoneNumber, int yearCameToChapman, int staffId, String title, String building, int yearlySalary) {
		super(name, age, address, phoneNumber, yearCameToChapman, staffId, title, building);
		this.yearlySalary = yearlySalary;
	}

	/**
	 * Returns the Full Time staff's yearly salary
	 * @return an int representing yearly salary
	 */
	public int getYearlySalary() {
		return yearlySalary;
	}

	/**
	 * Sets the Full Time staff's yearly salary
	 * @param yearlySalary an int representing yearly salary
	 */
	public void setYearlySalary(int yearlySalary) {
		this.yearlySalary = yearlySalary;
	}

	/**
	 * Prints the attributes of the Affiliates class, Staff class and FullTime class
	 */
	public void print() {
		System.out.println(Affiliates.divider2);
		System.out.println("Information about the Full Time staff member with ID: " + getId());
		System.out.println(Affiliates.divider3);
		super.print();
		System.out.println("Yearly Salary: " + yearlySalary);
		System.out.println(Affiliates.divider2);
	}

	/**
	 * Changes the String representation of the Full Time Staff object to a comma separated value format for the database
	 * @return a String representing the FullTime object
	 */
	public String toString() {
		return "FullTime, " + address + ", " + age + ", " + name + ", " +
				phoneNumber + ", " + yearCameToChapman + ", " + building + ", " +
				staffId + ", " + title + ", " + yearlySalary;
	}

	/**
	 * Creates an instance of a Full Time Staff from a line in the database
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
			String building = AffiliatesDriver.getNextValueFromCSV(input);

			input = AffiliatesDriver.updateString(input);
			int staffId = Integer.parseInt(AffiliatesDriver.getNextValueFromCSV(input));

			input = AffiliatesDriver.updateString(input);
			String title = AffiliatesDriver.getNextValueFromCSV(input);

			input = AffiliatesDriver.updateString(input);
			int yearlySalary = Integer.parseInt(AffiliatesDriver.getNextValueFromCSV(input));

			input = "";
			records.put(staffId, new FullTime(name,age,address,phoneNumber,yearCameToChapman,staffId,title,building,yearlySalary));

		} catch (InputMismatchException | NumberFormatException e){
			System.err.println("There was an error in the file's inputs");
		}
	}
}
