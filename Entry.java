package logic;

public class Entry 
{
	public Key key;
	public Value value;
	public Entry(Key key, Value value)//parameterized constructor 
	{
		this.key = key;
		this.value = value;
	}
	
	public Key getKey() //getter function for Key
	{
		return key;
	}
	public Value getValue() //getter function for Value
	{
		return value;
	}

}
