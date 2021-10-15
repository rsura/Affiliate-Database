/** Staff.java
 *
 * This is a class for all Staff
 * @author Rahul Sura
 * @author sura@chapman.edu
 * CPSC 231-01 - Dr. Stevens
 * Project Chapman Affiliates Database
 * @version 1.0
 */

public abstract class Staff extends Affiliates{
	/** Staff's ID */
	protected int staffId;
	/** Staff's title */
	protected String title;
	/** Staff's building */
	protected String building;

	/**
	 * Default constructor for the Staff class
	 */
	public Staff(){
		super();
		staffId = 0;
		title = null;
		building = null;
	}

	/**
	 * Overloaded constructor for the Staff class
	 * @param name String representing name
	 * @param age int representing age
	 * @param address String representing address
	 * @param phoneNumber long representing phone number
	 * @param yearCameToChapman int representing the year the Staff member came to Chapman
	 * @param staffId int representing ID
	 * @param title String representing title
	 * @param building String representing building
	 */
	public Staff(String name, int age, String address, long phoneNumber, int yearCameToChapman, int staffId, String title, String building) {
		super(name, age, address, phoneNumber, yearCameToChapman);
		this.staffId = staffId;
		this.title = title;
		this.building = building;
	}

	/**
	 * Returns the Staff's ID
	 * @return an int representing ID
	 */
	public int getId() {
		return staffId;
	}

	/**
	 * Sets the Staff's ID
	 * @param staffId an int representing ID
	 */
	public void setId(int staffId) {
		this.staffId = staffId;
	}

	/**
	 * Returns the Staff's department
	 * @return a String representing title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the Staff's department
	 * @param title a String representing title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Returns the Staff's building
	 * @return a String representing building
	 */
	public String getBuilding() {
		return building;
	}

	/**
	 * Sets the Staff's building
	 * @param building a String representing building
	 */
	public void setBuilding(String building) {
		this.building = building;
	}

	/**
	 * Prints the attributes of the Affiliates class and Staff class
	 */
	public void print(){
		super.print();
		System.out.println("Building: " + building);
		System.out.println("Staff ID: " + staffId);
		System.out.println("Title: " + title);
	}
}
