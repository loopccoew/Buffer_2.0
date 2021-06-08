package Hotel_management;
import java.util.ArrayList;
import java.util.Scanner;

public class UpdateRoom {
	int num;
	int ch;
	int x;
	String ava;
	String sta;
	int p;
	String typ="";
	Dashboard d = new Dashboard();
	static ArrayList<Room> r =new ArrayList<Room>();
	public void addRoom(Room r1)
	{
		r.add(r1);
	}
	public void update()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the room number that is to be updated");
		num=sc.nextInt();
		for (Room room : r) {
			if(room.getroomnum()==num)
			{
				
				do {
					System.out.println("Enter the field that is to be updated");
					System.out.println("ENTER 1.AVAILABILITY");
					System.out.println("ENTER 2.STATUS");
					System.out.println("ENTER 3.PRICE");
					System.out.println("ENTER 4.TYPE");
					System.out.println("ENTER 0.EXIT");
					ch=sc.nextInt();
					
				switch(ch)
				{
				case 1: System.out.println("Enter the availability status of the room : ");
						System.out.println("1:available\t2.unavailable");
						x=sc.nextInt();
						if(x==1)
						{
							ava="available";
						}
						else
						{
							ava="unavailable";
						}
						room.setava(ava);
						break;
				case 2: System.out.println("Enter the status of the room : ");
						System.out.println("1:cleaned\t2.uncleaned");
						x=sc.nextInt();
						if(x==1)
						{
							sta="cleaned";
						}
						else
						{
							sta="uncleaned";
						}
						room.setstatus(sta);
						break;
				case 3: System.out.println("Enter the price of the room : ");
						x=sc.nextInt();
						
						room.setprice(x);
						break;
				case 4: System.out.println("Enter the type of the room : ");
						System.out.println("1:Double bed\t2.Single bed");
						x=sc.nextInt();
						if(x==1)
						{
							typ="Double bed";
						}
						else
						{
							typ="Single bed";
						}
						room.settype(typ);
						break;
				case 0: 
						break;
				}
				}while(ch!=0);
			}
		}
	}
	public void display()
	{
		System.out.println("ROOM DETAILS : ");
		System.out.println();
    	  System.out.printf("%-10s","ROOM NO");
    	  System.out.printf("|%-20s","AVAILABILITY");
    	  System.out.printf("|%-15s","STATUS");
    	  System.out.printf("|%-20s","PRICE");
    	  System.out.printf("|%-20s","TYPE");
		  System.out.println();
		  if(r.size()==0) {
				r.add(new Room(1,"unavailable","cleaned",1000,"Single bed"));
				r.add(new Room(2,"unavailable","cleaned",2000,"Double bed"));
				r.add(new Room(3,"available","cleaned",1000,"Single bed"));
				r.add(new Room(4,"available","cleaned",2000,"Double bed"));
				r.add(new Room(5,"available","cleaned",1000,"Single bed"));
				
		  }
		for (Room room : r) {
	      	  System.out.printf("%-10s",room.getroomnum());
	      	  System.out.printf("|%-20s",room.getava());
	      	  System.out.printf("|%-15s",room.getstatus());
	      	  System.out.printf("|%-20s",room.getprice());
	      	  System.out.printf("|%-20s",room.gettype());

	      	  System.out.println("\n______________________________________________________________________________________________________________");
	      	  
	      	  }
	}
}

