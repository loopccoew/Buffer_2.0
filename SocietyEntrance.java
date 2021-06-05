package logic;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SocietyEntrance 
{

	public static void main(String[] args) throws IOException 
	{

		String code1 = "M64@27";// entry code for residents(assuming only residents know it)
		String code2 = "F96@16";// entry code for house helpers
		String code3 = "S82@99";// entry code for chairman(assuming only he knows it)
		int ch = 0;
		Scanner sc = new Scanner(System.in);

		String ec = "\0";		//accepted entry code 
		int count = 0;
		int count1 = 0;
		Al flatNos = new Al();
		Al2 values = new Al2();			//objects of Value class-family members and their phone nos 
		Al hnames_type = new Al();	//househelper's names and types
		AlAl fnos = new AlAl();			//arraylist of flat nos arraylists (house helpers)
		HashMap map = new HashMap();
		HashMap2 map2 = new HashMap2();
		File file = new File("Entry Records.txt");
		FileWriter fw = new FileWriter(file,true);	//appends to the already existing file 

		FileToAl obj = new FileToAl();
		try 
		{
			obj.loadData(flatNos, values, hnames_type, fnos);
		} 
		catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		}
		createMap(flatNos, values, map);
		createMap2(hnames_type, fnos, map2);
		do 
		{
			ch = menu();
			switch (ch) 
			{
			case 1:					//Resident Entry
				count = 0;

				do 
				{
					System.out.println("Enter the code: ");
					ec = sc.nextLine();
					if (!ec.equals(code1)) 
					{
						if(count==2) {
							System.out.println("No more attempts left.\nEntry Denied.");
							break;
						}
						System.out.println(
								"Sorry, the code you entered is wrong. You have " + (2 - count) + " attempt(s) left");
						count++;
					}
				} 
				while (!ec.equals(code1) && count < 3);		// 3 attempts
				if (ec.equals(code1)) {
					System.out.println("Welcome!!!\nYou can enter!");
				} 
				break;
				
			case 2:						//House helper Entry
				count1 = 0;
				Scanner sc1 = new Scanner(System.in);
				do {

					System.out.println("Enter the code: ");
					ec = sc1.nextLine();
					if (!ec.equals(code2)) {
						if(count1==2) {
							System.out.println("No more attempts left.\nEntry Denied.");
							break;
						}
						System.out.println(
								"Sorry, the code you entered is wrong. You have " + (2 - count1) + " attempt(s) left");
						count1++;
					}
				} 
				while (!ec.equals(code2) && count1 < 3);		// 3 attempts
				
				if (ec.equals(code2)) //
				{
					String h_name;
					Key2 key2 = new Key2();
					int h_ch;//accepting house helper name and type
					System.out.println("Now Enter your name");
					h_name = sc1.nextLine();
					do 
					{
						System.out.println("\t\t\t\t\tType of House-Helper :" + "\n \t\t\t\t\t\t1. Maid" + "\n \t\t\t\t\t\t2. Milkman" + "\n \t\t\t\t\t\t3. Driver"
								+ "\n\t\t\t\t\t\t 4. Newspaper Vendor" + "\n \t\t\t\t\t\t5. Garbage Collector");

						System.out.println("Choose an option from above");
						h_ch = sc1.nextInt();
						switch (h_ch) {
						case 1:
							key2.hname_type = (h_name + "-Maid");
							break;
						case 2:
							key2.hname_type = (h_name + "-Milkman");
							break;
						case 3:
							key2.hname_type = (h_name + "-Driver");
							break;
						case 4:
							key2.hname_type = (h_name + "-Newspaper vendor");
							break;
						case 5:
							key2.hname_type = (h_name + "-Garbage collector");
							break;
						default:
							System.out.println("Enter valid option");
							break;
						}
					} 
					while (ch < 1 && ch > 5);
					
					boolean found1=false;
					for(int i=0;i<hnames_type.getSize();i++) //traversing through house helpers arraylist
					{
						if(hnames_type.getElementData(i).equalsIgnoreCase(key2.hname_type)) 
						{
							found1=true;
							break;
						}
					}
					
					if(found1==true) 		// if the house helper is registered
					{
					System.out.println(key2.hname_type + " has entered.\n Notifications sent to : ");
					Al objlist = new Al();
					Key key = new Key();
					objlist = map2.get(key2).getHfnos();
					for (int k = 0; k < objlist.getSize(); k++) 		// notifying respective residents 
					{
						key.flatNumber = objlist.getElementData(k);
						System.out.println("\n Flat Number " + key.flatNumber + "\n Phone Number(s) : ");
						map.get(key).getPhoneNumbers().display();
					}
					System.out.println("\nWelcome!!!\nYou can enter!");
				
					}
					else {System.out.println("\nEntry Denied.\nYou are not a registered househelper.");}
				}
				break;

			case 3:									//Guest Entry
				Guest g = new Guest();  	//From watchman's pov
				String flag = "0";
				g.accept();							//accept guest data
				Key key = new Key();
				key.flatNumber = g.getFlatNumber();
				System.out.println("Now sending notifications to the respective residents for approval :");
				map.get(key).getPhoneNumbers().display();			//displaying phone nos. to be notified
				System.out.println("\nNotified the above nos");
				flag = permission(g);						
				if (flag.equalsIgnoreCase("1")) 		//checking for residents approval
				{													
					double temp = 0.0;
					System.out.println("Entry Approved \nCheck and Enter guest's temperature :");
					temp = sc.nextDouble();
					if (g.checkTemp(temp)) 			//if approved check guest's body temperature
					{
						System.out.println("\nWelcome!!!\nYou can enter!");
						fw.write(g.toString());
						fw.flush();

					} 
					else 
					{System.out.println("Sorry, you cannot enter.Your body temperature is high.");}
				} 
				else 
				{
					System.out.println("Entry Denied.");
				}
				break;

			case 4:										//Display Guest Entry records	only accessible to society chairman
				int count3 = 0;
				Scanner sc3=new Scanner(System.in);
				do 
				{
					System.out.println("Enter the code: ");
					ec = sc3.nextLine();
					if (!ec.equals(code3)) 
					{
						if(count3==2) 
						{
							System.out.println("No more attempts left.\nEntry Denied.");
							break;
						}
						System.out.println(
								"Sorry, the code you entered is wrong. You have " + (2 - count3) + " attempt(s) left");
						count3++;
					}
				} 
				while (!ec.equals(code3) && count3 < 3);		// 3 attempts
				if (ec.equals(code3)) 
				{
					int i;														//Reading from Entry records file and displaying it
					FileReader fr = new FileReader(file);
					System.out.println("\t\t\t\t_________Guest Entry Records_________");
					while ((i = fr.read()) != -1)
						System.out.print((char) i);
					fr.close();
				}
				break;

			case 5:
				System.out.println("Exiting...");
				break;
			}

		} 
		while (ch != 5);
		fw.close();
	}

	public static int menu() 
	{
		int ch = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("\n\t\t\t\t\t***WELCOME TO VRINDAVAN SOCIETY!! ***");
			System.out.println("\n\t\t\t\t\t\t1. Resident Entry" + "\n\n" + "\t\t\t\t\t\t2. Househelper Entry" + "\n\n" + "\t\t\t\t\t\t3. Guest Entry"+ "\n\n" + "\t\t\t\t\t\t4. Display guest entry records" + "\n\n" + "\t\t\t\t\t\t5. Exit");
			System.out.println("\nEnter the choice number: ");
			ch = sc.nextInt();
		} while (ch < 1 || ch > 5);
		return ch;
	}

	public static void createMap(Al flatNos, Al2 values, HashMap map) 
	{																		//Mapping flat nos to resident data
		for (int i = 0; i < flatNos.getSize(); i++) 
		{
			Key key = new Key();
			key.flatNumber = flatNos.getString(i);
			map.put(key, values.getValues(i));
		}
	}

	public static String permission(Guest g) 			// getting permission from resident
	{
		Scanner sc = new Scanner(System.in);
		String approved;
		System.out.println(
				g.getName() + " wants to meet you.\nEnter '1' if the person is your guest, else enter any other key");
				approved=sc.nextLine();
		return approved;
	}

	public static void createMap2(Al hnames_type, AlAl fnos, HashMap2 map2) 
	{																				//Mapping house helpers to flat nos they work in
		for (int i = 0; i < hnames_type.getSize(); i++) 
		{
			Key2 key2 = new Key2();
			key2.hname_type = hnames_type.getString(i);
			map2.put(key2, fnos.getValues2(i));
		}

	}
}
