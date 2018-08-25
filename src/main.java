import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class main {
	
	public static void main(String args[]) throws Exception, SQLException
	{
//		printAllPersons(sortByName(init()));
//	printJubilar(init());
//		firstLowRegister(init());
		pintOdnofamilcy(init());
	
//		wrightPersonToH2DB(init().get(5));
	//	DeletePersonByID(6);//("lastName", "Test", 6 );
//	printAllPersons(readFromH2DB());
//	updatePersonByID(1, "aaa", "dasd", "15", "44");
	
	}
	
	public static ArrayList<Person> sortByName(ArrayList<Person> pp)
	{
		
		
		for (int i = 0; i < pp.size(); i++) 
	       {
	           for (int j = 0; j < pp.size() - i - 1; j++)
	           {
	               if (pp.get(j).firstName.compareToIgnoreCase( pp.get(j+1).firstName) > 0 )
	               {
	                   String Buf = pp.get(j).firstName;
	                   pp.get(j).firstName = pp.get(j+1).firstName;
	                   pp.get(j+1).firstName = Buf;
	               }
	           }
	       }
		
			return pp;
	}
	
	public static ArrayList<Person> readFromH2DB() throws SQLException, ClassNotFoundException
	{
		ArrayList<Person> outDB = new ArrayList<>();
		
		Class.forName("org.h2.Driver");
		
		Connection conH2 = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
	
		Statement st = conH2.createStatement();
		
		ResultSet rs = st.executeQuery("SELECT * FROM PERSON");
		
		while (rs.next())
		{
			outDB.add( new Person
				  ( 
				  rs.getInt("ID"),
				  rs.getString(2),
				  rs.getString("lastName"),
				  rs.getInt("AGE")
				  )
				);
		  
		}
		
		return outDB;
	}
	public static void wrightPersonToH2DB( Person PersonToDB ) throws SQLException, ClassNotFoundException
	{

		
		Class.forName("org.h2.Driver");
		
		Connection conH2 = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
	
		Statement st = conH2.createStatement();
		
		ResultSet rs = st.executeQuery("SELECT * FROM PERSON");
		

			st.execute(
					"INSERT INTO PERSON VALUES( "
					+ String.valueOf(PersonToDB.id) + ", " 
					+ "' " +String.valueOf(PersonToDB.firstName) + "', " 
					+ "' " +String.valueOf(PersonToDB.lastName) + "', " 
					+ String.valueOf(PersonToDB.age) + " );"
					
					);
		  
		}
		
	
		public static void DeletePersonByID(int id) throws Exception
		{
			Class.forName("org.h2.Driver");
			
			Connection conH2 = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		
			Statement st = conH2.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM PERSON");
			
			//Добавить, удалить, обновить персону в БД
			
				st.execute(
						"DELETE FROM PERSON WHERE ID= "
						+ String.valueOf(id) + " ;"
						);
		}
		
		public static void changePersonFildByID(String Filde, String val, int id) throws Exception
		{
			Class.forName("org.h2.Driver");
			
			Connection conH2 = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		
			Statement st = conH2.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM PERSON");
			
			//Добавить, удалить, обновить персону в БД
			
				st.execute(
						"UPDATE PERSON SET " + Filde +
						"='" + val +"'" + 
						" WHERE ID="
						+ String.valueOf(id) + ";"
						);
		}
		
		public static void updatePersonByID(int id, String valFirstName, String valLastName, String valAGE, String valID) throws Exception
		{
			changePersonFildByID("firstName", valFirstName, id);
			changePersonFildByID("lastName", valLastName, id);
			changePersonFildByID("AGE", valAGE, id);
			changePersonFildByID("ID", valID, id);
		}
	
		public static ArrayList<Person> sortByAge(ArrayList<Person> pp)
		{
			for (int i = 0; i < pp.size(); i++) 
			{
	                 int Buf = pp.get(i).age;
	                 int j = i;
	                 while (j > 0 && Buf < pp.get(j-1).age)
	                 {
	                	 pp.get(j).age = pp.get(j-1).age;
	                     j--;
	                 }
	                 pp.get(j).age = Buf;
	             
			}
				return pp;
		}
		
	public static ArrayList<Person> sortById(ArrayList<Person> pp)
	{
		for (int i = 0; i < pp.size(); i++) 
		{
                 int Buf = pp.get(i).id;
                 int j = i;
                 while (j > 0 && Buf < pp.get(j-1).id)
                 {
                	 pp.get(j).id = pp.get(j-1).id;
                     j--;
                 }
                 pp.get(j).id = Buf;
             
		}
			return pp;
	}
	
	// сортировка своими ручками, при сортировки по имени усчест ь сравниени -1 0 1
		public static ArrayList<Person> init() 
		{
			ArrayList<Person> pp = new ArrayList<>();
			pp.add(new Person(1, "Tacha", "Hanan", 43));
            pp.add(new Person(2, "Zitan", "Litan", 55));
            pp.add(new Person(3, "Irako", "Mako", 32));
            pp.add(new Person(4, "Luda", "Marko", 15));
            pp.add(new Person(5, "Zahar", "Valik", 23));
            pp.add(new Person(6, "Murat", "Vharto", 43));
            pp.add(new Person(7, "Ignat", "Zaharko", 32));
            pp.add(new Person(8, "Marik", "Holiko", 21));
            pp.add(new Person(9, "Zhorik", "Zharov", 43));
            pp.add(new Person(10, "Osama", "Benladen", 32));
            pp.add(new Person(11, "Kopan", "Bayko", 43));
            pp.add(new Person(12, "Valik", "Valik", 2));
            pp.add(new Person(13, "Garik", "Guyko", 13));
            pp.add(new Person(14, "li", "", 89));
            pp.add(new Person(15, "Valik", "Valik", 3));
            pp.add(new Person(16, "Valik3", "oNik", 45));
            pp.add(new Person(17, "Valik1", "oHab", 4));
            pp.add(new Person(18, "Valik2", "nKjhghg", 3));
            pp.add(new Person(19, "Valik", "Valik", 18));
            pp.add(new Person(20, "Valik", "Valuev", 20));
            pp.add(new Person(21, "Valik", "Valuev", 20));
            pp.add(new Person(22, "Valik49", "Valuev", 20));
            pp.add(new Person(23, "palik", "Valuev", 20));
            pp.add(new Person(24, "Valik", "Valuev", 20));
            pp.add(new Person(25, "palik", "ialuev", 20));
            pp.add(new Person(26, "Valik", "Valuev", 20));
            pp.add(new Person(27, "Valik44", "VaDuev", 20));
            pp.add(new Person(28, "Jasd", "Kass",34 ));
            pp.add(new Person(29, "Nass", "Mass",32 ));
            pp.add(new Person(30, "Jas", "Hass", 21));
            pp.add(new Person(31, "Nass", "Lsd", 32));
            pp.add(new Person(32, "sliOn", "Damask", 32));
            pp.add(new Person(33, "Nxasd", "Mklasda", 12));
            pp.add(new Person(34, "Djklas", "Dsaasva", 32));
            pp.add(new Person(35, "Makar", "Makarov", 53));
            pp.add(new Person(36, "Ivan", "Ivanov", 5254));
            pp.add(new Person(37, "Максим", "Васнецов", 7));
            pp.add(new Person(38, "Ваня", "Даснецов", 9));
            pp.add(new Person(39, "Андрей", "Петровцев", 30));
            pp.add(new Person(40, "Василь", "Коровцев", 60));
            pp.add(new Person(41, "Инна", "Карп", 35));
            pp.add(new Person(42, "Инна", "Маркова", 24));
            pp.add(new Person(43, "Сергей", "Игнатов", 64));
            pp.add(new Person(44, "Максим", "Олейник", 2));
            pp.add(new Person(45, "Кришиано", "Роналдо", 2));
            pp.add(new Person(46, "Элвис", "Пресли", 4));
            pp.add(new Person(47, "Марк", "Савин", 6));
            pp.add(new Person(48, "Василий", "Кондратюк", 4));
            pp.add(new Person(49, "Игнат", "Завой", 3));
            pp.add(new Person(50, "Марина", "сАртова", 2));
            
        return pp;
		}		
			// вывести в консоль String compare to
	
		public static void printAllPersons ( ArrayList <Person> pp )
        {
            System.out.println("All Persons:");
            for(Person p:pp)
            {
                    System.out.println(p);
            }
        }

	    public static void print18To45 ( ArrayList <Person> pp )
	        {
	            System.out.println("Print20to45");
	            for(Person p:pp)
	            {
	                if (p.age >= 18 && p.age <= 45 )
	                {
	                    System.out.println(p);
	                }
	            }
	        }
	    
	    public static void printJubilar ( ArrayList <Person> pp )
        {
            System.out.println("Jubilary:");
            for(Person p:pp)
            {
                if (p.age % 10 == 0 )
                {
                    System.out.println(p);
                }
            }
        }
	    public static void printChetId ( ArrayList <Person> pp )
        {
            System.out.println("ChetId:");
            for(Person p:pp)
            {
                if (p.id % 2 == 0 )
                {
                    System.out.println(p);
                }
            }
        }
	    public static void printSortId ( ArrayList <Person> pp )
        {
            System.out.println("ChetId:");
            for(Person p:pp)
            {
//            	pp.sort(pp.id);
            	
                if (p.id % 2 == 0 )
                {
                    System.out.println(p);
                }
            }
        }
	    
	    public static void printNameEqual6 ( ArrayList <Person> pp )
        {
            System.out.println("ChetId:");
            for(Person p:pp)
            {
            	
                if (p.firstName.length()  == 6 )
                {
                    System.out.println(p);
                }
            }
        }
	    public static void printNameOrLastNameContaned_g ( ArrayList <Person> pp )
        {
            System.out.println("ChetId:");
            for(Person p:pp)
            {
            	
                if (p.firstName.contains("g") || p.lastName.contains("g") )
                {
                    System.out.println(p);
                }
            }
        }
	    public static void printLastNameEndsWith_ko ( ArrayList <Person> pp )
        {
            System.out.println("ChetId:");
            for(Person p:pp)
            {
                if (p.lastName.endsWith("ko") )
                {
                    System.out.println(p);
                }
            }
        }

	    public static void pintOdnofamilcy(ArrayList<Person> pp)
	    {
	    	System.out.println("Odnofamilcy:");
	    	for (Person p: pp)
	    	{
	    		for(Person k : pp) {
	    			if (p.lastName.equals(k.lastName) & p.id != k.id)
	    			{
	    				System.out.println(k);
	    			}
	    		}
	    	}
	    }
	        

	        
	        public static void firstLowRegister(ArrayList<Person> pp)
	        {
	            System.out.println("lowerRegister");
	            
	            for (Person p : pp)
	            {
	                if ( 
	                  p.firstName.substring(0,1).equals(p.firstName.substring(0,1).toLowerCase()) ||
	                  p.lastName.substring(0,1).equals(p.lastName.substring(0,1).toLowerCase())
	                    )
	                {
	                    System.out.println(p);
	                }
	            }
	        }

	        
	
}

