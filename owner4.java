package buffer4;
import java.util.*;



//stock,bill,items,offers,customer,department
class node
{
	node left,right;
	int data,index;
	node(int d,int index)
	{
		left=right=null;
		data=d;
		this.index=index;
	}
}

class btree  // class for binary tree creation and other operations
{
	node root;
	btree(){
	root=null;
	}
	Scanner s2=new Scanner(System.in);
	Item I[]=new Item[100];
	void create(int d,int index)  //To create binary tree for item_id
	{
		int flag=0;
		node temp=new node(d,index);
		if(root==null)
		{
			root=temp;
		    return;
		}
		else
		{
			node ptr=root;
			while(true)
			{
			  while(ptr!=null)
			  {
				if(temp.data<ptr.data)
				{
					if(ptr.left==null)
					{
					ptr.left=temp;
					return;
					}
					
					else
						ptr=ptr.left;
				}
	
				if(temp.data>ptr.data)
				{
					if(ptr.right==null)
					{
					ptr.right=temp;
					return;
					}
					
					else
						ptr=ptr.right;
				}
			  }
			}
		 }
	 }
     
	void display2(node localRoot)   // inorder display of btree
	{
	  if(localRoot!=null)	
	  {
		display2(localRoot.left);
		System.out.print(localRoot.data+" ");
		display2(localRoot.right);
	  }
	}
	void show()
	{
	display2(root);
	}
	
	int search(int data,int index)    // to search item in tree
	{
		int flag=0,idx=-1;
		node temp=new node(data,index);
		
			node ptr=root;
			  while(ptr!=null)
			  {
				if(temp.data<ptr.data)
				{
					if(ptr.left!=null)
					{
					   ptr=ptr.left;
					}
					else
					{
						break;
					}
				}
	
				if(temp.data>ptr.data)
				{
					if(ptr.right!=null)
					{
					   ptr=ptr.right;
					}
					else {
						break;
					}
				}
				if(temp.data==ptr.data)
				{
					System.out.println("Item Present!");
					flag=1;
					idx=ptr.index;
					break;
				}
			  }
			  if(flag==0)
			  {
				  System.out.println("Item not present in stock.");
			  }
			 
			 return idx;
			  
	}
	
	
}



class Item 
{
	String item_name;  // name of item
	String item_dept;  // department that item belongs to
	int item_id;       // item ID
	float item_price;  // price of item
	int item_discount;  // discount on item(if applicable)
	int item_quantity;  // Quantity of particular item present in stock

	Item()
	{
		item_name=null;
		item_dept=null;
		item_id=0;
		item_price=0;
		item_discount=0;
		item_quantity=0;
		
	}
	
	
	
	Scanner sc=new Scanner(System.in);
	void accept()  // to accept details of item
	{
		String ans;
		System.out.println("__________________________________________________");
		System.out.println("Item Name: ");
		item_name=sc.next();
	 	System.out.println("Item Department: ");
		item_dept=sc.next();
		System.out.println("Item ID: ");
		item_id=sc.nextInt();
		
		System.out.println("Item Price: ");
		item_price=sc.nextFloat();
		System.out.println("Is discount applicable on this item?(y/n): ");
		ans=sc.next();
		if(ans.contentEquals("y"))
		{
		   System.out.println("Item Discount(in %): ");
		   item_discount=sc.nextInt();
		}
		System.out.println("Item Quantity: ");
		item_quantity=sc.nextInt();
		System.out.println("___________________________________________________");
	}
	
	void display()  // to display item details
	{
		//System.out.println("## Item Information ##");
		System.out.println("__________________________________________");
		System.out.println("Item Name: "+item_name);
		System.out.println("Item Department: "+item_dept);
		System.out.println("Item ID: "+item_id);
		System.out.println("Item Price: "+item_price);
		System.out.println("Item Discount: "+item_discount+" %");
		System.out.println("Item Quantity: "+item_quantity);
		System.out.println("__________________________________________");
	
	}
	
	
}

public class owner4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    
      btree b1=new btree();  // object of btree class
      Item I2[]=new Item[100];   // object of Item class
      int data,size,option;
      String n;
      Scanner s1=new Scanner (System.in);
      System.out.println("Enter the no. of types of items in a shop-");
      size=s1.nextInt();
     
      
      do
      {
    	  System.out.println("\nEnter operation-1]Accept 2]Display 3]Search 4]Update 5]Create a Bill 6]Add item 7]Exit");
    	  option=s1.nextInt();
    	  switch(option)
    	  {
    	  case 1:// calling accept and create functions
                 for(int i=0;i<size;i++)
                 {
        	        I2[i]=new Item();
        	        System.out.println("\nFor item "+(i+1)+" -");
        	        I2[i].accept();
        	        b1.create(I2[i].item_id,i);
                 } 
                 System.out.println("\nFor accepted data, BTree formed is as follows- ");
  	             b1.show();
  	             System.out.println("\n___________________________________________________________");
                 break;
    	  case 2: // calling display function
    		    for(int i=0;i<size;i++)
                {
    		      System.out.println("\nFor item "+(i+1)+" -");
 	              I2[i].display();
 	            } 
    		    break;
    	  case 3: // calling search function
    				int id,res;
    				System.out.println("\nEnter the ID of item that you want to SEARCH-");
    				id=s1.nextInt();
    				res=b1.search(id,0);
    				if(res>=0)
    				{
    					I2[res].display();
    				}
    				break;
    	  case 4: // to update details of particular item
    		       int id1,res1;
    			   System.out.println("\nEnter the ID of item that you want to UPDATE-");
    			   id1=s1.nextInt();
    			   res1=b1.search(id1,0);
    			   System.out.println("\nPresent Details-");
    			   I2[res1].display();
    			   System.out.println("\nEnter New Details-");
    			   I2[res1].accept();
    			   System.out.println("\nUpdated Details-");
    			   I2[res1].display();
    			   break;
    	  case 5:// to create bill for owner & printing bill in particular form
    		    int i1=0,ch=0,j=0;
    		    float sum=0,sum1=0;
    		    int ind[]=new int[100];
    		    int i2[]=new int[100];
    		    float total[]=new float[100];
    			String ch1;
    			do {
    			System.out.println("Enter ID of item(purchased by customer)-");
    			i1=s1.nextInt();
    			System.out.println("Enter the quantity of item(purchased by customer)-");
    			i2[j]=s1.nextInt();
    			ind[j]=b1.search(i1, 0);
    			//ch=b1.search(i1,0);
    			sum1=(float)(I2[ind[j]].item_price-(I2[ind[j]].item_discount*I2[ind[j]].item_price*0.01));
    			total[j]=sum1*i2[j];
    			sum+=sum1*i2[j];
    		
    			j++;
    			System.out.println("More item purchased? (y/n)-");
    			ch1=s1.next();
    			}while(ch1.contentEquals("y"));
    			System.out.println("_______________________________________________________________________________________________________________________________________________");
    			  
    			System.out.println("\t\tItem Name\t\tQuantity\t\tPrice\t\tDiscount\t\tPrice after discount");
    			for(int i=0;i<j;i++)
    			{
    				
    				System.out.println("\n_______________________________________________________________________________________________________________________________________________");
    			    System.out.print("\n\t\t"+I2[ind[i]].item_name+"\t\t\t"+i2[i]+"\t\t\t"+I2[ind[i]].item_price+"\t\t"+I2[ind[i]].item_discount+"\t\t\t"+total[i]);
    			}
    			System.out.println("\n_______________________________________________________________________________________________________________________________________________");
    			System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tTotal= "+sum+" Rs only/-");
    			System.out.println("_______________________________________________________________________________________________________________________________________________");
    			System.out.println("Total bill of sold items is "+sum+" Rs. only/-");
    		      break;
    	  case 6: // to add more items
    		    String choice;
    		    do {
    		      size++;
    		      I2[size-1]=new Item();
    		      I2[size-1].accept();
    		      b1.create(I2[size-1].item_id,size-1);
    		      System.out.println("Do you want to add more items?(y/n)-");
    		      choice=s1.next();
    		    }while(choice.contentEquals("y"));
    		     System.out.println("\nFor accepted data, BTree formed is as follows- ");
 	             b1.show();
 	             System.out.println("\n___________________________________________________________");
 	             break;
    		    
    	  case 7:
    		     System.out.println("You exited!!");
    	         break;
    			
    	  }
    	  
      }while(option!=7);
    
	}

}


//OUTPUT

/*
  Enter the no. of types of items in a shop-
2

Enter operation-1]Accept 2]Display 3]Search 4]Update 5]Create a Bill 6]Add item 7]Exit
1                                                                          

For item 1 -
__________________________________________________
Item Name: 
Jeans
Item Department: 
clothing
Item ID: 
1234
Item Price: 
900
Is discount applicable on this item?(y/n): 
y
Item Discount(in %): 
20
Item Quantity: 
100
___________________________________________________

For item 2 -
__________________________________________________
Item Name: 
Maggie
Item Department: 
Food
Item ID: 
5566
Item Price: 
65
Is discount applicable on this item?(y/n): 
n
Item Quantity: 
150
___________________________________________________

For accepted data, BTree formed is as follows- 
1234 5566 
___________________________________________________________

Enter operation-1]Accept 2]Display 3]Search 4]Update 5]Create a Bill 6]Add item 7]Exit
2

For item 1 -
__________________________________________
Item Name: Jeans
Item Department: clothing
Item ID: 1234
Item Price: 900.0
Item Discount: 20 %
Item Quantity: 100
__________________________________________

For item 2 -
__________________________________________
Item Name: Maggie
Item Department: Food
Item ID: 5566
Item Price: 65.0
Item Discount: 0 %
Item Quantity: 150
__________________________________________

Enter operation-1]Accept 2]Display 3]Search 4]Update 5]Create a Bill 6]Add item 7]Exit
6
__________________________________________________
Item Name: 
T-shirt
Item Department: 
clothing
Item ID: 
1122
Item Price: 
560
Is discount applicable on this item?(y/n): 
n
Item Quantity: 
175
___________________________________________________
Do you want to add more items?(y/n)-
y
__________________________________________________
Item Name: 
Tea
Item Department: 
Food
Item ID: 
4334
Item Price: 
88
Is discount applicable on this item?(y/n): 
n
Item Quantity: 
100
___________________________________________________
Do you want to add more items?(y/n)-
n

For accepted data, BTree formed is as follows- 
1122 1234 4334 5566 
___________________________________________________________

Enter operation-1]Accept 2]Display 3]Search 4]Update 5]Create a Bill 6]Add item 7]Exit
2

For item 1 -
__________________________________________
Item Name: Jeans
Item Department: clothing
Item ID: 1234
Item Price: 900.0
Item Discount: 20 %
Item Quantity: 100
__________________________________________

For item 2 -
__________________________________________
Item Name: Maggie
Item Department: Food
Item ID: 5566
Item Price: 65.0
Item Discount: 0 %
Item Quantity: 150
__________________________________________

For item 3 -
__________________________________________
Item Name: T-shirt
Item Department: clothing
Item ID: 1122
Item Price: 560.0
Item Discount: 0 %
Item Quantity: 175
__________________________________________

For item 4 -
__________________________________________
Item Name: Tea
Item Department: Food
Item ID: 4334
Item Price: 88.0
Item Discount: 0 %
Item Quantity: 100
__________________________________________

Enter operation-1]Accept 2]Display 3]Search 4]Update 5]Create a Bill 6]Add item 7]Exit
3

Enter the ID of item that you want to SEARCH-
1122
Item Present!
__________________________________________
Item Name: T-shirt
Item Department: clothing
Item ID: 1122
Item Price: 560.0
Item Discount: 0 %
Item Quantity: 175
__________________________________________

Enter operation-1]Accept 2]Display 3]Search 4]Update 5]Create a Bill 6]Add item 7]Exit
3

Enter the ID of item that you want to SEARCH-
1112
Item not present in stock.

Enter operation-1]Accept 2]Display 3]Search 4]Update 5]Create a Bill 6]Add item 7]Exit
4

Enter the ID of item that you want to UPDATE-
4334
Item Present!

Present Details-
__________________________________________
Item Name: Tea
Item Department: Food
Item ID: 4334
Item Price: 88.0
Item Discount: 0 %
Item Quantity: 100
__________________________________________

Enter New Details-
__________________________________________________
Item Name: 
Tea
Item Department: 
grocery
Item ID: 
4334
Item Price: 
88
Is discount applicable on this item?(y/n): 
y
Item Discount(in %): 
5
Item Quantity: 
100
___________________________________________________

Updated Details-
__________________________________________
Item Name: Tea
Item Department: grocery
Item ID: 4334
Item Price: 88.0
Item Discount: 5 %
Item Quantity: 100
__________________________________________

Enter operation-1]Accept 2]Display 3]Search 4]Update 5]Create a Bill 6]Add item 7]Exit
2

For item 1 -
__________________________________________
Item Name: Jeans
Item Department: clothing
Item ID: 1234
Item Price: 900.0
Item Discount: 20 %
Item Quantity: 100
__________________________________________

For item 2 -
__________________________________________
Item Name: Maggie
Item Department: Food
Item ID: 5566
Item Price: 65.0
Item Discount: 0 %
Item Quantity: 150
__________________________________________

For item 3 -
__________________________________________
Item Name: T-shirt
Item Department: clothing
Item ID: 1122
Item Price: 560.0
Item Discount: 0 %
Item Quantity: 175
__________________________________________

For item 4 -
__________________________________________
Item Name: Tea
Item Department: grocery
Item ID: 4334
Item Price: 88.0
Item Discount: 5 %
Item Quantity: 100
__________________________________________

Enter operation-1]Accept 2]Display 3]Search 4]Update 5]Create a Bill 6]Add item 7]Exit
5
Enter ID of item(purchased by customer)-
5566
Enter the quantity of item(purchased by customer)-
2
Item Present!
More item purchased? (y/n)-
y
Enter ID of item(purchased by customer)-
1234
Enter the quantity of item(purchased by customer)-
1
Item Present!
More item purchased? (y/n)-
y
Enter ID of item(purchased by customer)-
4334
Enter the quantity of item(purchased by customer)-
3
Item Present!
More item purchased? (y/n)-
n
_______________________________________________________________________________________________________________________________________________
		Item Name		Quantity		Price		Discount		Price after discount

_______________________________________________________________________________________________________________________________________________

		Maggie			2			  65.0		     0			           130.0
_______________________________________________________________________________________________________________________________________________

		Jeans			1			  900.0		     20			           720.0
_______________________________________________________________________________________________________________________________________________

		Tea			   3			   88.0		      5			          250.79999
_______________________________________________________________________________________________________________________________________________
												                       Total= 1100.8 Rs only/-
_______________________________________________________________________________________________________________________________________________
Total bill of sold items is 1100.8 Rs. only/-

Enter operation-1]Accept 2]Display 3]Search 4]Update 5]Create a Bill 6]Add item 7]Exit
7
You exited!!

*/
