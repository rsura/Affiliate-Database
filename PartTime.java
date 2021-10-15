import java.util.HashMap;
import java.util.InputMismatchException;

/** PartTime.java
 *
 * This is a class for Part Time staff
 * @author Rahul Sura
 * @author sura@chapman.edu
 * CPSC 231-01 - Dr. Stevens
 * Project Chapman Affiliates Database
 * @version 1.0
 */

public class PartTime extends Staff{
	/** The hourly salary */
	private double hourlySalary;

	/**
	 * Default constructor for the PartTime class
	 */
	public PartTime() {
		hourlySalary = 0.0;
	}

	/**
	 * Overloaded constructor for the PartTime class
	 * @param name String representing name
	 * @param age int representing age
	 * @param address String representing address
	 * @param phoneNumber long representing phone number
	 * @param yearCameToChapman int representing the year the Part time Staff member came to Chapman
	 * @param staffId int representing ID
	 * @param title String representing title
	 * @param building String representing building
	 * @param hourlySalary double representing hourly salary
	 */
	public PartTime(String name, int age, String address, long phoneNumber, int yearCameToChapman, int staffId, String title, String building, double hourlySalary) {
		super(name, age, address, phoneNumber, yearCameToChapman, staffId, title, building);
		this.hourlySalary = hourlySalary;
	}

	/**
	 * Returns the Part Time staff's hourly salary
	 * @return a double representing hourly salary
	 */
	public double getHourlySalary() {
		return hourlySalary;
	}

	/**
	 * Sets the Part Time staff's hourly salary
	 * @param hourlySalary a double representing hourly salary
	 */
	public void setHourlySalary(double hourlySalary) {
		this.hourlySalary = hourlySalary;
	}

	/**
	 * Changes the String representation of the Part Time Staff object to a comma separated value format for the database
	 * @return a String representing the PartTime object
	 */
	public String toString() {
		return "PartTime, " + address + ", " + age + ", " + name + ", " +
				phoneNumber + ", " + yearCameToChapman + ", " + building + ", " +
				staffId + ", " + title + ", " + hourlySalary;
	}

	/**
	 * Creates an instance of a Part Time Staff from a line in the database
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
			double hourlySalary = Double.parseDouble(AffiliatesDriver.getNextValueFromCSV(input));

			input = "";
			records.put(staffId, new PartTime(name,age,address,phoneNumber,yearCameToChapman,staffId,title,building,hourlySalary));

		} catch (InputMismatchException | NumberFormatException e){
			System.err.println("There was an error in the file's inputs");
		}
	}
}
