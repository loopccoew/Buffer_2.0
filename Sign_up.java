package Hospital;

public class Sign_up {
private String name;
private String mobile_no;
private String password;
public Sign_up(String nm,String mb,String pass)
{
	name=nm;
	mobile_no=mb;
	password=pass;
}
public String getName()
{
	return name;
}

public String getPass()
{
	return password;
}
}