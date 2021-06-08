package Package1;
import java.io.IOException;
import java.util.*;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/")
public class CakeShopManagement extends HttpServlet{

	static User user=new User();
	
	Scanner scan =new Scanner(System.in);
	
	static int count=1;
	
	static List list=new List();
	
	UserDao userdao =new UserDao();
	
	User admin=userdao.check(100, "Admin@1234");

	void Registration(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("admin id :"+admin.customerID);
		int customerID;
		String name,mobileNo,password,address,emailID;
		name=request.getParameter("name");
		mobileNo=request.getParameter("mobileNumber");
		password=request.getParameter("password");
		address=request.getParameter("address");
		emailID=request.getParameter("emailID");
		HttpSession session =request.getSession();
		customerID=(int)(session.getAttribute("customerID"));
		System.out.println(customerID);
		userdao.add(customerID, name, mobileNo, password, address, emailID);;
		RequestDispatcher rd=request.getRequestDispatcher("LoginPage.jsp");
		rd.forward(request, response);
	}
	void Login(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		int customerID=0;
		String password=null;
	
		try {
			customerID=Integer.parseInt(request.getParameter("customerID"));
			password=request.getParameter("password");
		} catch (NumberFormatException e) {
			RequestDispatcher rd=request.getRequestDispatcher("LoginPage.jsp");
			rd.forward(request, response);
			return;
		}
		user=userdao.check(customerID, password);
		HttpSession session=request.getSession();
		if(user!=null)
		{
			System.out.println(user.password);
			if(user.customerID==100)
			{	 
				RequestDispatcher rd=request.getRequestDispatcher("viewTodaysOrders");
				rd.forward(request, response);
			}
			else if(user.customerID==customerID)
			{	
				session.setAttribute("name", user.name);
				RequestDispatcher rd=request.getRequestDispatcher("availableCakes");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("LoginPage.jsp");
				rd.forward(request, response);
			}
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("LoginPage.jsp");
			rd.forward(request, response);
		}
	}
	void showRegistrationForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		RequestDispatcher rd=request.getRequestDispatcher("RegistrationForm.jsp");
		rd.forward(request, response);
	}
	void MenuPage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session =request.getSession();
		session.setAttribute("list",list);
		RequestDispatcher rd=request.getRequestDispatcher("UserDashboard.jsp");
		rd.forward(request, response);
	}
	void addMyOrder(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		int productID=Integer.parseInt(request.getParameter("productID"));
		String cake_type=request.getParameter("cake_type");
		String cake_flavour=request.getParameter("cake_flavour");
		String cake_shape=request.getParameter("cake_shape");
		double cake_price=Double.parseDouble(request.getParameter("cake_price"));
		double cake_weight=Double.parseDouble(request.getParameter("cake_weight"));
		user.order.insert(productID,cake_type,cake_flavour,cake_shape,cake_price,cake_weight);
		admin.order.insert(productID,cake_type,cake_flavour,cake_shape,cake_price,cake_weight);
		RequestDispatcher rd=request.getRequestDispatcher("UserDashboard.jsp");
		rd.forward(request, response);
	}
	double CalculateTotalPrice() 
	{
		double total_price=0;
		Cake temp=user.order.head;
		while(temp!=null)
		{
			total_price=total_price+temp.cake_price;
			temp=temp.next;
		}

		return total_price;
	}
	void displayOrderedCakes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		session.setAttribute("orderList",user.order);
		double total_price=CalculateTotalPrice();
		session.setAttribute("total_price", total_price);
		RequestDispatcher rd=request.getRequestDispatcher("MyOrders.jsp");
		rd.forward(request, response);
	}
	void makePayment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();		
		double total_price=CalculateTotalPrice();
		session.setAttribute("total_price", total_price);
		session.setAttribute("name", user.name);
		RequestDispatcher rd=request.getRequestDispatcher("availableCakes");
		rd.forward(request, response);
	}
	void deleteOrderedCake(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productID=Integer.parseInt(request.getParameter("productID"));
		user.order.delete(productID);
		admin.order.delete(productID);
		HttpSession session =request.getSession();
		session.setAttribute("orderList",user.order);
		double total_price=CalculateTotalPrice();
		System.out.println(total_price);
		session.setAttribute("total_price", total_price);
		RequestDispatcher rd=request.getRequestDispatcher("MyOrders.jsp");
		rd.forward(request, response);
	}
	void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		session.invalidate();
		RequestDispatcher rd=request.getRequestDispatcher("LoginPage.jsp");
		rd.forward(request, response);
	}
	void editListOfCakes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		session.setAttribute("list",list);
		RequestDispatcher rd=request.getRequestDispatcher("EditCakesList.jsp");
		rd.forward(request, response);
	}
	void AddNewCake(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cakeID=0;
		String cake_type=request.getParameter("cake_type");
		String cake_flavour=request.getParameter("cake_flavour");
		String cake_shape=request.getParameter("cake_shape");
		double cake_price=0;
		double cake_weight=0;
		try {
			cakeID=Integer.parseInt(request.getParameter("cake_id"));
			cake_price = Double.parseDouble(request.getParameter("cake_price"));
			cake_weight = Double.parseDouble(request.getParameter("cake_weight"));
		} catch (NumberFormatException e) {
	
			RequestDispatcher rd=request.getRequestDispatcher("AddNewCake.jsp");
			rd.forward(request, response);
			return;
		}
		list.insert(cakeID, cake_type, cake_flavour, cake_shape, cake_price, cake_weight);
		HttpSession session =request.getSession();
		session.setAttribute("list",list);
		RequestDispatcher rd=request.getRequestDispatcher("EditCakesList.jsp");
		rd.forward(request, response);
	}
	void deleteFromCakeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productID=Integer.parseInt(request.getParameter("productID"));
		list.delete(productID);
		HttpSession session =request.getSession();
		session.setAttribute("list",list);
		RequestDispatcher rd=request.getRequestDispatcher("EditCakesList.jsp");
		rd.forward(request, response);
	}
	void todaysOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		session.setAttribute("orderList",admin.order);
		RequestDispatcher rd=request.getRequestDispatcher("AdminDashboard.jsp");
		rd.forward(request, response);
	}
	void cakesDatabase()
	{
		list.insert(101, "Birthday", "Chocklate"," Round", 500, 1);
		list.insert(102, "Birthday", "Vanilla"," Round", 450, 1);
		list.insert(103, "Anniveresary", "Butter Scotch"," Round", 550, 1);
		list.insert(104, "Birthday", "Pineapple"," Round", 500, 1);
		list.insert(105, "Birthday", "Strawberry"," Round", 475, 1);
		list.insert(106, "Birthday", "Choco Chips", "Round", 550,1);
		list.insert(107, "Anniversary", "Red velvet", "Heart", 450,1);
		list.insert(108, "Birthday", "Sprinkled Vanilla Joys", "Round", 500,1);
		list.insert(109, "Birthday", "Blue berry", "Square", 550,1);
		list.insert(110, "Birthday", "Minion Cake", "Round", 550,1);
		list.insert(111, "Birthday", "Kitkat Cake", "Round", 600,1);
		list.insert(112, "Birthday", "Kitkat Gems Cake", "Round", 650,1);
		list.insert(113, "Birthday", "Nutty Mango Cake", "Round", 650,1);
		list.insert(114, "Mother's Day", "Mom Heart Mom Cake", "Round", 550,1);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		if(count==1)
		{
			cakesDatabase();
			count++;
		}
		doGet(request ,response);
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		response.setContentType("text/html");
		String action=request.getServletPath();
		switch(action)
		{
		case "/login":
			Login(request,response);
			break;
		case "/new" :
			showRegistrationForm(request ,response);
			break;
		case "/saveUserDetails":
			Registration(request,response);
			break;
		case "/availableCakes":
			MenuPage(request,response);
			break;	
		case "/back":
			logout(request,response);
			break;
		case "/addOrder":
			addMyOrder(request,response);
			break;
		case "/place_order":
			MenuPage(request,response);
			break;
		case "/displayOrderedCakes":
			displayOrderedCakes(request, response);
			break;
		case "/editListOfCakes":
			editListOfCakes(request, response);
			break; 
		case "/deleteOrder":
			deleteOrderedCake(request, response);
			break;
		case "/deleteFromCakeList":
			deleteFromCakeList(request, response);
			break;
		case "/AddNewCake":
			AddNewCake(request ,response);
			break;
		case "/makePayment":
			makePayment(request, response);
			break;
		case "/viewTodaysOrders":
			todaysOrders(request, response);
			break;
		}
	}
	public UserDao getUserdao() {
		return userdao;
	}
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public static List getList() {
		return list;
	}
	public static void setList(List list) {
		CakeShopManagement.list = list;
	}
}
