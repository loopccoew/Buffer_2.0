package Hospital;

import java.util.LinkedHashSet;

public class Patient {
	private String patientName;
    private int patientAge;
    private String  patientGender;
    private String disease;
    private String condition="DEF";
    private String next_appointment;
    private int flag=0;
    private int flag2=0;
    private int hr,min;
    private String pref=null;
    private double room=0.0;
	private double medicine=0.0;
	private double otherFacilities=0.0;
	private double specialTreatment=0.0;
	private String status="ANY";
	private double fees=0.0;
	private String joining_date;
	private int id=0;
    Patient (String patientName, int patientAge,String patientGender, String disease,String slot,String joining_date,int i)
    {
        this.patientName= patientName;
        this.patientGender= patientGender;
        this.patientAge=patientAge;
        this.disease=disease;
        this.pref=slot;
        this.joining_date=joining_date;
        this.id=i+1000;
    }   
    public void medicalExpenses(double rm,double med,double other,double special,double fee)
    {
    	room=rm;
		medicine=med;
		otherFacilities=other;
		specialTreatment=special;
		fees=fee;
    }
    public String getNextAppointment()
    {
    	return next_appointment;
    }
    public int getAge()
    {
    	return patientAge;
    }
    public double getMedicalBill()
    {
    	System.out.println(getName()+"\nYour registration fee is "+fees+"\nYour room bill is "+room+
    			"\nYour medicine bill is "+medicine+"\nYour other expenses are "
    			+otherFacilities+"\nYour special treatment bill is "
    			+specialTreatment);
    	return (room+medicine+otherFacilities+specialTreatment+fees);
    }
    public String getCondition()
    {
    	return condition;
    }
    public String getName()
    {
    	return patientName;
    }
    public String getDisease()
    {return disease;}

    public String toString()
    {
        return (id+" "+patientName+" "+patientAge+" "+patientGender +" "+ disease);
    }
    public String getJoiningDate()
    {
    	return joining_date;
    }
    public int getTimehr()
    {
    	return hr;
    }
    public int getTimemin()
    {
    	return min;
    }
    public String getStatus()
    {
    	return status;
    }
    public String getPreference()
    {
    	return pref;
    }
    public int getFlag()
    {
    	return flag;
    }
    public void setCondition(String con)
    {
    	condition=con;
    }
    public void setStatus(String stat)
    {
    	status=stat;
    }
    public void setTimehr(int h)
    {
    	hr=h;
    }
    public void setTimemin(int m)
    {
    	min=m;
    }
    public void setFlag(int i)
    {
    	flag=i;
    }
    public void setFlag2()
    {
    	flag2=1;
    }
    public int getFlag2()
    {
    	return flag2;
    }
    public int getId()
    {
    	return id;
    }

}
