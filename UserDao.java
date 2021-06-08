package Package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDao {

	private String url="jdbc:mysql://localhost:3306/UserInfo";
	private String mysqlusername="root";
	private String mysqlpassword="MySQL@2578";
	
	private String addUser="insert into user values(?,?,?,?,?,?)";
	private String selectUser="select * from user where customerID=? and password=?";
	//private String selectAllUsers="select* from user";
	
	public void add(int customerID,String name,String mobileNo,String password,String address,String emailID)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,mysqlusername,mysqlpassword);
			Statement st =con.createStatement();
			PreparedStatement ps=con.prepareStatement(addUser);
			ps.setInt(1,customerID);
			ps.setString(2,name);
			ps.setString(3,mobileNo);
			ps.setString(4,password);
			ps.setString(5,address);
			ps.setString(6,emailID);
			int count =ps.executeUpdate();
			System.out.println(count);
			ResultSet rs=st.executeQuery("select * from user ");
			while(rs.next())
			{
				System.out.println(rs.getInt(1) +"  "+rs.getString(2));
			}
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public User check(int customerID,String password)
	{
		User user=new User();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,mysqlusername,mysqlpassword);
			Statement st =con.createStatement();
			PreparedStatement ps=con.prepareStatement(selectUser);
			ps.setInt(1,customerID);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				user.customerID=rs.getInt(1);
				user.name=rs.getString(2);
				user.mobileNo=rs.getString(3);
				user.password=rs.getString(4);
				user.address=rs.getString(5);
				user.emailID=rs.getString(6);
				return user;
			}
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
