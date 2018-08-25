import java.util.ArrayList;

public class Person 
{
	 int id;
	 String firstName;
	 String lastName;
	 int age;
	
	public Person(int id, String firstName, String lastName, int age)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	@Override
	public String toString() {
	
		String out = new String();
		out += Integer.toString(id)+ ", " +
				firstName + ", " +
				lastName + ", " +
				Integer.toString(age);
		
		return out;
	}
	
}
