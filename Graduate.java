import java.util.HashMap;
import java.util.InputMismatchException;

/** Graduate.java
 *
 * This is a class for Graduate Students
 * @author Rahul Sura
 * @author sura@chapman.edu
 * CPSC 231-01 - Dr. Stevens
 * Project Chapman Affiliates Database
 * @version 1.0
 */

public class Graduate extends Students{
	/** The number of papers published */
	private int numPapersPublished;
	/** The Graduate student's thesis advisor */
	private String thesisAdvisor;

	/**
	 * Default constructor for the Graduate class
	 */
	public Graduate() {
		numPapersPublished = 0;
		thesisAdvisor = null;
	}

	/**
	 * Overloaded constructor for the Graduate class
	 * @param name String representing name
	 * @param age int representing age
	 * @param address String representing address
	 * @param phoneNumber long representing phone number
	 * @param yearCameToChapman int representing the year the Graduate Student came to Chapman
	 * @param studentId int representing ID
	 * @param major String representing major
	 * @param minor String representing minor
	 * @param classStanding String representing class standing
	 * @param numPapersPublished int representing number of papers published
	 * @param thesisAdvisor String representing the Graduate student's thesis advisor
	 */
	public Graduate(String name, int age, String address, long phoneNumber, int yearCameToChapman, int studentId, String major, String minor, String classStanding, int numPapersPublished, String thesisAdvisor) {
		super(name, age, address, phoneNumber, yearCameToChapman, studentId, major, minor, classStanding);
		this.numPapersPublished = numPapersPublished;
		this.thesisAdvisor = thesisAdvisor;
	}

	/**
	 * Returns number of papers published
	 * @return an int representing number of papers published
	 */
	public int getNumPapersPublished() {
		return numPapersPublished;
	}

	/**
	 * Sets number of papers published
	 * @param numPapersPublished an int representing number of papers published
	 */
	public void setNumPapersPublished(int numPapersPublished) {
		this.numPapersPublished = numPapersPublished;
	}

	/**
	 * Returns Graduate student's thesis advisor
	 * @return a String representing the Graduate student's thesis advisor's name
	 */
	public String getThesisAdvisor() {
		return thesisAdvisor;
	}

	/**
	 * Sets Graduate student's thesis advisor
	 * @param thesisAdvisor a String representing the Graduate student's thesis advisor's name
	 */
	public void setThesisAdvisor(String thesisAdvisor) {
		this.thesisAdvisor = thesisAdvisor;
	}

	/**
	 * Prints the attributes of the Affiliates class, Student class and Graduate class
	 */
	public void print() {
		System.out.println(Affiliates.divider2);
		System.out.println("Information about the Graduate Student with ID: " + getId());
		System.out.println(Affiliates.divider3);
		super.print();
		System.out.println("Number of papers published: " + numPapersPublished);
		System.out.println("Thesis Advisor: " + thesisAdvisor);
		System.out.println(Affiliates.divider2);
	}

	/**
	 * Changes the String representation of the Graduate Student object to a comma separated value format for the database
	 * @return a String representing the Graduate object
	 */
	public String toString() {
		return "Graduate, " + address + ", " + age + ", " + name + ", " +
				phoneNumber + ", " + yearCameToChapman + ", " + classStanding + ", " +
				major + ", " + minor + ", " + studentId + ", " + numPapersPublished + ", " + thesisAdvisor;
	}

	/**
	 * Creates an instance of a Graduate Student from a line in the database
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
			int numPapersPublished = Integer.parseInt(AffiliatesDriver.getNextValueFromCSV(input));

			input = AffiliatesDriver.updateString(input);
			String thesisAdvisor = AffiliatesDriver.getNextValueFromCSV(input);

			input = "";
			records.put(studentId,new Graduate(name,age,address,phoneNumber,yearCameToChapman,studentId,major,minor,classStanding,numPapersPublished,thesisAdvisor));

		} catch (InputMismatchException | NumberFormatException e){
			System.err.println("There was an error in the file's inputs");
		}
	}
}
