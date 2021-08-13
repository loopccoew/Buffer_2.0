package Hospital;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
@SuppressWarnings("unused")
public class Doctor {
	private String  doctorName;
	 private String  doctorSpeciality;
	 private double from;
	 private double to;
	 private double fees;
	 private int id;
	 //String  doctorStatus;
	 LinkedHashSet<Patient> doctorPatientList= new LinkedHashSet<Patient>();
	 Doctor(String c, String cc,double f,double t,int i)
	 {
	     this.doctorName=c;
	     this.doctorSpeciality=cc;
	     this.from=f;
	     this.to=t;
	     this.id=i+2000;
	 }
	 public double getRegistrationFees(Doctor d)
	 {
		 if(d.getDoctorspeciality().equals("Opthalmologist"))
		 {
			 fees=200;
			 return fees;
		 }
		 else if(d.getDoctorspeciality().equals("Surgeon"))
		 {
			 fees=300;
			 return fees;
		 }
		 else
		 {
			 fees=250;
			 return fees;
		 }
	 }
	 public String  getDoctorName()
	 {
	     return doctorName;
	 }
	 
	 @SuppressWarnings("rawtypes")
	public LinkedHashSet getDoctorPatientList()
	 {   
	     return doctorPatientList;
	 }
	 
	 @SuppressWarnings({ "rawtypes" })
	public void addPatientsToDoctor(Patient o,Doctor dc)
	 {
		 Patient p=null;
	     Iterator itr=doctorPatientList.iterator();
	     while(itr.hasNext())
	     {
	    	 p=(Patient)itr.next();
	     }
	     double avail=dc.doctorAvailablefrom();
	     if(p==null)
	     {
	    	 o.setTimehr((int)avail);
	    	 o.setTimemin(0);
	     }
	     else
	     {
	    	 if(p.getTimehr()==24&&p.getTimemin()==0)
	    	 {
	    		 o.setTimehr(0);
	    		 o.setTimemin(1);
	    	 }
	    	 if(p.getTimemin()+15==60)
	    	 {
	    	 o.setTimehr(p.getTimehr()+1);
	    	 o.setTimemin(0);
	    	 }
	    	 else
	    	 {
	    	  o.setTimehr(p.getTimehr());
	    	  o.setTimemin(p.getTimemin()+15);
	    	 }
	     }
	     o.setFlag(1);
	     doctorPatientList.add(o);
	     if(o.getTimehr()>=1||o.getTimehr()<=12)
	     {
	     System.out.println(o.getId()+" "+o.getName()+",Your appointment is booked! at "+o.getTimehr()+":"+o.getTimemin()+"AM");
	     }
	     else
	     {
	    	 System.out.println(o.getId()+" "+o.getName()+",Your appointment is booked! at "+o.getTimehr()+":"+o.getTimemin()+"PM");
	     }
	 }
	 public void clearPatientsToDoctor()
	 {
	     doctorPatientList.clear();
	 }
	 
	 String getDoctorspeciality()
	 {
	     return doctorSpeciality;
	 }
	 double doctorAvailablefrom()
	 {
	     return from;
	 }
	 double doctorAvailabletTill()
	 {
	     return to;
	 }
	 public String toString()
	 {
		 if(from==8&&to==16) {
			 return (id+" "+doctorName+" "+doctorSpeciality+" is available from 8:00 AM to 4:00 PM");
		 }
		 else if(from==16&&to==24){
			 return (id+" "+doctorName+" "+doctorSpeciality+" is available from 4:00 PM to 12:00 AM");
		 }
		 else
		 {
			 return (id+" "+doctorName+" "+doctorSpeciality+" is available from 12:00 AM to 8:00 AM");
		 }
	     
	 }
	 public int getId()
	    {
	    	return id;
	    }

}