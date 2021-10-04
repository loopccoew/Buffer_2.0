
/**
 * Write a description of food here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */ 
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
public class Food {
    public TreeNode root= new TreeNode("Food");
    public Food(){ 
        root.children[0]=new TreeNode("Packaged");
        root.children[1]=(new TreeNode("Non-Packaged"));
        //adding children to Packaged
        //root.children[1].children[2]
        root.children[0].children[0]=(new TreeNode("Spices"));    //child no. 0 of Packaged
        root.children[0].children[1]=(new TreeNode("Premix"));    //child no. 1 of Packaged
        root.children[0].children[2]=(new TreeNode("Flour"));     //child no. 2 of Packaged
        root.children[0].children[3]=(new TreeNode("Snack"));     //child no. 3 of Packaged

        //adding children to Spices
        root.children[0].children[0].children[0]=(new TreeNode("PavBhajiMasala", 30, 100 ));       //In spices add Pav bhaji 
        root.children[0].children[0].children[1]=(new TreeNode("PaneerTikkaMasala", 35, 100));     //In spices add Paneer mutter
        root.children[0].children[0].children[2]=(new TreeNode("PalakPaneerMasala", 30, 100));     //In spices add Palak Paneer
        root.children[0].children[0].children[3]=(new TreeNode("Pani Puri Masal", 25, 100));        //In spices add Pani puri 

        //adding children to Premix
        root.children[0].children[1].children[0]=(new TreeNode("IdliPremix", 100, 100));    //In Premix add Idli
        root.children[0].children[1].children[1]=(new TreeNode("DosaPremix", 110, 100));    //In Premix add Dosa
        root.children[0].children[1].children[2]=(new TreeNode("CakePremix", 85, 100));     //In Premix add Cake
        root.children[0].children[1].children[3]=(new TreeNode("SoupPremix", 20, 100));     //In Premix add Soup

        //adding children to flour
        root.children[0].children[2].children[0]=(new TreeNode("WheatFlour", 60, 100));    //In Flour add wheat flour
        root.children[0].children[2].children[1]=(new TreeNode("PlainFlour", 50, 100));    //In Flour add Plain flour

        //adding children to snacks
        root.children[0].children[3].children[0]=(new TreeNode("Namkeen", 20, 100));    //In snack add namkeen
        root.children[0].children[3].children[0]=(new TreeNode("MoongDaal", 15, 100));    //In snack add moong daal


        //adding chilgren to Non packaged
        root.children[1].children[0]=(new TreeNode("Pulses"));          //child no 0 of Non-packaged
        root.children[1].children[1]=(new TreeNode("Vegetables"));      //child no 1 of Non-packaged
        root.children[1].children[2]=(new TreeNode("Grains"));          //child no 2 of Non-packaged
        root.children[1].children[3]=(new TreeNode("Fruits"));          //child no 3 of Non-packaged

        //adding children to Pulses
        root.children[1].children[0].children[0]=(new TreeNode("Masur", 60, 100));    //In pulses add masur
        root.children[1].children[0].children[1]=(new TreeNode("Daal", 65, 100));     //In pulses add Daal

        //adding children to Vegetables
        root.children[1].children[1].children[0]=(new TreeNode("Onions", 40, 100));   //In Vegetebles add Onions
        root.children[1].children[1].children[1]=(new TreeNode("Potato", 35, 100));   //In Vegetebles add Potato
        root.children[1].children[1].children[2]=(new TreeNode("Carrots", 45, 50));   //In Vegetebles add Carrots
        root.children[1].children[1].children[3]=(new TreeNode("Spinach", 30, 40));   //In Vegetebles add Spinach

        root.children[1].children[2].children[0]=(new TreeNode("Wheat", 45, 100));    //In Grains add Wheat
        root.children[1].children[2].children[1]=(new TreeNode("Rice", 45, 100));     //In Grains add Rice
        root.children[1].children[2].children[2]=(new TreeNode("Jowar", 50, 100));   //In Grains add Jowar
        root.children[1].children[2].children[3]=(new TreeNode("Oats", 70, 50));     //In Grains add Oats

        //adding children to Fruits
        root.children[1].children[3].children[0]=(new TreeNode("Apple", 100 ,50));    //In Fruits add Apple, price is for 1kg
        root.children[1].children[3].children[1]=(new TreeNode("Orange", 120, 45));   // In Fruits add Orange
        root.children[1].children[3].children[2]=(new TreeNode("Banana", 60, 50));   // In Fruits add Banana
        root.children[1].children[3].children[3]=(new TreeNode("Mango", 400, 50));   // In Fruits add Mango

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

    public static void Main(){
        Food objf=new Food();
        listnode newnode=new listnode();
        newnode=objf.search(objf.root,"PavBhajiMasala",4);
        newnode.display();
    }
    
}

