package Hotel_management;
import java.util.*;
class Drivers{
	String name,gender,age,car_company,car_brand,location;
	boolean available;
	public Drivers(String name,String age,String comp,String brand,String loc,boolean avail){  
        this.name=name;
        this.age=age;
        this.car_company=comp;
        this.car_brand=brand;
        this.location=loc;
        this.available=avail;
    } 
}
public class AddDrivers {
    Drivers d;
    static ArrayList<Drivers> driv=new ArrayList<>();
	void accept_Drivers()
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("NAME:");
		String name = sc.next();
		System.out.println("AGE:");
        String age = sc.next();
        System.out.println("CAR COMPANY:");
        String car_company = sc.next();
        System.out.println("CAR BRAND:");
        String car_brand = sc.next();
        System.out.println("LOCATION");
        String location = sc.next();
        System.out.println("AVAILABILITY(true/false):");
        boolean available =sc.nextBoolean();
        d=new Drivers(name,age,car_company,car_brand,location,available);
        driv.add(d);
        System.out.println("DRIVER ADDED SUCCESSFULLY!!!!\n\n");	}
	void display_Drivers()
	{
		System.out.printf("%-15s","NAME");
	    System.out.printf("%-10s","AGE");
	    System.out.printf("%-20s","CAR_COMPANY");
	    System.out.printf("%-20s","CAR_BRAND");
	    System.out.printf("%-20s","LOCATION");
	    System.out.printf("%-20s","AVAILABLE");
	    System.out.println("\n______________________________________________________________________________________________________________");
	    
	  for(int i=0;i<driv.size();i++) {
      	  System.out.printf("%-15s",driv.get(i).name);
      	  System.out.printf("|%-10s",driv.get(i).age);
      	  System.out.printf("|%-15s",driv.get(i).car_company);
      	  System.out.printf("|%-20s",driv.get(i).car_brand);
      	  System.out.printf("|%-20s",driv.get(i).location);
      	  System.out.printf("|%-20s",driv.get(i).available);

      	  System.out.println("\n______________________________________________________________________________________________________________");
      	  
      	  }

	}
	void display_Managers()
	{
	  System.out.println("NAME\t\t    AGE\t\t\tGENDER\t\t\tJOB\t\t\tSALARY\t\t PHONE\t\t\tAADHAR\t\t\t GMAIL");
         System.out.println("____________________________________________________________________________________________________________");  
         String name1="RAJ JAIN";
 	     String name2="KUNAL DEY";
         String age1= "25";
 	     String age2= "30";
         String Gender1="MALE";
         String Gender2="MALE";
         String Job1="Manager";
         String Job2="Manager";
         String Salary1="Rs.1,00,000";
         String Salary2="Rs.1,20,000";
         String Phone1="9987654321";
         String Phone2="1234567890";
         String Aadhar1="9988776655";
         String Aadhar2="1122334455";
         String Gmail1="Raj.jain@gmail.com";
         String Gmail2="kunal.dey@gmail.com"; 
	System.out.printf("%-20s",name1);
    System.out.printf("|%-20s",age1);
    System.out.printf("|%-20s",Gender1);
    System.out.printf("|%-20s",Job1);
    System.out.printf("|%-20s",Salary1);
    System.out.printf("|%-20s",Phone1);
    System.out.printf("|%-20s",Aadhar1);
    System.out.printf("|%-20s",Gmail1);
    System.out.println();
    System.out.printf("%-20s",name2);
    System.out.printf("|%-20s",age2);
    System.out.printf("|%-20s",Gender2);
    System.out.printf("|%-20s",Job2);
    System.out.printf("|%-20s",Salary2);
    System.out.printf("|%-20s",Phone2);
    System.out.printf("|%-20s",Aadhar2);
    System.out.printf("|%-20s",Gmail2);
    System.out.println("____________________________________________________________________________________________________________");  
  }
	public static void main(String[] args) {
		AddDrivers d=new AddDrivers();
		d.display_Managers();
		d.accept_Drivers();
		d.display_Drivers();
	}

}