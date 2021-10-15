import java.io.*;
import java.util.*;

/** AffiliatesDriver.java
 *
 * This is a class for running the program to create modify and save a database of Chapman Affiliates
 * @author Rahul Sura
 * @author sura@chapman.edu
 * CPSC 231-01 - Dr. Stevens
 * Project Chapman Affiliates Database
 * @version 1.0
 */

public class AffiliatesDriver {

  /**
   * Prints the options for interacting with the database
   */
	public static void printOptions(){
		System.out.println(Affiliates.divider3); //Uses a final variable for making a divider
		System.out.println("Please enter one of the following numbers to select an option");
		System.out.println("1) Create an affiliate record");
		System.out.println("2) Print information for an Affiliate given the id");
		System.out.println("3) List all affiliates in order of seniority");
		System.out.println("4) Delete a record given the id");
		System.out.println("5) Save your database to a file");
		System.out.println("6) Restore your database from a file");
		System.out.println("7) Exit");
		System.out.println(Affiliates.divider3);
	}

  /**
   * Prints the options for creating a certain type of Affiliate
   */
	public static void printAffiliateCreationOptions(){
		System.out.println(Affiliates.divider2);
		System.out.println("Select one of the numbers to create the corresponding type of Affiliate");
		System.out.println("Please enter one of the following numbers to select an option");
		System.out.println("1) Assistant Professor");
		System.out.println("2) Associate Professor");
		System.out.println("3) Full Time Professor");
		System.out.println("4) Graduate Student");
		System.out.println("5) Undergraduate Student");
		System.out.println("6) Full Time Staff");
		System.out.println("7) Part Time Staff");
		System.out.println("8) EXIT and NOT create an Affiliate");
		System.out.println(Affiliates.divider2);
	}

	/**
	 * Updates the line input from the comma separated values in the database file
   * @param input a String representing a Line from the database
	 * @return a String representing the rest of the line, removing the current value that has already been parsed
	 */
	public static String updateString(String input){
		if(input.indexOf(',') > -1){ // checks if there is a comma still remaining in the String
			return input.replaceFirst(input.substring(0,(input.indexOf(',') + 2)),""); // deletes the element before the next comma
		} else {
			return ""; // return an empty string otherwise
		}
	}

	/**
	 * Gets the value of each attribute in the data base by removing the comma and extra space in the database
	 * @param input a String representing a Line from the database
	 * @return a String representing the next value
	 */
	public static String getNextValueFromCSV(String input){
		if(input.indexOf(',') > -1){ // checks if there is a comma still remaining in the String
			return input.substring(0,input.indexOf(',')); // returns the next value in the comma separated values
		} else {
			return input; // returns the last input otherwise
		}
	}

	/**
	 * Option 1 - Creating an affiliate
	 * @param records a Hashmap of the affiliates keyed by their ID
	 */
	public static void optionOne(HashMap<Integer, Affiliates> records){
		Scanner scanner = new Scanner(System.in);
		printAffiliateCreationOptions(); // prints options for which affiliate to create
		try{
			String s = scanner.nextLine(); // which type of affiliate
			s = s.replaceAll("[^0-9]",""); // removes non numerical characters from the String input
			int option = Integer.parseInt(s); // makes it into an integer
			if (option >= 1 && option <= 7){ // if it's an Affiliate
				System.out.println("Enter their name:");
				String name = scanner.nextLine();
				System.out.println("Enter their age:");
				int age = Integer.parseInt(scanner.nextLine().replaceAll("[^0-9]","")); // removes non numerical characters to make it an int
				System.out.println("Enter their address:");
				String address = scanner.nextLine().replaceAll(",","");
				System.out.println("Enter their phone number:");
				long phoneNumber = Long.parseLong(scanner.nextLine().replaceAll("[^0-9]",""));
				System.out.println("Enter the year they came to Chapman:");
				int yearCameToChapman = Integer.parseInt(scanner.nextLine().replaceAll("[^0-9]",""));
				if (option <= 3){ // If the affiliate is faculty
					System.out.println("Enter their faculty ID:");
					int facultyID = Integer.parseInt(scanner.nextLine().replaceAll("[^0-9]",""));
					System.out.println("Enter their department:");
					String department = scanner.nextLine();
					System.out.println("Enter their yearly salary:");
					int yearlySalary = Integer.parseInt(scanner.nextLine().replaceAll("[^0-9]",""));
					System.out.println("Enter the number of papers they have");
					int numPapers = Integer.parseInt(scanner.nextLine().replaceAll("[^0-9]",""));
					if(option == 1){ // If the faculty is an Assistant Professor
						System.out.println("Enter the years until tenure");
						int yearsUntilTenure = Integer.parseInt(scanner.nextLine().replaceAll("[^0-9]",""));
						records.put(facultyID,new Assistant(name,age,address,phoneNumber,yearCameToChapman,facultyID,department,yearlySalary,numPapers,yearsUntilTenure));
					} else if (option == 2){ // If the faculty is an Associate Professor
						System.out.println("Enter the years since tenure");
						int yearsSinceTenure = Integer.parseInt(scanner.nextLine().replaceAll("[^0-9]",""));
						records.put(facultyID,new Associate(name,age,address,phoneNumber,yearCameToChapman,facultyID,department,yearlySalary,numPapers,yearsSinceTenure));
					} else { // If the faculty is a Full Time Professor
						System.out.println("Enter the years until retirement");
						int yearsUntilRetirement = Integer.parseInt(scanner.nextLine().replaceAll("[^0-9]",""));
						records.put(facultyID,new Full(name,age,address,phoneNumber,yearCameToChapman,facultyID,department,yearlySalary,numPapers,yearsUntilRetirement));
					}
				} else if (option == 4 || option == 5){ // If the affiliate is a student
					System.out.println("Enter their student ID:");
					int studentID = Integer.parseInt(scanner.nextLine().replaceAll("[^0-9]",""));
					System.out.println("Enter their major:");
					String major = scanner.nextLine();
					System.out.println("Enter their minor:");
					String minor = scanner.nextLine();
					System.out.println("Enter their class standing:");
					String classStanding = scanner.nextLine();
					if(option == 4){ // If the student is a Grad student
						System.out.println("Enter the number of papers they published:");
						int numPapersPublished = Integer.parseInt(scanner.nextLine().replaceAll("[^0-9]",""));
						System.out.println("Enter their thesis advisor's name:");
						String thesisAdvisor = scanner.nextLine();
						records.put(studentID,new Graduate(name,age,address,phoneNumber,yearCameToChapman,studentID,major,minor,classStanding,numPapersPublished,thesisAdvisor));
					} else { // If the student is an Undergrad student
						System.out.println("Enter the number of courses they've taken:");
						int numCourses = Integer.parseInt(scanner.nextLine().replaceAll("[^0-9]",""));
						System.out.println("Enter their annual scholarship amount:");
						int scholarshipAmt = Integer.parseInt(scanner.nextLine().replaceAll("[^0-9]",""));
						records.put(studentID,new Undergrad(name,age,address,phoneNumber,yearCameToChapman,studentID,major,minor,classStanding,numCourses,scholarshipAmt));
					}
				} else { // If the student is a Staff member
					System.out.println("Enter their staff ID:");
					int staffID = Integer.parseInt(scanner.nextLine().replaceAll("[^0-9]",""));
					System.out.println("Enter their title:");
					String title = scanner.nextLine();
					System.out.println("Enter their building:");
					String building = scanner.nextLine();
					if(option == 6){ // If the staff member is full time
						System.out.println("Enter their yearly salary:");
						int yearlySalary = Integer.parseInt(scanner.nextLine().replaceAll("[^0-9]",""));
						records.put(staffID,new FullTime(name,age,address,phoneNumber,yearCameToChapman,staffID,title,building,yearlySalary));
					} else { // If the staff member is part time
						System.out.println("Enter their hourly salary:");
						double hourlySalary = Double.parseDouble(scanner.nextLine().replaceAll("[^\\d.]",""));
						records.put(staffID,new PartTime(name,age,address,phoneNumber,yearCameToChapman,staffID,title,building,hourlySalary));
					}
				}
			} else if(option == 8) { // exits the option otherwise
				System.out.println("Exiting...");
			}else {
				System.out.println("I'm sorry. You didn't select any valid number option");
			}
		} catch (InputMismatchException | NumberFormatException e){ // if a String was inputed when a numerical value was needed
			System.err.println("There was an error in the input");
		} catch (Exception e){
			System.err.println("I'm not sure what the error is, but there is an error"); // in case there is some other error unknown
		}
	}

	/**
	 * Option 2 - Print information of an Affiliate given an ID
	 * @param records a Hashmap of the affiliates keyed by their ID
	 */
	public static void optionTwo(HashMap<Integer, Affiliates> records) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter an Affiliate's ID to print their information from the database");
		System.out.println("Type -1 to cancel printing information");
		try{
			String s = scanner.nextLine();
      if(s.equals("-1")){ // exits if number is -1
				return;
			}
			s = s.replaceAll("[^0-9]",""); // replaces non numerical characters with empty string
			int keyID = Integer.parseInt(s);
      if (records.get(keyID) != null){ // if the affiliate with the ID exists
				records.get(keyID).print();
			} else {
				System.out.println("There was no Affiliate in the database with ID #" + keyID + ", so their information couldn't be printed.");
			}
		} catch (InputMismatchException | NumberFormatException e){ // if a String was inputed when a numerical value was needed
			System.err.println("There was an error in the input");
		} catch (Exception e){
			System.err.println("I'm not sure what the error is, but there is an error"); // in case there is some other error unknown
		}
	}

	/**
	 * Option 3 - Prints the list of Affiliates in order of Seniority (Most senior to least senior)
	 * @param records a Hashmap of the affiliates keyed by their ID
	 */
	public static void optionThree(HashMap<Integer, Affiliates> records){
		Collection<Affiliates> hashmapValues = records.values(); // puts the HashMap values in a collection
		ArrayList<Affiliates> affiliates = new ArrayList<Affiliates>(hashmapValues); // puts that collection into an Arraylist
		Collections.sort(affiliates); // sorts the arraylist from least senior to most senior (from the compareTo method)
		Collections.reverse(affiliates); // reverses the arraylist to be most senior to least senior instead
		for (Affiliates a: affiliates) { // prints all the Affiliates in the arraylist
			a.print();
		}
	}

	/**
	 * Option 4 - Delete an Affiliate from the database given their ID
	 * @param records a Hashmap of the affiliates keyed by their ID
	 */
	public static void optionFour(HashMap<Integer, Affiliates> records){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter an Affiliate's ID to remove from the database");
		System.out.println("Type -1 to cancel deleting an Affiliate from the database");
		try {
      String s = scanner.nextLine();
      if(s.equals("-1")){ // exits if number is -1
				return;
			}
			s = s.replaceAll("[^0-9]",""); // replaces non numerical characters with empty string
			int deletedID = Integer.parseInt(s);
			if (records.get(deletedID) != null){ // if the affiliate with the ID exists
				records.remove(deletedID);
				System.out.println("Successfully removed the Affiliate with ID #" + deletedID + " from the database.");
			} else {
				System.out.println("There was no Affiliate in the database with ID #" + deletedID + ", so it couldn't be deleted.");
			}
		} catch (InputMismatchException | NumberFormatException e){
			System.err.println("There was an error in the input"); // if a String was inputed when a numerical value was needed
		} catch (Exception e){
			System.err.println("I'm not sure what the error is, but there is an error"); // in case there is some other error unknown
		}
	}

	/**
	 * Saves the database of Affiliates to a text file
	 * @param records a Hashmap of the affiliates keyed by their ID
	 */
	public static void optionFive(HashMap<Integer, Affiliates> records){
		// The following 4 lines puts the HashMap of values into an ArrayList
		Collection<Affiliates> hashmapValues = records.values();
		ArrayList<Affiliates> affiliates = new ArrayList<Affiliates>(hashmapValues);
		Collections.sort(affiliates);
		Collections.reverse(affiliates);

		PrintWriter printWriter = null; // defines the PrintWriter

		try{
			Scanner scanner = new Scanner(System.in);
			System.out.println("What is the name of the file that you would like to write to?");
			String s = scanner.nextLine();
			if (s.indexOf('.') >= 1){ // converts the file name to a text file
				s = s.replace(s.substring(s.indexOf('.')),".txt");
			} else if (!s.equals("") && s.indexOf('.') < 0){
				s = s + ".txt";
			}
			while(s.equals("") || s.indexOf('.') == 0){ // makes the user enter a valid file name
				System.out.println("Please enter a valid file name:");
				s = scanner.nextLine();
				if (s.indexOf('.') >= 1){
					s = s.replace(s.substring(s.indexOf('.')),".txt");
				} else if (!s.equals("") && s.indexOf('.') < 0){
					s = s + ".txt";
				} else {
					s = "";
				}
			}

			printWriter = new PrintWriter(new FileWriter(s,false)); // writes to the file from the beginning of the file
			for (Affiliates a: affiliates) { // one line per affiliate
				printWriter.println(a); // uses the overridden toString() method in each class to write to the database
			}
		} catch (IOException e) {
			System.err.println("Error when writing to the file"); // If there is somehow an error when writing the contents to a file
		} catch (Exception e) {
			System.err.println("I'm not sure what the error is, but there is an error"); // in case there is some other error unknown
		} finally {
			printWriter.flush(); // pushes the text to the file
			printWriter.close(); // closes the printWriter
		}
	}

	/**
	 * Reads a file that has the database of all the affiliates
	 * @param records a Hashmap of the affiliates keyed by their ID
	 * @throws IOException an Exception if there is an input or output exception
	 */
	public static void optionSix(HashMap<Integer, Affiliates> records) throws IOException {
		// There is a sample database you can read from to test this out. The file name is SampleDatabase.txt

		BufferedReader bufferedReader = null; // defines the BufferedReader

		try{
			Scanner scanner = new Scanner(System.in);
			System.out.println("What is the name of the file that you would like to read from?");
			String s = scanner.nextLine(); // the file name to read from
			bufferedReader = new BufferedReader(new FileReader(s));
			String currentLine;
			while((currentLine = bufferedReader.readLine()) != null){ // While the line being read has content
				String classType = currentLine.substring(0,currentLine.indexOf(',')); // checks what the first attribute looks like
				if(classType.equals("Assistant")){ // if the first word of the line is "Assistant"
					Assistant.createInstance(records,currentLine); // uses createInstance method in Assistant class to create the instance from the line
				} else if(classType.equals("Associate")){ // if the first word of the line is "Associate"
					Associate.createInstance(records,currentLine); // uses createInstance method in Associate class to create the instance from the line
				} else if(classType.equals("Full")){ // if the first word of the line is "Full"
					Full.createInstance(records,currentLine); // uses createInstance method in Full class to create the instance from the line
				} else if(classType.equals("Undergrad")){ // if the first word of the line is "Undergrad"
					Undergrad.createInstance(records,currentLine); // uses createInstance method in Undergrad class to create the instance from the line
				} else if(classType.equals("Graduate")){ // if the first word of the line is "Graduate"
					Graduate.createInstance(records,currentLine); // uses createInstance method in Graduate class to create the instance from the line
				} else if(classType.equals("FullTime")){ // if the first word of the line is "FullTime"
					FullTime.createInstance(records,currentLine); // uses createInstance method in FullTime class to create the instance from the line
				} else if(classType.equals("PartTime")){ // if the first word of the line is "PartTime"
					PartTime.createInstance(records,currentLine); // uses createInstance method in PartTime class to create the instance from the line
				} else {
					continue; // if not any of those options, just continues
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("File was not found"); // in case the file with the inputed name doesn't exist
		} catch (IOException e) {
			System.err.println("Error when reading the file"); // in case there were problems with the contents of the file being read from
		} catch (Exception e) {
			System.err.println("I'm not sure what the error is, but there is an error"); // in case there is some other error unknown
		} finally {
			if (bufferedReader != null){ // if the bufferedReader isn't null, close it to stop reading
				bufferedReader.close();
			}
		}

	}

	/**
	 * Main method that starts the program
	 * @param args an array of strings passed in from the terminal input
	 * @throws IOException an Exception if there is an input or output exception
	 */
	public static void main(String[] args) throws IOException {
		HashMap<Integer, Affiliates> records = new HashMap<Integer, Affiliates>(); // Creates a HashMap of the Affiliate records
		Scanner scanner = new Scanner(System.in);
		printOptions(); // prints the menu item options
		String currOption = scanner.nextLine();

		while (!(currOption.equals("7") || currOption.equalsIgnoreCase("exit"))){ // if the user input is a "7" or "exit", exit the while loop
			if (currOption.equals("1")){ // calls the optionOne method if the input equals 1
				optionOne(records);
			} else if (currOption.equals("2")){ // calls the optionTwo method if the input equals 2
				optionTwo(records);
			} else if (currOption.equals("3")){ // calls the optionThree method if the input equals 3
				optionThree(records);
			} else if (currOption.equals("4")){ // calls the optionFour method if the input equals 4
				optionFour(records);
			} else if (currOption.equals("5")){ // calls the optionFive method if the input equals 5
				optionFive(records);
			} else if (currOption.equals("6")){ // calls the optionSix method if the input equals 6
				optionSix(records);
			} else { // asks for the user to enter a valid option otherwise
				System.out.println("Please enter a valid numerical value to activate one of the options");
			}
			printOptions(); // prints menu item options again
			currOption = scanner.nextLine(); // gets the user input again until while loop condition fails
		}
	}
}
