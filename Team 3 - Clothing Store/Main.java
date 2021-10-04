package testModule;
import java.util.*;
import module.Item;
import module.Product;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ch = 0;
		int total = 0;
		double amount = 0.0f;
		
		Scanner sc = new Scanner(System.in);  
		
		ArrayList<Product> cart = new ArrayList<Product>();
		
		do{
			System.out.println("\t------------What would you like to do?----------");
			System.out.println("\t 1. Continue Shopping");
			System.out.println("\t 2. Check Out");
			System.out.println("\t 3. Exit");
			System.out.println("\t------------------------------------------------");
			
			Scanner s1 = new Scanner(System.in);  
		    System.out.println("\t Enter your choice : ");
			ch = s1.nextInt();
			
			switch(ch){
			case 1 : 
				Product p = new Product();
				HashMap<String, HashMap<String, HashMap<String, HashMap<String, ArrayList<Item>>>>> allProducts = p.createData();
				p = p.chooseProduct(allProducts);
				//System.out.println("\t Product Chosen : "+p.productName+"("+p.brand+")");
				//System.out.println("\t Price : "+p.productPrice);
				
				System.out.println("\t Would you like to add product to cart? ");
				System.out.println("\t 1. Yes");
				System.out.println("\t 2. No");
				System.out.println("\t");
				
			    System.out.println("\t Enter your choice : ");
				int choice = sc.nextInt();
				
				switch(choice){
					case 1 : 
						cart.add(p);
						break;
						
					case 2 : 
						System.out.println("\t Check out other products!");
						break;
				}
				
				if(cart.isEmpty() == false){
					System.out.println("\t Your cart contains :");
					System.out.println("\t");
					for(Product pr : cart){
						System.out.println("\t "+pr.brand+" "+pr.productName+"["+pr.productSize+"]"+"-"+pr.gender+"   Rs."+pr.productPrice);
					}
				}
				break;
				
			case 2 :
				System.out.println("\t Your cart contains :");
				System.out.println("\t");
				for(Product pr : cart){
					System.out.println("\t "+pr.brand+" "+pr.productName+"["+pr.productSize+"]"+"-"+pr.gender+"   Rs."+pr.productPrice);
				}
				
				for(Product pr : cart){
					total += pr.productPrice;
				}
				
				System.out.println("\t");
				System.out.println("\t Would you like to remove any product from the cart? ");
				System.out.println("\t 1. Yes");
				System.out.println("\t 2. No");
				System.out.println("\t");
				
				System.out.println("\t Enter your choice : ");
				choice = sc.nextInt();
				
				switch(choice){
					case 1 : 
						System.out.println("\t Your cart contains :");
						
						int i = 0;
						for(Product pro : cart){
							System.out.printf("\t %d. ", i+1);
							System.out.print("\t "+pro.brand+" "+pro.productName+"["+pro.productSize+"]"+"-"+pro.gender+"   Rs."+pro.productPrice);
							System.out.println("\t");
							i++;
						}
						
						System.out.println("\t Choose the product to be removed : ");
						int ch1 = sc.nextInt();
						
						for(int j = 0; j < cart.size(); j++){
							if(ch1 == j+1){
								float pr = cart.get(j).productPrice;
								cart.remove(j);
								total -= pr;
							}
						}
						break;
						
					case 2 : 
						break;
				}
				
				System.out.println("\t-------------------------Bill--------------------------------");
				System.out.println("\t Product details : ");
				System.out.println("\t");
				for(Product pr : cart){
					System.out.println("\t "+pr.brand+" "+pr.productName+"["+pr.productSize+"]"+"-"+pr.gender+"   Rs."+pr.productPrice);
				}
				System.out.println("\t");
				System.out.println("\t Total : "+total);
				amount = total*(1.28);
				System.out.println("\t Final Amount (with 28% tax) : "+amount);
				System.out.println("\t-------------------------------------------------------------");
				break;
				
			case 3 : 
				System.out.println("\t Thank you for vising our store!");
				break;
		    }
		}while(ch != 3);
	}
}
