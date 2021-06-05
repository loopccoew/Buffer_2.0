package logic;
import java.util.*;


public class HashMap {
	@SuppressWarnings("unchecked")
	LinkedList<Entry>[] hashmap = new LinkedList[2];
	int size=0;//size==hashmap.length() !=hashmap.length
	public HashMap() {
		
	}
	public int getIndex(Key key) {//getter method for Index
		return key.hashCode();
	}
	
	public int size() {//method that returns size
		return size;
	}
	
	@SuppressWarnings("unchecked")
	public void resize() {
		LinkedList<Entry>[] oldhashmap = hashmap;
		hashmap = new LinkedList[size*2];//Creating a new LinkedList of double size
		size = 0;
		for(int i=0;i<oldhashmap.length;i++) {
			if(oldhashmap[i]==null)
				continue;
			for(Entry entry : oldhashmap[i]) {
				put(entry.key,entry.value);//copying entries to new hash map
			}
		}
		
	}
	
	public void put(Key key, Value value) {
		if(size>=hashmap.length) {
			resize();//call to resize function when threshold is reached
		}
		int ix=getIndex(key)%hashmap.length;
		if(hashmap[ix]==null) {
			hashmap[ix] = new LinkedList<>();//creating a new LinkedList
			hashmap[ix].add(new Entry(key, value));
			size++;		//Increasing size after adding elements							
			return;
		}
		else {
			for(Entry entry : hashmap[ix]) {
				if(entry.key.equals(key)) {
					entry.value = value;//updating value
					//size++;
					return;
				}
			}
			hashmap[getIndex(key)%hashmap.length].add(new Entry(key, value));//adding elements without replacement
			//no size++ because we are adding a node to the existing linked list at [ix] calculated 
			//and not adding a diff linked list
			return;
		}
		
	}
	
	public Value get(Key key) {
		int ix= getIndex(key)%this.hashmap.length;
		if(this.hashmap[ix] ==null) {
			return null;
		} 
		
		for(int j=0;j<this.hashmap[ix].size();j++){
			if(key.equals(this.hashmap[ix].get(j).getKey())){
				return this.hashmap[ix].get(j).getValue();
			}		
		}
		return null;
	    
	}
	
	public void remove(Key key){ 
		if(key == null) {
			return;
		}
        int ix = getIndex (key) % hashmap.length;
	    if(hashmap[ix] == null) return;
	    Entry toRemove = null;
	    for (Entry entry : hashmap[ix]) { 
	    	if(entry.key.equals(key)) {
	    		toRemove = entry;
	    		break;
	    	}
	    }
	    if (toRemove == null) return;
	    hashmap[ix].remove(toRemove);
	}
	
	@Override
	public String toString() 
	{
		return "HashMap [hashmap=" + Arrays.toString(hashmap) + ", size=" + size + "]";
	}
	
    
}
