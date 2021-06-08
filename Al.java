package logic;
import java.util.Arrays;
	
		public class Al 
		{
		private static final int INITIAL_CAPACITY = 5;
	    private int size ;
		private String[] elementData ;
	    
	    
		public Al() {
		
			this.elementData= new String[INITIAL_CAPACITY];
			for(int i=0;this.elementData[i]!=null;i++) 
				size=i+1;
		}
		
		
		public void add(String name) {
			
	       if ( size == elementData.length) {
	               ensureCapacity(); // increase current capacity of list, make it
	                                                 // double.
	        }
	        
	        this.elementData[size++] = name;
	    }
	    
	    public String remove(String in) {
	        
	     int j=0,flag=1;
	     for( j=0;j<size;j++) {
	    	 if(elementData[j].equals(in)) {
	    		 flag=0;
	    		 break;
	    	 }
	     }
	     if(flag==0)
	     {
	        String removedElement = elementData[j];
	        for (int i = j; i <= size ; i++) {
	               elementData[i] = elementData[i + 1];
	        }
	        size--; // reduce size of ArrayListCustom after removal of element.

	        return removedElement;
	     }
	     else return null;
	    }
	    
	    private void ensureCapacity() {
	        int newIncreasedCapacity = elementData.length * 2;
	        elementData = Arrays.copyOf(elementData, newIncreasedCapacity);
	    }

	    public void display() {
	    	int i=0;
	    	int flag=0;
	    	if(size==1) {
	    	System.out.println(elementData[i] + ".");}
	    	
	    	else {
	        for ( i = 0; i < size; i++) {
	        	
	        	if(i==0)
	        	{
	        		 System.out.print(elementData[i] + "  ");
	        	}
	        	else
	        	{
	        		for(int j=0;j<i;j++)
	        		{
	        			if(elementData[i].equals(elementData[j]))
	        			{
	        				flag=1;
	        				break;
	        			}
	 
	        		}
	        		if(flag==0)
	        		{
	        			System.out.print(elementData[i] +"  ");
	        		}
	        	}
	        	flag=0;
	        
	        }
	    	}
	    }
	    
	    

		public String getElementData(int i) {
			return elementData[i];
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Arrays.hashCode(elementData);
			result = prime * result + size;
			return result;
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof Al)) {
				return false;
			}
			Al other = (Al) obj;
			if (!Arrays.equals(elementData, other.elementData)) {
				return false;
			}
			if (size != other.size) {
				return false;
			}
			return true;
		}


		public int getSize() {
			return size;
		}
		
		public String getString(int i){
			return elementData[i];
		}
		
	}
