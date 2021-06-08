package logic;

import java.util.Objects;

public class Value {

	private Al familyMembers;//ArrayList for Names of Family Members 
	private Al phoneNumbers;//ArrayList for Phone Numbers of Family Members
	
	public Value(Al familyMembers, Al phoneNumbers) {//parameterized constructor
		this.familyMembers = familyMembers;
		this.phoneNumbers = phoneNumbers;
	}
	
	public Value() {//default constructor
		this.familyMembers = null;
		this.phoneNumbers = null;
	}

	public Al getFamilyMembers() {
		return familyMembers;
	}

	public Al getPhoneNumbers() {
		return phoneNumbers;
	}

	

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Value)) {
			return false;
		}
		Value other = (Value) obj;
		return Objects.equals(familyMembers, other.familyMembers) && Objects.equals(phoneNumbers, other.phoneNumbers);
	}

	@Override
	public String toString() {//Used for Displaying the information of the family
		return "Value [familyMembers=" + familyMembers + ", phoneNumbers=" + phoneNumbers + "]";
	}
	
	
	
}

	
