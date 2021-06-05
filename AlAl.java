package logic;

import java.util.Arrays;

public class AlAl {
	private static final int INITIAL_CAPACITY = 5;
    private int size ;
	private Value2[] values2 ;//***
    
	public AlAl() {
	
		this.values2= new Value2[INITIAL_CAPACITY];
		for(int i=0;this.values2[i]!=null;i++) 
			size=i+1;
	}
	
	
	public void add(Value2 obj) {
		
       if ( size == values2.length) {
               ensureCapacity(); //calling function to double size	
        }
        
        this.values2[size++] =  obj;
    }

	private void ensureCapacity() {
        int newIncreasedCapacity = values2.length * 2;// increase current capacity of list, make it double.
        values2 = Arrays.copyOf(values2, newIncreasedCapacity);
    }
    
	public Value2 getValues2(int i) {
		return values2[i];

	}
}