package logic;


import java.util.*;
//import java.lang.*;

public class HashMap2 {
	//@SuppressWarnings("unchecked")//////////////////////////////
	LinkedList<Entry2>[] hashmap2 = new LinkedList[2];
	int size=0;//size==hashmap.length() !=hashmap.length
	public HashMap2() {
		
	}
	public int getIndex(Key2 key2) {
		return key2.hashCode()&0x7FFFFFFF;
	}
	
	public int size() {
		return size;
	}
	
	//@SuppressWarnings("unchecked")/////////////////////////////////
	public void resize() {
		LinkedList<Entry2>[] oldhashmap2 = hashmap2;
		hashmap2 = new LinkedList[size*2];
		size = 0;
		for(int i=0;i<oldhashmap2.length;i++) {
			if(oldhashmap2[i]==null)
				continue;
			for(Entry2 entry2 : oldhashmap2[i]) {
				put(entry2.key2,entry2.value2);
			}
		}
		
	}
	
	public void put(Key2 key2, Value2 value2) {
		if(size>=hashmap2.length) {
			resize();
		}
		int ix=getIndex(key2)%hashmap2.length;
		if(hashmap2[ix]==null) {
			hashmap2[ix] = new LinkedList<>();
			hashmap2[ix].add(new Entry2(key2, value2));
			size++;
			return;
		}
		else {
			for(Entry2 entry2 : hashmap2[ix]) {
				if(entry2.key2.equals(key2)) {
					entry2.value2 = value2;
					//size++;
					return;
				}
			}
			hashmap2[getIndex(key2)%hashmap2.length].add(new Entry2(key2, value2));
			//no size++ because we are adding a node to the existing linked list at [ix] calculated 
			//and not adding a diff linked list
			return;
		}
		
	}
	
	public Value2 get(Key2 key2) {
		int ix= getIndex(key2)%this.hashmap2.length;
		if(this.hashmap2[ix] ==null) {
			return null;
		} 
		
		for(int j=0;j<this.hashmap2[ix].size();j++){
			if(key2.getHname_type().equalsIgnoreCase(this.hashmap2[ix].get(j).getKey2().getHname_type())){
				return this.hashmap2[ix].get(j).getValue2();
			}		
		}
		return null;
	    
	}
	
	public void remove(Key2 key2){ 
		if(key2 == null) {
			return;
		}
        int ix = getIndex (key2) % hashmap2.length;
	    if(hashmap2[ix] == null) return;
	    Entry2 toRemove = null;
	    for (Entry2 entry2 : hashmap2[ix]) { 
	    	if(entry2.key2.equals(key2)) {
	    		toRemove = entry2;
	    		break;
	    	}
	    }
	    if (toRemove == null) return;
	    hashmap2[ix].remove(toRemove);
	}
	@Override
	public String toString() {//for Displaying 
		return "HashMap2 [hashmap2=" + Arrays.toString(hashmap2) + ", size=" + size + "]";
	}
	
    

}
