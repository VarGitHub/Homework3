package studentDatabase;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class StudentApp {
	
	public static void main(String[] args) throws IOException {
		int maxSize = 100;
		Student students;
		students = new Student(maxSize);
		BufferedReader reader = new BufferedReader(new FileReader("/Users/varija/Documents/Selenium/HomeWork-3/src/input"));
		
		while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            // Split line on comma.
            String[] parts = line.split(",");
            for (int p = 0; p < 1; p++) {
            	students.insertPerson(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3].charAt(0), new java.util.Date(System.currentTimeMillis()), parts[4]);}
        }
		students.insertPerson("Mark", "Another", 12, 'M', new java.util.Date(System.currentTimeMillis()), "Computers");
		students.insertPerson("Sullivan", "Mark", 24, 'M', new java.util.Date(System.currentTimeMillis()), "Business");
		students.displayAll();	
		
		String searchKey = "Berry";
		Student found;
		found = students.find(searchKey);
		if (found != null)
		{
			System.out.print("Found ");
			System.out.println(found);
		}
		else
			System.out.println("Can't find " + searchKey);
		System.out.println("Deleting ... Sullivan");
		students.delete("Sullivan");
		students.displayAll();
	}
}

