package Hospital;
public class MedicalFacility
{
	private double room=0.0;
	private double medicine=0.0;
	private double otherFacilities=0.0;
	private double specialTreatment=0.0;
	private double fees=0.0;
	public MedicalFacility(double room,double medicine,double otherFacilities,double specialTreatment,double registrationfees)
	{
		this.room=room;
		this.medicine=medicine;
		this.otherFacilities=otherFacilities;
		this.specialTreatment=specialTreatment;
		this.fees=registrationfees;
	}
	public double getRoomAmount()
	{
		return room;
	}
	public double getMedicineAmount()
	{
		return medicine;
	}
	public double getOtherFacilitiesAmount()
	{
		return otherFacilities;
	}
	public double getSpecialTreatmentAmount()
	{
		return specialTreatment;
	}
	public double getTotalBill()
	{
		return (room+medicine+otherFacilities+specialTreatment+fees);
	}
}