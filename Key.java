package logic;
import java.util.Objects;

public class Key {
	public String flatNumber;//to store FlatNumber

	public Key(String flatNumber) {//parameterized constructor
		this.flatNumber = flatNumber;
	}
	
	public Key() {//default constructor
		this.flatNumber = null;
	}

	public String getFlatNumber() {//getter Method for FlatNumber
		return flatNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(flatNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Key)) {
			return false;
		}
		Key other = (Key) obj;
		return Objects.equals(flatNumber, other.flatNumber);
	}

	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flatNumber == null) ? 0 : flatNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Key)) {
			return false;
		}
		Key other = (Key) obj;
		if (flatNumber == null) {
			if (other.flatNumber != null) {
				return false;
			}
		} else if (!flatNumber.equals(other.flatNumber)) {
			return false;
		}
		return true;
	}*/
	
	

}
