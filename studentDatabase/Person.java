package studentDatabase;
import java.util.Date;

public abstract class Person {
	private String lastName;
	private String firstName;
	private int age;
	private char gender;
	private String id;
	private static int nextId = 1;
	private Date joiningDate;
	private String searchKey;
	//Inner class
	private class CreateID {
		public void generateID() {
			final String universityAbbreviation = "UN";
			id = String.format("%07d", nextId);
			id = universityAbbreviation + id;
			nextId++;
		}
	}
	//Constructor
	public Person() {}
	public Person(String lastName, String firstName, int age, char gender, Date joinDate) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.age = age;
		this.gender = gender;
		joiningDate = joinDate;
		setId();
	}
	//Abstract methods
	//public abstract void displayPerson();
	//public abstract void deletePerson();
	public abstract Person find(String searchKey);
	public abstract void displayAll();
	
	public void setId()
	{
		CreateID setID = new CreateID();
		setID.generateID();
	}
	
	public String getlastName()
	{
		return lastName;
	}
	public String getName() {
		return firstName + " " + lastName;
	}
	public Date getJoiningDate()
	{
		return joiningDate;
	}
	public String getId()
	{
		return id;
	}
}
