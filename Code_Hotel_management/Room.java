package Hotel_management;
import java.util.*;
public class Room 
{
	private int room;
	private String available;
	private String status;
	private int price;
	private String type;
	public Room(int room,String available,String status,int price,String type)
	{
		this.room=room;
		this.available=available;
		this.status=status;
		this.price=price;
		this.type=type;		
	}
	public int getroomnum()
	{
		return this.room;
	}
	public String getava()
	{
		return this.available;
	}
	public String getstatus()
	{
		return this.status;
	}
	public int getprice()
	{
		return this.price;
	}
	public String gettype()
	{
		return this.type;
	}
	public void setava(String available)
	{
		this.available=available;
	}
	public void setstatus(String status)
	{
		this.status=status;
	}
	public void setprice(int price)
	{
		this.price=price;
	}
	public void settype(String type)
	{
		this.type=type;
	}
}

