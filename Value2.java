package logic;

import java.util.Objects;

public class Value2 {
	public Al hfnos;

	public Value2(Al hfnos) {//parameterized constructor
		this.hfnos = hfnos;
	}
	
	public Value2() {//default constructor
		this.hfnos = null;
	}


	public Al getHfnos() {
		return hfnos;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Value2)) {
			return false;
		}
		Value2 other = (Value2) obj;
		return Objects.equals(hfnos, other.hfnos);//returning boolean value
	}
	

}
