
/**
 * Write a description of listnode here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class listnode {
    public listnode next;
    public listnode prev;
    public StringBuilder itemname=new StringBuilder();
    public double price=0;
    public double quantity=0;
    public double rate=0;
    public listnode(){
        
    }
    
    
    
    public void finalize(){
    }
    
    public void append(listnode end){
        listnode temp=this;
        while(temp.next!=null){
            temp=temp.next;
        }
        end.prev=temp;
        temp.next=end;
        end.next=null;
        
    }
    
    public void display(){
        listnode temp=this;
        while(temp!=null){
        System.out.print(temp.itemname+"\t");
        System.out.print(temp.rate+"\t");
        System.out.print(temp.price+"\t");
        System.out.print("\n");
        temp=temp.next;
    }
    }
    
      public listnode finddeletenode(Food objf,String key,double returnquantity){
        listnode temp=this;
        while(temp!=null){
        if(temp.itemname.toString().contains(key)){
            objf.delete(objf.root,key,returnquantity);
            return temp;
        }
    }
    return temp;
    }
    
         public listnode finddeletenode(Stationery objs,String key,double returnquantity){
            listnode temp=this;
            while(temp!=null){
            if(temp.itemname.toString().contains(key)){
                objs.delete(objs.root,key,returnquantity);
                return temp;
            }
        }
        return temp;
        }
        
    public listnode delete(Food objf,double pay,String key,double returnquantity){
            listnode find=finddeletenode(objf,key,returnquantity);
            pay-=find.price;
            if(find==this){
            listnode l2=new listnode();
            listnode temp=this.next.next;
            while(temp!=null){
                l2.append(temp);
            }
            this.finalize();
            return l2;
            }
        else{
            listnode temp=this;
            while(temp.next!=null){
                if(temp==find){
                    listnode del =temp.next;
                    temp.next=temp.next.next;
                    temp.next.prev=del.prev;
                    return this;
                }
                
                temp=temp.next;
            }
        }
        return this;
    }
    
    public listnode delete(Stationery objs,double pay,String key,double returnquantity){
            listnode find=finddeletenode(objs,key,returnquantity);
            pay-=find.price;
            if(find==this){
            listnode l2=new listnode();
            listnode temp=this.next.next;
            while(temp!=null){
                l2.append(temp);
            }
            this.finalize();
            return l2;
            }
        else{
            listnode temp=this;
            while(temp.next!=null){
                if(temp==find){
                    listnode del =temp.next;
                    temp.next=temp.next.next;
                    temp.next.prev=del.prev;
                    return this;
                }
                
                temp=temp.next;
            }
        }
        return this;
    }
} 