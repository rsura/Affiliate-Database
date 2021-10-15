/** Affiliates.java
 *
 * This is a class for all Affiliates
 * @author Rahul Sura
 * @author sura@chapman.edu
 * CPSC 231-01 - Dr. Stevens
 * Project Chapman Affiliates Database
 * @version 1.0
 */

public abstract class Affiliates implements Comparable<Affiliates>, Printable{
	/** Affiliate's name */
	protected String name;
	/** Affiliate's age */
	protected int age;
	/** Affiliate's address */
	protected String address;
	/** Affiliate's phone number */
	protected long phoneNumber; // Long because a phone number of (999) 999 - 9999 is long
	/** The year the Affiliate came to Chapman */
	protected int yearCameToChapman;
	/** Divider 1 for formatting print statements */
	public static final String divider1 = "___________________________________________\n" + "===========================================";
	/** Divider 2 for formatting print statements */
	public static final String divider2 = "===========================================";
	/** Divider 3 for formatting print statements */
	public static final String divider3 = "---------------------------------";

	/**
	 * Default constructor for the Affiliates class
	 */
	public Affiliates() {
		name = null;
		age = 0;
		address = null;
		phoneNumber = 0L;
		yearCameToChapman = 1861; // Year Chapman was founded :)
	}

	/**
	 * Overloaded constructor for the Affiliates class
	 * @param name String representing name
	 * @param age int representing age
	 * @param address String representing address
	 * @param phoneNumber long representing phone number
	 * @param yearCameToChapman int representing the year the Affiliate came to Chapman
	 */
	public Affiliates(String name, int age, String address, long phoneNumber, int yearCameToChapman) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.yearCameToChapman = yearCameToChapman;
	}

	/**
	 * Returns the Affiliate's name
	 * @return a String representing name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the Affiliate's name
	 * @param name a String representing name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the Affiliate's age
	 * @return an int representing age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the Affiliate's name
	 * @param age an int representing age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Returns the Affiliate's address
	 * @return a String representing address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the Affiliate's address
	 * @param address a String representing address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Returns the Affiliate's phone number
	 * @return a long representing phone number
	 */
	public long getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the Affiliate's phone number
	 * @param phoneNumber a long representing phone number
	 */
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Returns the year the Affiliate came to Chapman
	 * @return an int representing the year the Affiliate came to Chapman
	 */
	public int getYearCameToChapman() {
		return yearCameToChapman;
	}

	/**
	 * Sets the year the Affiliate came to Chapman
	 * @param yearCameToChapman an int representing the year the Affiliate came to Chapman
	 */
	public void setYearCameToChapman(int yearCameToChapman) {
		this.yearCameToChapman = yearCameToChapman;
	}

	/**
	 * Shows which Affiliate has more seniority
	 * @param a Any type of affiliate
	 * @return a 1 if the Affiliate is more senior to the passed Affiliate, a -1 if the Affiliate is less senior to the passed Affiliate and 0 if they came the same year
	 */
	public int compareTo(Affiliates a) {
		if(this.yearCameToChapman < a.yearCameToChapman){ // came to Chapman at earlier year means higher seniority
			return 1;
		} else if (this.yearCameToChapman > a.yearCameToChapman){ // vice versa of logic above
			return -1;
		}
		return 0;
	}

	/**
	 * Returns the Affiliate's ID. This is meant to be overridden in subclasses
	 * @return an int representing Affiliate's ID
	 */
	public int getId() {
		return 0;
	}

	/**
	 * Sets the Affiliate's ID. This is meant to be overridden in subclasses
	 * @param AffiliateId an int representing faculty's ID
	 */
	public void setId(int AffiliateId) {
		// sets the Affiliate's ID but no such member variable here so will be overridden.
	}

	/**
	 * Prints the attributes of the general Affiliates class
	 */
	public void print() {
		System.out.println("Address: " + address);
		System.out.println("Age: " + age);
		System.out.println("Name: " + name);
		System.out.println("Phone Number: " + phoneNumber);
		System.out.println("Year they came to Chapman: " + yearCameToChapman);
	}
}
