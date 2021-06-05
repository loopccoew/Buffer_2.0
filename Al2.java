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
    
	
    
    /*public Value remove(String in) {
        
     int j=0,flag=1;
     for( j=0;j<size;j++) {
    	 if(values[j].getResidentName().equals(in)) {
    		 flag=0;
    		 break;
    	 }
     }
     if(flag==0)
     {
        Value removedElement = values[j];
        for (int i = j; i <= size ; i++) {
               values[i] = values[i + 1];
        }
        size--; // reduce size of ArrayListCustom after removal of element.

        return removedElement;
     }
     else return null;
    }
    
    */
	private void ensureCapacity() {
        int newIncreasedCapacity = values.length * 2;
        values = Arrays.copyOf(values, newIncreasedCapacity);//increase size of ArrayList
    }
    /*
    public void display() {
    	
        System.out.print("Displaying list : \n");
        for (int i = 0; i < size; i++) {
               System.out.print(values[i].getResidentName() + "  "+ values[i].getPhoneNumber()+",");
        }
    }


	public int getSize() {
		return size;
	}

    */
	public Value getValues(int i) {
		return values[i];

	}
}


