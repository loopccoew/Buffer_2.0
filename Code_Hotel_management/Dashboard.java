package Hotel_management;
import java.util.Scanner;
public class Dashboard {

	public void display() {
		// TODO Auto-generated method stub
		AddEmployee e=new AddEmployee();
		Scanner sc=new Scanner(System.in);
		int opt;
	   System.out.println("\n~~~~~~~~~~~~~WELCOME TO EVERGREEN RESORT~~~~~~~~~~~~~~\n");
	   System.out.println("1.RECEPTION\t\t\t2.ADMIN\t\t\t3.BACK");
	   opt=sc.nextInt();
	   do {
	   switch(opt)
	   {
	   case 2:
	       System.out.println("\n~~~~~~~~ADMIN\n");
	       System.out.println("1.ADD EMPLOYEE");
	       System.out.println("2.ADD ROOMS");
	       System.out.println("3.ADD DRIVERS");
	       System.out.println("4.EXIT");
	       System.out.println("Enter your choice");
	       opt=sc.nextInt();
	       switch(opt)
	       {
	       case 1:e.accept_Employees();
	       System.out.println();
	       new Dashboard().display();
	             break;
	       case 2:new AddRoom().Add_Rooms();
	       System.out.println();
	       new Dashboard().display(); 
	    	   break;
	       case 3:new AddDrivers().accept_Drivers();
	              new AddDrivers().display_Drivers();
	   	       System.out.println();
	              new Dashboard().display();
	    	   break;
	       case 4:new Dashboard().display();
	       }
	       break;
	   case 1:
		   System.out.println("\n~~~~~~~RECEPTION~~~~~~~\n\n1.NEW CUSTOMER FORM\n2.ALL EMPLOYEE INFO\n3.CUSTOMER INFO"); 
           System.out.println("4.MANAGER INFO\n5.CHECK OUT\n6.EXIT");
           opt=sc.nextInt();
           switch(opt)
           {
             case 1:new Add_Customer().accept_Customer();
  	         System.out.println();
             new Dashboard().display();
    		   break;
             case 2:e.display_Employees();
  	         System.out.println();
             new Dashboard().display();
                 break;
             case 3:new Add_Customer().display_Customer();
  	         System.out.println();
             new Dashboard().display();
                 break;
             case 4:new AddDrivers().display_Managers();
  	         System.out.println();
             new Dashboard().display();
            	 break;
             case 5:new Add_Customer().Check_out();
  	         System.out.println();
             new Dashboard().display();
            	 break;
             case 6:new Dashboard().display();
            	 break;
           }
		   
	   }
	   }while(opt!=3);
		
	}

}
