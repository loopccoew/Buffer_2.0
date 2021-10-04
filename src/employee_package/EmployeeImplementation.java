package employee_package;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Pattern;
import linkedlist_package.LinkedList;
import linkedlist_package.Node;
public class EmployeeImplementation 
{
	public LinkedList ll = new LinkedList();
	public void addEmployee(Scanner sc)
	{
		Employee emp=new Employee();
		this.acceptEmployeeDetails(emp,sc);
		this.checkIfAlreadyPesent(emp);
		//System.out.println("Executing");
	}
	private void acceptEmployeeDetails(Employee emp,Scanner sc)
	{
		String temp;
		//System.out.println("Enter Employee Id");
		//e_id=sc.nextInt();
		boolean bool=true;
		System.out.println("Enter Employee Name");
		sc.nextLine();
		do {
			bool=false;
			String name=sc.nextLine();
			if(name.isBlank())
				System.out.println("Please Enter Appropriate Employee Name");
			else
			{
				emp.setE_name(name);
				bool=true;

			}
		}while(bool==false);
		System.out.println("Enter Employee Contact Number");
		bool = true;
		do
		{
			bool=false;
			String contactNo=sc.nextLine();
			if(contactNo.isBlank())
			{
				bool=false;
			}
			else//when alphabets are entered
			{
				bool=Pattern.matches("[6789]{1}[0-9]{9}",contactNo);
				if(bool)
				{
					bool=true;
					emp.setE_contact_no(contactNo);//contact number starts with 6,7,8,9 and have 10 digits
				}
				else
				{
					bool=false;
				}
			}
			if(bool==false)
			{
				System.out.println("Please Enter Appropriate Contact Number!!!");
			}

		}while(bool==false);
		//sc.nextLine();
		System.out.println("Enter Employee Role");
		do {
			bool=false;
			String role=sc.nextLine();
			if(role.isBlank())
				System.out.println("Please Enter Appropriate Employee Role");
			else
			{
				emp.setE_role(role);
				bool=true;

			}
		}while(bool==false);
		System.out.println("Enter Employee Salary");
		do {
			bool=false;
			bool=sc.hasNextDouble();
			if(bool)
			{
				emp.setE_salary(sc.nextDouble());
				if(emp.getE_salary()>0)
				{
					//System.out.println(emp.getE_salary());
					bool=true;
				}
				else
					bool=false;

			}
			else
			{
				temp=sc.next();
			}
			if(bool==false)
				System.out.println("Please Enter Appropriate Salary");
		}
		while(bool==false);
		sc.nextLine();
		System.out.println("Enter Employee Address");
		do {
			bool=false;
			String add=sc.nextLine();
			if(add.isBlank())
				System.out.println("Please Enter Appropriate Address");
			else
			{
				emp.setE_address(add);
				bool=true;

			}
		}
		while(bool==false);

		System.out.println("Enter Employee e-mail address");
		bool=true;
		do
		{
			bool=false;
			bool=sc.hasNext("[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +"(?:[a-zA-Z0-9-]+\\.)+[a-z" +"A-Z]{2,7}$");

			if(bool)
			{
				emp.setE_email(sc.next());
				bool=true;
			}
			else
			{
				temp=sc.next();
				System.out.println("Please enter a valid Email address");
			}

		}while(!bool);

	}
	public void displayEmployeeDetails(Employee em)
	{

		System.out.format("%-30d %-30s %-30s %-30s %-30f %-40s %-30s",em.getE_id(),em.getE_name(),em.getE_role(),em.getE_contact_no(),em.getE_salary(),em.getE_address(),em.getE_email());
		System.out.println();
	}
	public void checkIfAlreadyPesent(Employee emp)
	{
		int flag = 0;//turns 1 if an employee is found
		Node temp = ll.getHead();
		//	System.out.println("temp is"+temp);
		while(temp!=null)
		{	
			Employee etemp = (Employee)temp.getData();
			if(emp.getE_contact_no().equals(etemp.getE_contact_no()))
			{
				flag = 1;
				//System.out.println(flag);

			}
			if(flag==1)
			{
				temp = null;//loop termination
			}
			else
			{
				temp = temp.getNext();
			}
		}
		if(flag==0)//no match was found
		{
			int id = Employee.getIDgenerator();
			//System.out.println(id );
			id++;
			Employee.setIDgenerator(id);
			emp.setE_id(id);
			ll.insertLast(emp);

		}
	}

	public void deleteEmployee(Scanner sc)
	{
		int id = 0;
		Boolean bool = true;
		System.out.println("Enter the employee ID for the employee to be deleted");
		do
		{
			bool = sc.hasNextInt();
			if(bool)
			{
				id = sc.nextInt();
			}
			else
			{
				String s =  sc.next();
				System.out.println("Please enter a valid ID");
			}

		}while(!bool);

		Node result=searchEmployeeBasedOnID(id);
		ll.deleteNode(result);
	}
	public Node searchEmployeeBasedOnID(int id)
	{
		Node result=null;

		if(ll.getHead()==null)
		{
			System.out.println("Empty list. Cannot search");
		}
		else
		{

			Node temp = ll.getHead();
			while(temp!=null)  //traverse till the end
			{
				if((((Employee)temp.getData()).getE_id())==id)
				{
					result=temp;
				}
				temp = temp.getNext();
			}
		}
		return result;

	}


	public void displayList()
	{
		if(ll.getHead()==null)
		{
			System.out.println("Empty list");
		}
		else
		{
			Node temp = ll.getHead();
			System.out.println("********************************************************************************************************************************************************************************************************************************************************");
			System.out.printf("%-30s %-30s %-30s %-30s %-30s %-40s %-30s","EMPLOYEE_ID","EMPLOYEE_NAME","EMPLOYEE_ROLE","EMPLOYEE_CONTACT_NUMBER","EMPLOYEE_SALARY","EMPLOYEE_ADDRESS","EMPLOYEE_EMAIL_ADRESS");
			System.out.println();
			System.out.println("********************************************************************************************************************************************************************************************************************************************************");
			while(temp!=null)  //traverse till the end
			{
				this.displayEmployeeDetails((Employee)temp.getData());
				temp = temp.getNext();
			}
			System.out.println("********************************************************************************************************************************************************************************************************************************************************");

		}
	}
	public void searchEmployee(Scanner sc)
	{
		boolean result = false;
		int id = 0;
		int flag=0;
		if(ll.getHead()==null)
		{
			System.out.println("Empty list. Cannot search");
		}
		else
		{
			System.out.println("Enter the Employee ID that has to be searched");
			id = sc.nextInt();
			Node temp = ll.getHead();
			while(temp!=null)  //traverse till the end
			{
				if((((Employee)temp.getData()).getE_id())==id)
				{

					if(flag==0)
					{
						System.out.format("%-30s %-30s %-30s %-30s %-30s %-40s %-30s","Employee Id","Employee Name","Employee Role","Employee Contact No.","Employee Salary","Employee Address","Employee Email Id");
						System.out.println();
						flag=1;
					}
					this.displayEmployeeDetails((Employee)temp.getData());
					result = true;//employee found
				}
				temp = temp.getNext();
			}
		}
		if(result==false)
		{
			System.out.println("The employee could not be found");
		}

	}
	public void addToDatabase()
	{
		Connection con ;
		Statement st;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","root");
			st=con.createStatement();
			st.executeUpdate("delete from empdata");
			Node temp=ll.getHead();
			while(temp!=null)
			{
				Employee e = (Employee) temp.getData();

				st.executeUpdate("insert into empdata(ID,NAME,CONTACT,ROLE,SALARY,ADDRESS,EMAILID)values("+e.getE_id()+",'"+e.getE_name()+"','"+e.getE_contact_no()+"','"+e.getE_role()+"',"+e.getE_salary()+",'"+e.getE_address()+"','"+e.getE_email()+"')");
				temp=temp.getNext();
			}
			st.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void retrieveFromDataBase()
	{
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		//LinkedList ll=new LinkedList();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","root");
			st=con.createStatement();
			rs=st.executeQuery("select * from empdata");
			//System.out.println("rs is"+rs.next());
			while(rs.next())
			{

				Employee em=new Employee();
				//System.out.println("em");
				em.setE_id(rs.getInt(1));
				em.setE_name(rs.getString(2));
				em.setE_contact_no(rs.getString(3));
				em.setE_role(rs.getString(4));
				em.setE_salary(rs.getDouble(5));
				em.setE_address(rs.getString(6));
				em.setE_email(rs.getString(7));
				ll.insertLast(em);

				Employee.setIDgenerator(em.getE_id());
			}
			rs.close();
			st.close();
			con.close();
		}
		catch(Exception e)
		{
			//System.out.println("Exception is being thrown from retrieve database");
			System.out.println(e);
		}
	}

	public void searchEmployeeOnBasisOfRole(Scanner sc)
	{ 
		boolean result =false;
		String temprole;
		boolean bool=true;
		int flag=0;
		if(ll.getHead()==null) {
			System.out.println("Empty list. Cannot search"); } 
		else
		{ 

			System.out.println("Enter Employee Role");
			sc.nextLine();
			do {
				bool=false;
				temprole=sc.nextLine();
				if(temprole.isBlank())
					System.out.println("Please Enter Appropriate Employee Role");
				else
				{

					bool=true;

				}
			}while(bool==false);

			Node temp = ll.getHead();
			while(temp!=null)
			{
				if((((Employee)temp.getData()).getE_role().equals(temprole)))
				{ 
					if(flag==0)
					{
						System.out.format("%-30s %-30s %-30s %-30s %-30s %-40s %-30s","Employee Id","Employee Name","Employee Role","Employee Contact No.","Employee Salary","Employee Address","Employee Email Id");
						System.out.println();

						flag=1;
					}
					this.displayEmployeeDetails((Employee)temp.getData());

					result = true;//employee found
				}
				temp = temp.getNext();
			}
		}
		if(result==false)
		{
			System.out.println("There is no employee undder this role"); 
		}
	}


	public void higest_salary()
	{
		boolean result =false;
		double maximum=0;
		double maxi=0;
		if(ll.getHead()==null) {
			System.out.println("Empty list. Cannot search"); } 
		else {
			Node temp = ll.getHead();
			Node after=temp.getNext();
			while(after!=null)
			{
				maxi=Double.max(((Employee)temp.getData()).getE_salary(),((Employee)after.getData()).getE_salary());
				maximum=Double.max(maximum,maxi);
				temp=temp.getNext();
				after=after.getNext();
			}
			System.out.println("Highest Salary of the employee is "+maximum);
		}
	}
}
