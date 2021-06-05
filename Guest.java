package logic;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Guest {
	private String name;
	private String phoneNumber;
	private String flatNumber;
	
	LocalDateTime myDateObj = LocalDateTime.now();		//The time at which the object is created
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyy , HH:mm:ss");

    String formattedDate = myDateObj.format(myFormatObj);			//To format the obj as per the above pattern 

	public LocalDateTime getMyDateObj() {
		return myDateObj;
	}

	public DateTimeFormatter getMyFormatObj() {
		return myFormatObj;
	}

	public String getFormattedDate() {//getter method for FormattedDate
		return formattedDate;
	}
	
	Scanner sc=new Scanner(System.in);
	public Guest() 	//Default constructor
	{
		this.name = null;
		this.phoneNumber = null;
		this.flatNumber = null;
	}

	public Guest(String name, String phoneNumber, String flatNumber, LocalDateTime myDateObj,
			DateTimeFormatter myFormatObj, String formattedDate) 
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.flatNumber = flatNumber;
		this.myDateObj = myDateObj;
		this.myFormatObj = myFormatObj;
		this.formattedDate = formattedDate;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getFlatNumber() {
		return flatNumber;
	}

	public boolean checkTemp(double temp) {
		if(temp<=98.7)//checking temperature for fever
			return true;
		else
			return false;
	}
	
	public void accept() 
	{
		System.out.println("\nEnter your name");
	    this.name=sc.nextLine();//accepting name of guest
	    do {
	    	System.out.println("Enter your phone number");
	        this.phoneNumber=sc.nextLine();
	        if(this.phoneNumber.length()!=10)//input validation for phoneNumber
	        {
	        	System.out.println("The phone number is not valid");
	        }
	    }while(this.phoneNumber.length()!=10);
	   int gflat;
	    boolean found=true;
	    do {
	    if(found==false) {System.out.println("Flat no. Invalid.");}//input validation for FlatNumber
	    System.out.println("Enter the flat number of the resident whom you want to pay a visit");
	    gflat=sc.nextInt();
	    found=false;
	    }
	    while((gflat>25||gflat<1));//condition for while loop
	    this.flatNumber=Integer.toString(gflat);
	}

	@Override
	public String toString() {//for displaying
		return "\nGuest Name: "+ name +"\t\tPhone no: "+ phoneNumber +"   FlatNo: "+ flatNumber +"   Date & Time: "+ formattedDate +" \n";
		
	}

}
