
/**
 * Write a description of Treenode here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class TreeNode {
    

 
        public String name;
        public TreeNode[] children=new TreeNode[10];
        public double priceOfProduct;
        public double stockOfProduct;
        public TreeNode( String Name)
        {
            this.priceOfProduct =0;
            this.stockOfProduct =0;
            this.name = Name;
            this.children=new TreeNode[10];
        }
        
        
        
        
        
        public TreeNode(String ProductName, double ProductPrice, double ProductStock)
        {
            this.priceOfProduct = ProductPrice;
            this.stockOfProduct = ProductStock;
            this.name = ProductName;
            
        }
        
       
    
    
}
