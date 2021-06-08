package logic;

import java.util.Objects;

public class Key2 {
	public String hname_type;

	public Key2(String hname_type) {//parameterized constructor
		this.hname_type = hname_type;
	}
	
	public Key2() {//default constructor
		this.hname_type = null;
	}

	public String getHname_type() {//getter method for Hname_type
		return hname_type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(hname_type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Key2)) {
			return false;
		}
		Key2 other = (Key2) obj;
		return Objects.equals(hname_type, other.hname_type);
	}
	
	
	

}
