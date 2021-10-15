/** Faculty.java
 *
 * This is a class for all Faculty
 * @author Rahul Sura
 * @author sura@chapman.edu
 * CPSC 231-01 - Dr. Stevens
 * Project Chapman Affiliates Database
 * @version 1.0
 */

public abstract class Faculty extends Affiliates{
	/** Faculty's ID */
	protected int facultyId;
	/** Faculty's department */
	protected String department;
	/** Faculty's yearly salary */
	protected int yearlySalary;
	/** Faculty's number of papers */
	protected int numberOfPapers;

	/**
	 * Default constructor for the Faculty class
	 */
	public Faculty() {
		super();
		this.facultyId = 0;
		this.department = null;
		this.yearlySalary = 0;
		this.numberOfPapers = 0;
	}

	/**
	 * Overloaded constructor for the Faculty class
	 * @param name String representing name
	 * @param age int representing age
	 * @param address String representing address
	 * @param phoneNumber long representing phone number
	 * @param yearCameToChapman int representing the year the Faculty member came to Chapman
	 * @param facultyId int representing ID
	 * @param department String representing department
	 * @param yearlySalary int representing yearly salary
	 * @param numberOfPapers int representing number of papers
	 */
	public Faculty(String name, int age, String address, long phoneNumber, int yearCameToChapman, int facultyId, String department, int yearlySalary, int numberOfPapers) {
		super(name, age, address, phoneNumber, yearCameToChapman);
		this.facultyId = facultyId;
		this.department = department;
		this.yearlySalary = yearlySalary;
		this.numberOfPapers = numberOfPapers;
	}

	/**
	 * Returns the Faculty's ID
	 * @return an int representing ID
	 */
	public int getId() {
		return facultyId;
	}

	/**
	 * Sets the Faculty's ID
	 * @param facultyId an int representing ID
	 */
	public void setId(int facultyId) {
		this.facultyId = facultyId;
	}

	/**
	 * Returns the Faculty's department
	 * @return a String representing department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * Sets the Faculty's department
	 * @param department a String representing department
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * Returns the Faculty's yearly salary
	 * @return an int representing yearly salary
	 */
	public int getYearlySalary() {
		return yearlySalary;
	}

	/**
	 * Sets the Faculty's yearly salary
	 * @param yearlySalary an int representing yearly salary
	 */
	public void setYearlySalary(int yearlySalary) {
		this.yearlySalary = yearlySalary;
	}

	/**
	 * Returns the Faculty's number of papers
	 * @return an int representing number of papers
	 */
	public int getNumberOfPapers() {
		return numberOfPapers;
	}

	/**
	 * Sets the Faculty's number of papers
	 * @param numberOfPapers an int representing number of papers
	 */
	public void setNumberOfPapers(int numberOfPapers) {
		this.numberOfPapers = numberOfPapers;
	}

	/**
	 * Prints the attributes of the Affiliates class and Faculty class
	 */
	public void print(){
		super.print();
		System.out.println("Department: " + department);
		System.out.println("Faculty ID: " + facultyId);
		System.out.println("Number of Papers: " + numberOfPapers);
		System.out.println("Yearly Salary: " + yearlySalary);
	}
}
