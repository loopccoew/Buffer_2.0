package logic;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class FileToAl  
{
	
	public void loadData(Al flatNos, Al2 values, Al hnames_type,AlAl fnos) throws FileNotFoundException 
	{
		File f = new File("Residents data.txt");
		File f2 = new File("Househelpers data.txt");
		Scanner sc = new Scanner(f);
		Scanner sc2 = new Scanner(f2);
		
		//Reading and storing residents data 
		do 
		{
			String temp="\0";
			String temp2="$";					//To group the data of a flat no.
			String record = sc.nextLine();
			Scanner scr = new Scanner(record);
			//String temp3;
			scr.useDelimiter("#");				//For separating names and phone nos in a line scanned from file
			temp=scr.next();						//scanning next line till delimiter (reads flat no)
			while(!temp.equals(temp2))
			{												//creating new object for every flat no.
				flatNos.add(temp);	
				Al fm = new Al();
				Al pn = new Al();
				
				Value obj = new Value(fm,pn);
				obj.getFamilyMembers().add(scr.next());
				obj.getPhoneNumbers().add(scr.next());
				
			    record = sc.nextLine();
				scr= new Scanner(record);
				scr.useDelimiter("#");
				temp=scr.next();								    //scanning next line till delimiter (reads flat no)
				if(temp.equals(temp2))
				{													       // To add the data of all family members in same object
					while(sc.hasNext() && temp.equals(temp2))
					{
						obj.getFamilyMembers().add(scr.next());
						obj.getPhoneNumbers().add(scr.next());
					    record = sc.nextLine();
						scr= new Scanner(record);
						scr.useDelimiter("#");
						temp=scr.next();	
					 }
				}
				values.add(obj);				//Adding to values arraylist 
				
			}
			scr.close();
		} while(sc.hasNext());
		sc.close(); 
		
		//Reading and storing house helpers data 
		while(sc2.hasNext())
		{
			String record = sc2.nextLine();
			Scanner scr2 = new Scanner(record);
			scr2.useDelimiter("#");							//For separating names and flat nos in a line scanned from file
			hnames_type.add(scr2.next());				//scanning and adding house helper's name & type
			Al hf = new Al();
			Value2 hfnos= new Value2(hf);
			hfnos.getHfnos().add(scr2.next());	//scanning and adding flat nos the house helper works in same arraylist
			while(scr2.hasNext()) 
			{
				hfnos.getHfnos().add(scr2.next());
			}
			fnos.add(hfnos);
			scr2.close();
		}
		sc2.close(); 
		
	}
}