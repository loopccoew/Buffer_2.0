package logic;
import java.util.Arrays;

public class Al2 {
	private static final int INITIAL_CAPACITY = 5;
    private int size ;
	private Value[] values ;
    
	public Al2() 
	{
		this.values= new Value[INITIAL_CAPACITY];
		for(int i=0;this.values[i]!=null;i++) 
			size=i+1;
	}
	
	
	public void add(Value obj) {
		
       if ( size == values.length) {
               ensureCapacity(); 			// increase current capacity of list, make it double.
        }
        
        this.values[size++] =  obj;
    }
    
	
    
    
	private void ensureCapacity() {
        int newIncreasedCapacity = values.length * 2;
        values = Arrays.copyOf(values, newIncreasedCapacity);//increase size of ArrayList
    }
    
	public Value getValues(int i) {
		return values[i];

	}
}


