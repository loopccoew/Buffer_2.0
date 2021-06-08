package Package1;

public class Cake
{
	String cake_type,cake_flavour,cake_shape;
	public int cakeID;
	public double cake_price,cake_weight;
	public Cake next,prev;
	
	public Cake(int cakeID,String cake_type,String cake_flavour,String cake_shape,double cake_price,double cake_weight)
	{
		this.cakeID=cakeID;
		this.cake_type=cake_type;
		this.cake_flavour=cake_flavour;
		this.cake_shape=cake_shape;
		this.cake_price=cake_price;
		this.cake_weight=cake_weight;
		prev=null;
		next=null;
	}
	public String getCake_type() {
		return cake_type;
	}
	public void setCake_type(String cake_type) {
		this.cake_type = cake_type;
	}
	public String getCake_flavour() {
		return cake_flavour;
	}
	public void setCake_flavour(String cake_flavour) {
		this.cake_flavour = cake_flavour;
	}
	public String getCake_shape() {
		return cake_shape;
	}
	public void setCake_shape(String cake_shape) {
		this.cake_shape = cake_shape;
	}
	public int getCakeID() {
		return cakeID;
	}
	public void setCakeID(int cakeID) {
		this.cakeID = cakeID;
	}
	public double getCake_price() {
		return cake_price;
	}
	public void setCake_price(int cake_price) {
		this.cake_price = cake_price;
	}
	public double getCake_weight() {
		return cake_weight;
	}
	public void setCake_weight(int cake_weight) {
		this.cake_weight = cake_weight;
	}
	public Cake getNext() {
		return next;
	}
	public void setNext(Cake next) {
		this.next = next;
	}
	public Cake getPrev() {
		return prev;
	}

	public void setPrev(Cake prev) {
		this.prev = prev;
	}
}