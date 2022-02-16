package study;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class movies {

	public static void main(String[] args) throws Exception 
	{
		createTable();
		insert();
		out();

	}
	public static void createTable() throws Exception
	{
		try 
		{
			String driver ="com.mysql.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/db";
			String username="root";
			String password="asdf";
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,username,password);
			System.out.println("connected");
			PreparedStatement create=con.prepareStatement("create table movies(name varchar(20),leadActor varchar(20),leadActress varchar(20),director varchar(20),yearOfRelease int)");
			create.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			System.out.println("table created");
		}
		
	}
	public static void insert() throws Exception
	{
		try 
		{
			String driver ="com.mysql.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/db";
			String username="root";
			String password="asdf";
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,username,password);
			PreparedStatement c0=con.prepareStatement("insert into movies values('Fight club','Brad pitt','Helena carter','David fincher',1999)");
			c0.executeUpdate();
			PreparedStatement c1=con.prepareStatement("insert into movies values('Inception','Dicaprio','marion cotilard','Nolan',2010)");
			c1.executeUpdate();
			PreparedStatement c2=con.prepareStatement("insert into movies values('The dark knight','Bale','Maggie','Nolan',2008)");
			c2.executeUpdate();
			PreparedStatement c3=con.prepareStatement("insert into movies values('Guppy','tovino','Nandhana','George',2016)");
			c3.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			System.out.println("values inserted");
		}
		
	}
	public static void out() throws Exception
	{
		try
		{
			String driver ="com.mysql.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/db";
			String username="root";
			String password="asdf";
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,username,password);
			PreparedStatement out=con.prepareStatement("select * from movies");
			ResultSet result=out.executeQuery();
			System.out.println("");
			System.out.println("<movies>");
			while(result.next())
			{
				System.out.println("");
				System.out.print(result.getString(1));
				System.out.print("   ");
				System.out.print(result.getString(2));
				System.out.print("   ");
				System.out.print(result.getString(3));
				System.out.print("   ");
				System.out.print(result.getString(4));
				System.out.print("   ");
				System.out.print(result.getString(5));
				System.out.println("   ");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			
			System.out.println("\nvalues displayed");
		}
		
	}

}
 