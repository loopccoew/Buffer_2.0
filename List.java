package Package1;

public class List 
{
	public Cake head;
	public List()
	{
		head=null;
	}
	public void insert(int cakeID,String cake_type,String cake_flavour,String cake_shape,double cake_price,double cake_weight)
	{
		Cake n=new Cake(cakeID,cake_type,cake_flavour,cake_shape,cake_price,cake_weight);
		if(head==null)
		{
			head=n;	
		}
		else
		{
			Cake temp=head;
			while(temp.next!=null)
			{
				temp=temp.next;
			}
			temp.next=n;
			n.prev=temp;		}
	}
	public int delete(int productID)
	{
		Cake temp=head;
		int flag=0;
		
		while(temp!=null)
		{  
			if(temp==head && temp.cakeID==productID && temp.next!=null)
			{
				head=temp.next;
				head.prev=null;
				temp=null;
				flag=1;
				break;
			}
			if(temp==head && temp.cakeID==productID && temp.next==null)
			{
				head=null;
				flag=1;
				break;
			}
			if(temp.cakeID==productID && temp.next!=null)
			{
				temp.prev.next=temp.next;
				temp.next.prev=temp.prev;
				temp=null;
				flag=1;
				break;
			}
			if(temp.cakeID==productID && temp.next==null)
			{
				temp.prev.next=null;	
				temp=null;
				flag=1;
				break;
			}
			temp=temp.next;
		}
		return flag;
	}
	public void display()
	{
		Cake temp=head;
		System.out.println("Product ID\tCake Type\t\tFlavour\t\tShape\t\tPrice\t\tWeight");
		while(temp!=null)
		{
			System.out.println(temp.cakeID + "\t\t" +temp.cake_type + "\t\t" + temp.cake_flavour+
					"\t\t"+temp.cake_shape+"\t\t"+temp.cake_price +"\t\t"+temp.cake_weight);
			temp=temp.next;
		}
	}
	Cake partition(Cake left,Cake right)
	{
		Cake pivot=right;
		Cake i=left.prev;
		for(Cake temp=left;temp!=right;temp=temp.next)
		{
			if(pivot.cake_price>=temp.cake_price)
			{
				i=(i==null)?left:i.next;
				swap(temp,i);
			}
		}
		i=(i==null)?left:i.next;
		swap(pivot,i);
		return i;
	}
	public void QuickSort(Cake left,Cake right)
	{
		if(right!=null && left!=right && left!=right.next)
		{
			Cake p=partition(left,right);
			QuickSort(left,p.prev);
			QuickSort(p.next,right);
		}
	}
	void swap(Cake node1,Cake node2)
	{
		String cake_type,cake_flavour,cake_shape;
		int cakeID;
		double cake_price,cake_weight;
		cakeID=node1.cakeID;
		cake_type=node1.cake_type;
		cake_flavour=node1.cake_flavour;
		cake_shape=node1.cake_shape;
		cake_price=node1.cake_price;
		cake_weight=node1.cake_weight;
		node1.cakeID=node2.cakeID;
		node1.cake_type=node2.cake_type;
		node1.cake_flavour=node2.cake_flavour;
		node1.cake_shape=node2.cake_shape;
		node1.cake_price=node2.cake_price;
		node1.cake_weight=node2.cake_weight;
		node2.cakeID=cakeID;
		node2.cake_type=cake_type;
		node2.cake_flavour=cake_flavour;
		node2.cake_shape=cake_shape;
		node2.cake_price=cake_price;
		node2.cake_weight=cake_weight;
	}
} 