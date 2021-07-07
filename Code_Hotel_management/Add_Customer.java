package Hotel_management;
import java.util.ArrayList;
import java.util.Scanner;

class Customer{
	String name,age,phone,aadhar,email,gender;
    public Customer(String name,String age,String p,String a,String e,String gender){  
        this.name=name;
        this.age=age;
        this.phone=p;
        this.aadhar=a;
        this.email=e;
        this.gender=gender;
    } 
}

public class Add_Customer {
    Customer c;
    static ArrayList<Customer> cust=new ArrayList<>();
	Scanner sc=new Scanner(System.in);
    
	void accept_Customer()
	{
		if(cust.size()==0) {
            cust.add(0,new Customer("Lily","34","6758456798","134566577465","lily@gmail.com","F"));
		    cust.add(1,new Customer("Ron","23","6753243598","989343875435","ron@gmail.com","M"));
	        cust.add(2,new Customer("Harry","56","2748385457","909566577465","harry@gmail.com","M"));
	        cust.add(3,new Customer("Pearl","24","9058456788","774566577488","pearl@gmail.com","F"));
	        cust.add(4,new Customer("Serah","33","8756556790","564566577488","searh@gmail.com","F"));
		}
		String gender = null;
		System.out.println("NAME:");
		String name = sc.next();
		System.out.println("\nAGE:");
        String age = sc.next();
        System.out.println("\nPHONE:");
        String phone = sc.next();
        if(phone.length()!=10) {
        	System.out.println("ENTER A VALID 10 DIGIT NUMBER!!!");
        	new Dashboard().display();
        }
        System.out.println("\nAADHAR:");
        String aadhar = sc.next();
        if(aadhar.length()!=12) {
        	System.out.println("ENTER A VALID 12 DIGIT NUMBER!!!");
        	new Dashboard().display();
        }
        System.out.println("\nEMAIL:");
        String email = sc.next();
        System.out.println("\nGENDER:");
        gender=sc.next();
        c=new Customer(name,age,phone,aadhar,email,gender);
        cust.add(c);
        System.out.println("CUSTOMER ADDED SUCCESSFULLY!!!\n\n");
	}
	void display_Customer()
	{
		if(cust.size()==0) {
            cust.add(0,new Customer("Ken","34","6758456798","134566577465","ken@gmail.com","F"));
		    cust.add(1,new Customer("Ronald","23","6753243598","989343875435","ronald@gmail.com","M"));
	        cust.add(2,new Customer("Henry","56","2748385457","909566577465","henry@gmail.com","M"));
	        cust.add(3,new Customer("Terry","24","9058456788","774566577488","terry@gmail.com","F"));
	        cust.add(4,new Customer("David","33","8756556790","564566577488","david@gmail.com","F"));
		}
            System.out.printf("%-15s","NAME");
    	    System.out.printf("%-10s","AGE");
    	    System.out.printf("%-20s","PHONE");
    	    System.out.printf("%-20s","AADHAR");
    	    System.out.printf("%-20s","EMAIL");
    	    System.out.printf("%-20s","AGE");
    	    System.out.println("\n______________________________________________________________________________________________________________");
    	    
    	    for(int i=0;i<cust.size();i++) {
  	      	  System.out.printf("%-15s",cust.get(i).name);
  	      	  System.out.printf("|%-10s",cust.get(i).age);
  	      	  System.out.printf("|%-20s",cust.get(i).phone);
  	      	  System.out.printf("|%-20s",cust.get(i).aadhar);
  	      	  System.out.printf("|%-20s",cust.get(i).email);
  	      	  System.out.printf("|%-20s",cust.get(i).gender);

  	      	  System.out.println("\n______________________________________________________________________________________________________________");
  	      	  
  	      	  }
	}
	void Check_out() {
		String room_no;
		System.out.println("Customer's name:");
		String name=sc.next();
        System.out.println("Room number");
		room_no=sc.next();
		for(int i=0;i<cust.size();i++) 
		  {
		     if((cust.get(i).name).compareTo(name)==0) {
		       cust.remove(i); 
		     }
		  }
	}
	public static void main(String[] args) {
		Add_Customer c=new Add_Customer();
		c.accept_Customer();
		c.display_Customer();
	}

}