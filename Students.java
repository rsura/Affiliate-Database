/** Students.java
 *
 * This is a class for all Students
 * @author Rahul Sura
 * @author sura@chapman.edu
 * CPSC 231-01 - Dr. Stevens
 * Project Chapman Affiliates Database
 * @version 1.0
 */

public abstract class Students extends Affiliates{
	/** Student's ID */
	protected int studentId;
	/** Student's major */
	protected String major;
	/** Student's minor */
	protected String minor;
	/** Student's class standing */
	protected String classStanding;

	/**
	 * Default constructor for the Students class
	 */
	public Students(){
		super();
		studentId = 0;
		major = null;
		minor = null;
		classStanding = null;
	}

	/**
	 * Overloaded constructor for the Students class
	 * @param name String representing name
	 * @param age int representing age
	 * @param address String representing address
	 * @param phoneNumber long representing phone number
	 * @param yearCameToChapman int representing the year the Staff member came to Chapman
	 * @param studentId int representing ID
	 * @param major String representing major
	 * @param minor String representing minor
	 * @param classStanding String representing class standing
	 */
	public Students(String name, int age, String address, long phoneNumber, int yearCameToChapman, int studentId, String major, String minor, String classStanding) {
		super(name, age, address, phoneNumber, yearCameToChapman);
		this.studentId = studentId;
		this.major = major;
		this.minor = minor;
		this.classStanding = classStanding;
	}

	/**
	 * Returns the Student's ID
	 * @return an int representing ID
	 */
	public int getId() {
		return studentId;
	}

	/**
	 * Sets the Student's ID
	 * @param studentId an int representing ID
	 */
	public void setId(int studentId) {
		this.studentId = studentId;
	}

	/**
	 * Returns the Student's major
	 * @return a String representing major
	 */
	public String getMajor() {
		return major;
	}

	/**
	 * Sets the Student's major
	 * @param major a String representing major
	 */
	public void setMajor(String major) {
		this.major = major;
	}

	/**
	 * Returns the Student's minor
	 * @return a String representing minor
	 */
	public String getMinor() {
		return minor;
	}

	/**
	 * Sets the Student's minor
	 * @param minor a String representing minor
	 */
	public void setMinor(String minor) {
		this.minor = minor;
	}

	/**
	 * Returns the Student's class standing
	 * @return a String representing class standing
	 */
	public String getClassStanding() {
		return classStanding;
	}

	/**
	 * Sets the Student's class standing
	 * @param classStanding a String representing class standing
	 */
	public void setClassStanding(String classStanding) {
		this.classStanding = classStanding;
	}

	/**
	 * Prints the attributes of the Affiliates class and Students class
	 */
	public void print(){
		super.print();
		System.out.println("Class Standing: " + classStanding);
		System.out.println("Major: " + major);
		System.out.println("Minor: " + minor);
		System.out.println("Student ID: " + studentId);
	}
}
