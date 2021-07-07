package Hotel_management;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchRoom {
	int type;
	String typ="";
	Dashboard d = new Dashboard();
	static ArrayList<Room> r =new ArrayList<Room>();
	public void addRoom(Room r1)
	{
		r.add(r1);
	}
	public void search()
	{
		 if(r.size()==0) {
				r.add(new Room(1,"unavailable","cleaned",1000,"Single bed"));
				r.add(new Room(2,"unavailable","cleaned",2000,"Double bed"));
				r.add(new Room(3,"available","cleaned",1000,"Single bed"));
				r.add(new Room(4,"available","cleaned",2000,"Double bed"));
				r.add(new Room(5,"available","cleaned",1000,"Single bed"));
				
		  }
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the type of room you are looking for : ");
		System.out.println("1.Single bed room 2.Double bed Room");
		int type=sc.nextInt();
		if(type!=1 && type!=2)
		{
			System.out.println("invalid choice");
			d.display();
		}
		else if(type==1)
		{
			typ="Single bed";
		}
		else
		{
			typ="Double bed";
		}
		System.out.println("AVAILABLE ROOM DETAILS : ");
		System.out.println();
		System.out.println("roomnumber\tavailability\tstatus\tprice\ttype");
		for (Room room : r) {
			if(room.getava().compareTo("available")==0)
			{
				if(room.gettype().compareTo(typ)==0)
				{
					System.out.println("\t"+room.getroomnum()+"\t"+room.getava()+"\t"+room.getstatus()+"\t"+room.getprice()+"\t"+room.gettype());
				}
			}
		}
	}
}
