package Hotel_management;


import java.util.*;
class Employees{
	String name,age,salary,phone,aadhar,email,gender;
    public Employees(String name,String age,String s,String p,String a,String e,String gender){  
        this.name=name;
        this.age=age;
        this.salary=s;
        this.phone=p;
        this.aadhar=a;
        this.email=e;
        this.gender=gender;
    }   
}
public class AddEmployee {
    Employees e;
    static ArrayList<Employees> emp=new ArrayList<>();
    
	public void accept_Employees()
	{
		if(emp.size()==0) {
            emp.add(0,new Employees("Lily","34","25000","6758456798","134566577465","lily@gmail.com","F"));
		    emp.add(1,new Employees("Ron","23","670000","6753243598","989343875435","ron@gmail.com","M"));
	        emp.add(2,new Employees("Harry","56","805000","2748385457","909566577465","harry@gmail.com","M"));
	        emp.add(3,new Employees("Pearl","24","125000","9058456788","774566577488","pearl@gmail.com","F"));
	        emp.add(4,new Employees("Serah","33","29000","8756556790","564566577488","searh@gmail.com","F"));
		}
		Scanner sc=new Scanner(System.in);
		String gender = null;
		System.out.println("NAME:");
		String name = sc.next();
		System.out.println("AGE:");
        String age = sc.next();
        System.out.println("SALARY:");
        String salary = sc.next();
        System.out.println("PHONE:");
        String phone = sc.next();
        if(phone.length()!=10) {
        	System.out.println("ENTER A VALID 10 DIGIT NUMBER!!!");
        	new Dashboard().display();
        }
        System.out.println("AADHAR:");
        String aadhar = sc.next();
        if(aadhar.length()!=12) {
        	System.out.println("ENTER A VALID 12 DIGIT NUMBER!!!");
        	new Dashboard().display();
        }
        System.out.println("EMAIL:");
        String email = sc.next();
        System.out.println("GENDER(F/M):");
        gender=sc.next();
        e=new Employees(name,age,salary,phone,aadhar,email,gender);
        emp.add(e);
        System.out.println("---EMPLOYEE ADDED SUCCESSFULLY");
	}
	public void display_Employees()
	{
		if(emp.size()==0) {
            emp.add(0,new Employees("Lily","34","25000","6758456798","134566577465","lily@gmail.com","F"));
		    emp.add(1,new Employees("Ron","23","670000","6753243598","989343875435","ron@gmail.com","M"));
	        emp.add(2,new Employees("Harry","56","805000","2748385457","909566577465","harry@gmail.com","M"));
	        emp.add(3,new Employees("Pearl","24","125000","9058456788","774566577488","pearl@gmail.com","F"));
	        emp.add(4,new Employees("Serah","33","29000","8756556790","564566577488","searh@gmail.com","F"));
		}
            System.out.printf("%-15s","NAME");
    	    System.out.printf("%-10s","AGE");
    	    System.out.printf("%-20s","SALARY");
    	    System.out.printf("%-20s","PHONE");
    	    System.out.printf("%-20s","AADHAR");
    	    System.out.printf("%-20s","EMAIL");
    	    System.out.printf("%-20s","AGE");
    	    System.out.println("\n______________________________________________________________________________________________________________");
    	    
	        for(int i=0;i<emp.size();i++) {
	      	  System.out.printf("%-15s",emp.get(i).name);
	      	  System.out.printf("|%-10s",emp.get(i).age);
	      	  System.out.printf("|%-15s",emp.get(i).salary);
	      	  System.out.printf("|%-20s",emp.get(i).phone);
	      	  System.out.printf("|%-20s",emp.get(i).aadhar);
	      	  System.out.printf("|%-20s",emp.get(i).email);
	      	  System.out.printf("|%-20s",emp.get(i).gender);

	      	  System.out.println("\n______________________________________________________________________________________________________________");
	      	  
	      	  }
	}
	public static void main(String[] args) {
		AddEmployee e=new AddEmployee();
		e.display_Employees();
	}

}
