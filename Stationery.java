
/**
 * Write a description of Stationery here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;




 public class Stationery {
    static TreeNode root = new TreeNode("STATIONARY");
    public Stationery(){ 
    Scanner sc=new Scanner(System.in);
     
        
       
          
            root.children[0] = (new TreeNode("NOTEBOOK"));
            root.children[1] = (new TreeNode("PEN"));
            root.children[2] = (new TreeNode("PENCIL"));
           
           
            root.children[0].children[0] = (new TreeNode("CLASSMATENOTEBOOK",50,60));
            root.children[0].children[1] = (new TreeNode("SUNDRAMNOTEBOOK",45,70));
            root.children[0].children[2] = (new TreeNode("FIVESTARNOTEBOOK",45,70));
           
             root.children[1].children[0] = (new TreeNode("BLUE"));
             root.children[1].children[1] = (new TreeNode("BROWN"));
             root.children[1].children[2] = (new TreeNode("RED"));

            root.children[1].children[0].children[0] = (new TreeNode("MONTEXBLUEPEN",30,50));
            root.children[1].children[0].children[1] = (new TreeNode("REYNOLDSBLUEPEN",20,60));
            root.children[1].children[0].children[2] = (new TreeNode("BALLPOINTBLUEPEN",20,80));

            root.children[1].children[1].children[0] = (new TreeNode("MONTEXBROWNPEN",30,50));
            root.children[1].children[1].children[1] = (new TreeNode("REYNOLDSBROWNPEN",20,60));
            root.children[1].children[1].children[2] = (new TreeNode("BALLPOINTBROWNPEN",20,80));

            root.children[1].children[2].children[0] = (new TreeNode("MONTEXREDPEN",30,50));
            root.children[1].children[2].children[1] = (new TreeNode("REYNOLDSREDPEN",20,60));
            root.children[1].children[2].children[2] = (new TreeNode("BALLPOINTREDPEN",20,80));
           
           
           
            root.children[2].children[0] = (new TreeNode("CAMLINPENCIL",10,70));
            root.children[2].children[1] = (new TreeNode("APSARAPENCIL",20,80));
            root.children[2].children[2] = (new TreeNode("NATARAJPENCIL",30,56));
      }
        
    public listnode search(TreeNode root,String key,double purchasequantity){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter next Sub Category in order");
        String key1=sc.next();
        try{

            int count=0;
            for(int i=0;i<root.children.length;i++){

                if(root.children[i].name.compareToIgnoreCase(key1)==0)
                {   
                    if(key1.equalsIgnoreCase(key)){

                        listnode newnode=new listnode();
                        newnode.rate=root.children[i].priceOfProduct;
                        //System.out.println("Rate " +root.children[i].priceOfProduct);
                        newnode.quantity=purchasequantity;
                        //System.out.println("Quantity " +purchasequantity);
                        newnode.price=newnode.rate*newnode.quantity;
                        //System.out.println("Price " +newnode.rate*newnode.quantity);
                        root.children[i].stockOfProduct-=purchasequantity;
                        //System.out.println("Quantity left" +root.children[i].stockOfProduct);
                        newnode.itemname.append(key1+"\t");
                        return newnode;
                    }

                    else{
                        listnode newnode=new listnode();
                        newnode=search(root.children[i],key,purchasequantity);
                        newnode.itemname.append(key1+"\t");
                        return newnode;
                    }
                }

            }

        } 
        catch(NullPointerException e){
            System.out.println("Null Pointer exception Caught");

        }
        listnode newnode=new listnode();
        return newnode;
    }

    public void delete(TreeNode root,String key,double returnquantity){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter next Sub Category in order");
        String key1=sc.next();
        try{

            int count=0;
            for(int i=0;i<root.children.length;i++){

                if(root.children[i].name.compareToIgnoreCase(key1)==0)
                {   
                    if(key1.equalsIgnoreCase(key)){

                       
                        
                        
                        root.children[i].stockOfProduct=root.children[i].stockOfProduct+returnquantity;
                        
                        return ;
                    }

                    else{

                        search(root.children[i],key,returnquantity);

                        return ;
                    }
                }

            }

        } 
        catch(NullPointerException e){
            System.out.println("Null Pointer exception Caught");

        }

        return;

    }
    
    
    
    
}


