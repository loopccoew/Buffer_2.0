package Hotel_management;
import java.util.Scanner;

public class AddRoom 
{
	public void Add_Rooms()
	{
		int x=1;
		int flag=0;
		int num;
		String ava="";
		String sta="";
		int price;
		String typ="";
		Room[] obj=new Room[5];
		Dashboard d = new Dashboard();
		Scanner sc=new Scanner(System.in);
		obj[0]=new Room(1,"unavailable","cleaned",1000,"Single bed");
		obj[1]=new Room(2,"unavailable","cleaned",2000,"Double bed");
		obj[2]=new Room(3,"available","cleaned",1000,"Single bed");
		obj[3]=new Room(4,"available","cleaned",2000,"Double bed");
		obj[4]=new Room(5,"available","cleaned",1000,"Single bed");
		
		SearchRoom sr=new SearchRoom();
		UpdateRoom ur=new UpdateRoom();
		for (Room room : obj) 
		{
			sr.addRoom(room);
			ur.addRoom(room);
		}
		do
		{
			System.out.println("ENTER 1.TO DISPLAY ROOMS");
			System.out.println("ENTER 2.FOR ADDING A ROOM");
			System.out.println("ENTER 3.TO SEARCH A ROOM");
			System.out.println("ENTER 4.UPDATE A ROOM");
			System.out.println("ENTER 0.EXIT");
			x=sc.nextInt();
			switch(x)
			{
			case 1:
				ur.display();
				break;
				
			case 2:
			
				System.out.println("ADD A ROOM");
				System.out.println("Enter room number : ");
				num=sc.nextInt();
				for (Room room : obj) {
					if(room.getroomnum()==num)
					{
						flag=1;
					}
				}
				if(flag==1)
				{
					System.out.println("Room number already exists");
					d.display();
				}
				System.out.println("Enter 1:available 2:booked");
				int available=sc.nextInt();
				if(available != 1 && available != 2)
				{
					System.out.println("you entered wrong choice");
					d.display();
				}
				else if(available==1)
				{
					ava="available";
				}
				else
				{
					ava="unavailable";
				}
				System.out.println("Enter 1:cleaned 2:uncleaned : ");
				int status=sc.nextInt();
				if(status != 1 && status != 2)
				{
					System.out.println("you entered wrong choice");
					d.display();
				}
				else if(status==1)
				{
					sta="cleaned";
				}
				else
				{
					sta="uncleaned";
				}
				System.out.println("Enter price : ");
				price=sc.nextInt();
				System.out.println("Enter the type of room : ");
				System.out.println("1.Single bed 2.Double bed");
				int type=sc.nextInt();
				if(type != 1 && type != 2)
				{
					System.out.println("you entered wrong choice");
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
				Room r1=new Room(num,ava,sta,price,typ);
				sr.addRoom(r1);
				ur.addRoom(r1);
				break;
				
			case 3:
				sr.search();
				break;
				
			case 4:
				ur.update();
				ur.display();
				break;
				
			case 0:
				d.display();
			}
			
		}while(x != 0);
	}
}
