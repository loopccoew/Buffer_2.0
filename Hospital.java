package Hospital;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;    
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
@SuppressWarnings("unused")
public class Hospital {
	int doctorCount = 0;
	int patientCount=0;
	ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
	ArrayList<Patient> patientList = new ArrayList<Patient>();
	ArrayList<Sign_up> sign=new ArrayList<Sign_up>();
	@SuppressWarnings("rawtypes")
	HashMap hm=new HashMap();
	int key1 = 500,key2=100,key3=200;
	String name=null;
	@SuppressWarnings({ "rawtypes", "unchecked", "resource" })
	public void start() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		char YesOrNo = 'Y';
		int ch2=0,choice=0;
		while (YesOrNo  =='Y')
		{
			System.out.println("1 Admin");
			System.out.println("2 User");
			System.out.print("\nEnter your choice:");
			int ch=input.nextInt();
			switch(ch)
			{
			case 1:System.out.println("Enter password:");
			       String pass=input.next();
			       if(pass.equals("Admin@123"))
			       {
			       do
			       {
				   System.out.print("\n\n\t\t1 :  Add doctor\n\n");
			       System.out.print("\t\t2 : Show doctors\n\n");
			       System.out.print("\t\t3 : Show doctor-patient List\n\n");
			       System.out.print("\t\t4 : Enter patient's condition\n\n");
			       System.out.print("\t\t5 : Enter mediacal expenses of patient\n\n");
			       System.out.print("\t\t6 : Show ptients\n\n");
			       System.out.print("\t\t7 : Display total medical bill of patient\n\n");
	               System.out.print("\t\t8 : Cancel doctor\n\n");
	               System.out.print("\t\t9 : Exit\n\n");
			       System.out.println("\t\t\tYou Select : ");
			       choice=0;
			       choice=input.nextInt();
			       switch (choice) 
			       {
			       case 1:enterDoctors();//enter doctor details
				   break;
			       case 2:showDoctors();//show doctors available
				   break;
			       case 3:getDoctorPatientList();//display doctor-patient list
				   break;
			       case 4:patientReport();//remarks of doctor for their patients
				   break;
			       case 5:createMedicalBill();//enter medical expenses of patient
				   break;
			       case 6:getPatientList();//display the details of all patients
				   break;
			       case 7:getMedicalBill();//total medical bill of patient
				   break;
			       case 8:cnacelDoctor();
			       break;
			       case 9:System.out.println("Exiting...");
			       break;
			       default:System.out.println("Invalid Selection!!");
				   break;	
			       }
			       }while(choice!=9);
			       }
			       else
			       {
			    	   System.out.println("Invalid Password!!");
			       }
			break;
			case 2:System.out.println("\nDo you have an account??\nY=Yes Or N=No");
			        String ac=input.next();
			        int f=0;
			        if(ac.equals("y")||ac.equals("Y"))
			        {
			        	Iterator it=sign.iterator();
			        	System.out.println("Enter username:");
				    	String name=input.next();
				    	System.out.println("Enter Password:");
				    	String p=input.next();
			        	while(it.hasNext())
			        	{
			        		Sign_up s=(Sign_up)it.next();
			        		if(s.getName().equals(name)&&s.getPass().equals(p))
			        		{
			        			f=1;
			        			System.out.println("Logged in successfully!!");
			        			break;
			        		}
			        		
			        	}
			        }
			        else if(ac.equals("n")||ac.equals("N"))
			        {
				       System.out.println("\n\nSign in");
			    	   System.out.println("Enter username:");
			    	   String name=input.next();
			    	   System.out.println("Enter your mobile no:");
			    	   String mb=input.next();
			    	   if(mb.length()<10&&mb.charAt(0)<'7')
			    	   {
			    		   System.out.println("Invalid mobile number!!");
			    		   break;
			    	   }
			    	   System.out.println("Enter Password:");
			    	   String p=input.next();
			    	   Sign_up s=new Sign_up(name,mb,p);
			    	   sign.add(s);
			    	   f=1;
			    	   System.out.println("Signed in successfully!!");
			        }
			        else
			        {
			        	System.out.println("Invalid choice!!");
			        	break;
			        }
			        if(f==0)
			        {
			        	System.out.println("Account does'nt exist!!");
			        	break;
			        }
			       do
			       {
				   System.out.print("\n\n\t\t1 : Show doctors\n\n");
			       System.out.print("\t\t2 : Book appointment\n\n");
			       System.out.print("\t\t3 : Exit\n\n");
			       System.out.println("\t\t\tYou Select : ");
			       ch2=input.nextInt();
			       switch(ch2)
			       {
			       case 1:showDoctors();//show doctors available
				   break;
			       case 2:getAppointment();//enter patient details and give them appointment
				   break;
			       case 3:System.out.println("Exiting...");
			       break;
			       default:System.out.println("Invalid Selection!!");
				   break;
			       }
			       }while(ch2!=3);
			break;
			default:System.out.println("Invalid Selection!!");
			break;
			}
			System.out.println("\n\tDo u want to Do some thing Else \n\t\tY = yes\n\t\tN = No\n");
			System.out.println("You Select : ");
			YesOrNo =(input.next()).charAt(0);
			if(Character.isLowerCase(YesOrNo ))
			{
				YesOrNo =Character.toUpperCase(YesOrNo );
			}
		}//End While
	}// End Start()

    public void enterDoctors()
    {
    	Scanner input1 = new Scanner(System.in);
		String tempName;
		String  tempSpeciality;
		double from,to;
		System.out.print("Enter Doctor Name: ");
		tempName = input1.nextLine();
		System.out.print("\n1: Opthalmologist \n2: Surgeon \n3: ENT");
		System.out.print("\nSelect Doctor Speciality: ");
		@SuppressWarnings({ })
		Scanner input2 = new Scanner(System.in);
		int tempSpecNo = input1.nextInt();
		if(tempSpecNo==1){
			tempSpeciality="Opthalmologist";
		}else if(tempSpecNo==2){
			tempSpeciality="Surgeon";
		}else if(tempSpecNo==3){
			tempSpeciality="ENT";
		}else{
			tempSpeciality=" ";
		}
		System.out.println("\n1.First shift:8:00 AM to 4:00 PM");
		System.out.println("2.Second shift:4:00 PM to 12:00 AM");
		System.out.println("3.Third shift:12:00 AM to 8:00 AM");
		System.out.print("Choose the shift:");
		int shift=0;
		try
		{
			Scanner input3=new Scanner(System.in);
			shift=input3.nextInt();
		}
		catch(NumberFormatException e)
		{
			System.out.print("Enter integer value:");
			Scanner input3=new Scanner(System.in);
			shift=input3.nextInt();
			System.out.println();
		}
		switch(shift)
		{
		case 1:from=8.00;
		to=16.00;
		break;
		case 2:from=16.00;
		to=24.00;
		break;
		case 3:from=0.00;
		to=8.00;
		break;
		default:from=8.00;
		to=16.00;
		break;
		}
        int cnt=doctorCount;
		Doctor o1 = new Doctor(tempName,tempSpeciality,from,to,cnt);
		doctorList.add(doctorCount,o1);
		doctorCount++;
    }
	public void showDoctors()
	{
		for(int i = 0 ; i<doctorCount;i++ )
		{
			System.out.println(doctorList.get(i)+"\n");
		}
	}
	public void getAppointment()
	{
		Scanner input1 = new Scanner(System.in);
		String tempName,tempGender = null, tempDisease,slot = null;
		int tempAge;
		double slot_from,slot_to;

		System.out.print("Enter Patient Name: ");
		tempName = input1.nextLine();
		try
		{
			System.out.print("Enter Patient Age: ");
			Scanner input2 = new Scanner(System.in);
			tempAge = input2.nextInt();
		}
		catch(NumberFormatException e)
		{
			Scanner input2 = new Scanner(System.in);
			System.out.println("Please enter valid number!");
			tempAge = input2.nextInt();
		}

		System.out.println("\n1.Female\n2.Male");
		System.out.print("Enter Patient Gender:");
		Scanner input3 = new Scanner(System.in);
		int gender=input3.nextInt();
		do
		{
			switch(gender)
			{
			case 1:tempGender = " Female ";
			break;
			case 2:tempGender = " Male ";
			break;
			default:System.out.println("Invalid Choice!!");
			break;
			}
			
		}while(gender!=2&&gender!=1);
		System.out.print("Select Patient Disease\n1: eye \n2: heart patient \n3: earnose");
		Scanner input4 = new Scanner(System.in);
		int tempSpecNo = input4.nextInt();
		if(tempSpecNo==1){
			tempDisease="eye";
		}else if(tempSpecNo==2){
			tempDisease="heart patient";
		}else if(tempSpecNo==3){
			tempDisease="earnose";
		}else{
			tempDisease=" ";
		}
		int ch=0;
		try
		{
			System.out.println("\nWhich slot would you prefer?\n");
			System.out.println("1 Morning");
			System.out.println("2 Aftrenoon");
			System.out.println("3 Evening");
			Scanner sc=new Scanner(System.in);
			ch=sc.nextInt();
		}
		catch(NumberFormatException e)
		{
			System.out.print("Enter Intger value:");
			Scanner sc=new Scanner(System.in);
			ch=sc.nextInt();
		}
		switch(ch)
		{
		case 1:slot="Morning";
		break;
		case 2:slot="Evening";
		break;
		case 3:slot="Night";
		break;
		default:System.out.println("Invalid choice!");
		break;
		}
        String joining_date=LocalDate.now().toString();
        int cnt=patientCount;
		Patient p1 = new Patient(tempName,tempAge,tempGender, tempDisease,slot,joining_date,cnt);
		
		patientList.add(patientCount,p1);
		patientCount++;

		
		for (Doctor y: doctorList)
		{     
			if (p1.getDisease().equals("eye"))
			{
				if (y.getDoctorspeciality().equals("Opthalmologist"))
				{

					if(p1.getPreference().equals("Morning")&&y.doctorAvailablefrom()>=8&&y.doctorAvailabletTill()<=16)
					{
						y.addPatientsToDoctor(p1,y);
						System.out.println("Docter(Opthalmologist)"+y.getDoctorName()+"Added  With Patient with Eye disease\n");
					}
					if(p1.getPreference().equals("Evening")&&y.doctorAvailablefrom()>=16&&y.doctorAvailabletTill()<=24)
					{
						y.addPatientsToDoctor(p1,y);
						System.out.println("Docter(Opthalmologist)"+y.getDoctorName()+"Added  With Patient with Eye disease\n");
					}
					if(p1.getPreference().equals("Night")&&y.doctorAvailablefrom()>=1&&y.doctorAvailabletTill()<=24)
					{
						y.addPatientsToDoctor(p1,y);
						System.out.println("Docter(Opthalmologist)"+y.getDoctorName()+"Added  With Patient with Eye disease\n");
					}
				}
			}
			if (p1.getDisease().equals("heart patient"))
			{
				if (y.getDoctorspeciality().equals("Surgeon"))
				{
					if(p1.getPreference().equals("Morning")&&y.doctorAvailablefrom()>=8&&y.doctorAvailabletTill()<=16)
					{
						y.addPatientsToDoctor(p1,y);
						System.out.println("\n Docter(Surgeon)"+y.getDoctorName()+" Added  With Patient with heart disease\n");
					}
					if(p1.getPreference().equals("Evening")&&y.doctorAvailablefrom()>=16&&y.doctorAvailabletTill()<=24)
					{
						y.addPatientsToDoctor(p1,y);
						System.out.println("Docter(Opthalmologist)"+y.getDoctorName()+"Added  With Patient with Eye disease\n");
					}
					if(p1.getPreference().equals("Night")&&y.doctorAvailablefrom()>=1&&y.doctorAvailabletTill()<=24)
					{
						y.addPatientsToDoctor(p1,y);
						System.out.println("Docter(Opthalmologist)"+y.getDoctorName()+"Added  With Patient with Eye disease\n");
					}
				}
			}
			if (p1.getDisease().equals("earnose"))
			{
				if (y.getDoctorspeciality().equals("ENT"))
				{
					if(p1.getPreference().equals("Morning")&&y.doctorAvailablefrom()>=8&&y.doctorAvailabletTill()<=16)
					{
						y.addPatientsToDoctor(p1,y);
						System.out.println("Docter(ENT)"+y.getDoctorName()+"Added  With Patient with earnose disease\n");
					}
					if(p1.getPreference().equals("Evening")&&y.doctorAvailablefrom()>=16&&y.doctorAvailabletTill()<=24)
					{
						y.addPatientsToDoctor(p1,y);
						System.out.println("Docter(Opthalmologist)"+y.getDoctorName()+"Added  With Patient with Eye disease\n");
					}
					if(p1.getPreference().equals("Night")&&y.doctorAvailablefrom()>=1&&y.doctorAvailabletTill()<=24)
					{
						y.addPatientsToDoctor(p1,y);
						System.out.println("Docter(Opthalmologist)"+y.getDoctorName()+"Added  With Patient with Eye disease\n");
					}
				}
			}
		}
	}
	public void getDoctorPatientList()
	{
		System.out.print("Enter Doctor ID >= 0 AND < "+Integer.toString(doctorCount));
		Scanner in = new Scanner(System.in);
		int i = 0;
		try
		{
			i=in.nextInt();
			i=i--;
		}
		catch(Exception a)
		{
			System.out.println(a);
		}

		System.out.println("\n \n \n "+ ""+doctorList.get(i).getDoctorName()+""+doctorList.get(i).getDoctorPatientList());
	}
	public void patientReport()
	{
		for(Doctor d:doctorList)
        {
	          LinkedHashSet<Patient>p=d.getDoctorPatientList();
	          Iterator itr=p.iterator();
	          while(itr.hasNext())
	          {

	          Patient p1=(Patient)itr.next();
	           if(p1.getCondition().equals("DEF")) {

	          System.out.println("Choose the condition of "+p1.getName());
	          System.out.println("\n1.Severe");
	          System.out.println("2.Moderate");
	          System.out.println("3.Normal");
	          Scanner sc=new Scanner(System.in);
	          int con=sc.nextInt();
	          switch(con)
	          {
	          case 1:p1.setCondition("severe");
	          break;
	          case 2:p1.setCondition("moderate");
	          break;
	          case 3:p1.setCondition("normal");
	          break;
	          default:System.out.println("Invalid Choice!!");
	          break;
	          }
	          if(p1.getCondition().equals("severe"))
	      {
	        Set s=hm.keySet();
	        Iterator it=s.iterator();
	           while(it.hasNext())
	           {
	        Integer key=(Integer)it.next();
	           }
	           if(p1.getStatus().equals("ANY"))
	           {
	           System.out.println("Enter sevierity status of"+ p1.getName());
	           System.out.println("\n1.Needs ICU ");
	        System.out.println("2.Can be accomodated in Non ICU ");
	        Scanner sc1=new Scanner(System.in);
	        int cin=sc1.nextInt();
	        switch(cin) {
	        case 1: {p1.setStatus("Needs ICU");
	        break;
	        }
	        case 2: {
	             p1.setStatus("No need of ICU");
	           break;
	        }
	        }
	        if(p1.getStatus().equals("Needs ICU")) {
	         
	              key1=key1+1;
	              if(key1<=600)
	           {
	            hm.put(key1, p1.getName());
	            System.out.println(p1.getName()+" Your ICU room no is "+key1);
	           }
	       
	        }
	        if(p1.getStatus().equals("No need of ICU")) {
	           System.out.println("Enter room prefered \n 1. Private \n 2. Semi Private");
	           Scanner s1 =new Scanner(System.in);
	        int in=s1.nextInt();
	        if(in == 1) {
	        key2=key2+1;
	              if(key2<=200)
	           {
	            hm.put(key2, p1.getName());
	            System.out.println(p1.getName()+" Your Private room no is "+key2);
	           }
	        }
	        if(in == 2) {
	        key3=key3+1;
	              if(key3<=300)
	           {
	            hm.put(key3, p1.getName());
	            System.out.println(p1.getName()+" Your Semi private room no is "+key3);
	           }
	        }
	      }
	      }
	     
	      }
	         if(p1.getCondition().equals("moderate")) {
	        	 String fromDate=p1.getJoiningDate();
	        	 StringBuffer sBuffer = new StringBuffer(fromDate);
	   	      String year = sBuffer.substring(2,4);
	   	      String mon = sBuffer.substring(5,7);
	   	      String dd = sBuffer.substring(8,10);

	   	      String modifiedFromDate = dd +'/'+mon+'/'+year;
	   	      int MILLIS_IN_DAY = 1000 * 60 * 60 * 24*5;
	   	      java.text.SimpleDateFormat dateFormat =
	   	        	new java.text.SimpleDateFormat("dd/MM/yy");
	   	      java.util.Date dateSelectedFrom = null;
	   	      java.util.Date dateNextDate = null;
	   	      java.util.Date datePreviousDate = null;

	   	      // convert date present in the String to java.util.Date.
	   	      try
	   	      {
	   		  dateSelectedFrom = dateFormat.parse(modifiedFromDate);
	   	      }
	   	      catch(Exception e)
	   	      {
	   		  e.printStackTrace();
	   	      }

	   	 
	   	      String nextDate =
	   	      dateFormat.format(dateSelectedFrom.getTime() + MILLIS_IN_DAY);

	   	      
	   	      try
	   	      {
	   	          dateNextDate = dateFormat.parse(nextDate);
	   	          System.out.println(p1.getName()+" Your Next appointment is: "+dateNextDate);
	   	      }
	   	      catch(Exception e)
	   	      {
	   	          e.printStackTrace();
	   	      }
	   	    
	         }
	   
	           }}
	          }
	         
	}
	public void createMedicalBill()
	{
		double fees=0.0;
		Scanner sc=new Scanner(System.in);
		for(Doctor d:doctorList)
		{
			fees=d.getRegistrationFees(d);
			LinkedHashSet<Patient> p=d.getDoctorPatientList();
			for(Patient p1:p)
			{
				double room=0.0,medicine=0.0,other=0.0,treatment=0.0;
				if(p1.getCondition().equals("severe")&&p1.getFlag2()!=1)
				{
					System.out.println("\n"+p1.getId()+"  "+p1.getName()+": ");
					System.out.print("\nEnter room bill:");
					room=sc.nextDouble();
					System.out.print("\nEnter medicine bill:");
					medicine=sc.nextDouble();
					System.out.print("\nEnter other expenses:");
					other=sc.nextDouble();
					System.out.print("\nEnter special treatment bill:");
					treatment=sc.nextDouble();
					p1.setFlag2();
					p1.medicalExpenses(room,medicine,other,treatment,fees);
				}
				else
				{
					
					p1.medicalExpenses(room,medicine,other,treatment,fees);
				}
				
			}
		}

	}
	public void getMedicalBill()
	{
		System.out.println("Enter patient ID: ");
		Scanner s=new Scanner(System.in);
		int i=s.nextInt();
		for(Doctor d:doctorList)
		{
			LinkedHashSet<Patient> p=d.getDoctorPatientList();
			Iterator itr=p.iterator();
			Patient p1=null;
			while(itr.hasNext())
			{
				p1=(Patient) itr.next();
				if(p1.getId()==i)
				{
					System.out.println("Medical bill of "+p1.getId()+" "+p1.getName()+" is "+p1.getMedicalBill());
					break;
				}
			}
			
		}
	}
	public void getPatientList()
	{
		ArrayList<Patient> al=new ArrayList<Patient>();
		   al=patientList;//display the details of all patients
		   Iterator itr=al.iterator();
		   while(itr.hasNext())
		   {
			   Patient p=(Patient)itr.next();
			   System.out.println("Name: "+p.getName()+"  Age: "+p.getAge()+"  Disease: "+p.getDisease());
		   }
	}
	public void cnacelDoctor()
	{
		int f2=0;
		System.out.print("\nEnter doctor ID:");
		Scanner scan=new Scanner(System.in);
		int i=scan.nextInt();
		
		Iterator itr=doctorList.iterator();
		while(itr.hasNext())
		{
			Doctor doc=(Doctor) itr.next();
			if(doc.getId()==i)
			{
				f2=1;
				itr.remove();
				doctorCount--;
				System.out.println("Cancelled successfully!!");
			}
		}
		if(f2==0)
		{
			System.out.println("No doctor found!!");
		}
	}
}
