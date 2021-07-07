package Hotel_management;
import java.util.ArrayList;
import java.util.Scanner;

class Conn{
    String name;
    String password;
    public Conn(String name,String password){  
        this.name=name;
        this.password=password;
}  
}
public class Login {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
     System.out.println("\n\t\t\t~~~~~~~  EVERGREEN RESORT  ~~~~~~~\n\n");

 	ArrayList<Conn> c=new ArrayList<Conn>();
 	int flag=0;
 	do {
 		System.out.println("=======================================================================================\n");
 	System.out.print("Username:");
 	String username=sc.next();
 	System.out.print("\nPassword:");
 	String password=sc.next();
 	Conn c1=new Conn("Yukta","1234");
 	Conn c2=new Conn("Siddhi","1235");
 	Conn c3=new Conn("Sanika","1236");
 	Conn c4=new Conn("Snehal","1237");
 	c.add(c1);
 	c.add(c2);
 	c.add(c3);
 	c.add(c4);
 	for(Conn con:c) {
    	if(con.password.compareTo(password)==0 && con.name.compareTo(username)==0) {
    	 System.out.println("LOGIN SUCCESSFULL!!!!!!!");
    	 System.out.println();
    	 flag=1;
    	 new Dashboard().display();
    	}
 	}if(flag!=1) {
    		System.out.println("INCORRECT USERNAME/PASSWORD");
    	}
 	}while(flag!=1);
 }
}

