package studentDatabase;
import java.util.*;

public class Student extends Person implements Payment{
	
	private Major major;
	private double gpa;
	private int nStudents;
	//private ArrayList<Student> students;
	private Student[] students;
	private double tuitionFees;
	private String licenseKey;
	// new java.util.Date(System.currentTimeMillis()
	
	public Student(String lastName, String firstName, int age, char gender, Date joinDate) {
		super(lastName, firstName, age, gender, joinDate);
		}
	public Student (int max) 
	{
		super();
		students = new Student[max];
		nStudents = 0;
	}
	
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	public void setArraySize(int maxSize) {
		students = new Student[maxSize];
	}
	
	//Insert method
	public void insertPerson(String lastName, String firstName, int age, char gender, Date joinDate, String m) {
		students[nStudents] = new Student(lastName, firstName, age, gender, joinDate);
		students[nStudents].major = findMajor(m);
		students[nStudents].setPayment();
		nStudents++;		
	}
	//findMajor
	public Major findMajor(String m) {
		if (m.equals("Arts")) 
			return Major.Arts;
		else if (m.equals("Architecture"))
				return Major.Architecture;
		else if (m.equals("Business"))
				return Major.Business;
		else if (m.equals("Engineering"))
			return Major.Engineering;
		else if (m.equals("Computers"))
			return Major.Computer_Science;
			
		return Major.Engineering;
	}
	//Singletion class 
	
	//Payment
	public void setPayment() {
		switch (major) {
		case Arts:
			tuitionFees = 8000;
			licenseKey = "";
			break;
		case Computer_Science:
			tuitionFees = 10000;
			LicenseKey instance1 = LicenseKey.getInstance();
			licenseKey = instance1.licenseKey;
			break;
		case Engineering:
			tuitionFees = 9000;
			licenseKey = "";
			break;
		case Architecture:
			tuitionFees = 9500;
			licenseKey = "";
			break;
		case Business:
			tuitionFees = 8500;
			licenseKey = "";
			break;
		}
	}	
	
	//Search for a student
	public String getLast() { return super.getlastName();}
	public Student find(String searchName)
	{
		int j;
		for (j = 0; j < nStudents; j++) {
			if (students[j].getLast().equals(searchName))
				break;}
		if (j == nStudents)
			return null;
		else
			return students[j];
	}
	//Delete a student record
	public boolean delete(String searchName)
	{
		int j;
		for (j = 0; j < nStudents; j++)
			if (students[j].getLast().equals(searchName))
				break;
		if (j == nStudents)
			return false;
		else {
			for (int k = j; k < nStudents; k++)
				students[k] = students[k+1];
			nStudents--;
			return true;
		}
	}
	public void displayAll() {
		for (int j = 0; j < nStudents; j++)
			System.out.println(students[j]);
	}
	
	public String toString() {
		if (licenseKey.isEmpty())
			return "Name: " + super.getName() +" ,StudentID: " + super.getId() + ", Major: " + major + " ,Tuition: " +  tuitionFees;
		else
			return "Name: " + super.getName() +" ,StudentID: " + super.getId() + ", Major: " + major + " , License Key: " + licenseKey +" ,Tuition: " +  tuitionFees;
	}
	
}

