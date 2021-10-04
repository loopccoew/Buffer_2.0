
/**
 * Write a description of customer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class customer {
    Scanner sc=new Scanner(System.in);
    public String customername;
    public long contact;
    public listnode bill=new listnode();
    public double pay=0;
    public void billing(){
        int chcontinue=0;
        int chbilling=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Choice for billing 1:Purchase Billing 2:Return Billing");
        chbilling=sc.nextInt();
        switch(chbilling){
            case 1: do{

                System.out.println("Enter Category of Items 1.Food 2.Stationery");
                int ch=sc.nextInt();
                switch(ch){
                    case 1:
                    while(true){
                        Food objf=new Food();
                        System.out.println("Enter product Details one by one stating with name");
                        sc.nextLine();
                        String key=sc.nextLine();
                        System.out.println("Enter quantity purchased");
                        double quantity=sc.nextDouble();
                        listnode billnode=objf.search(objf.root,key,quantity);
                        pay+=billnode.price;
                        if(bill==null)
                           bill=billnode;
                        else
                           bill.append(billnode);
                        System.out.println("Enter 0 if all Food items are over else Enter 1");
                        int status=sc.nextInt();
                        if(status==0)
                            break;
                    }
                    break;

                    case 2:
                    while(true){
                        Stationery objs=new Stationery();
                        System.out.println("Enter product Details one by one stating with name");
                        sc.nextLine();
                        String key=sc.nextLine();
                        System.out.println("Enter quantity purchased");
                        double quantity=sc.nextDouble();
                        listnode billnode=objs.search(objs.root,key,quantity);
                        pay+=billnode.price;
                        if(bill==null)
                           bill=billnode;
                        else
                           bill.append(billnode);
                        System.out.println("Enter 0 after all Stationery items are over else Enter 1");
                        int status=sc.nextInt();
                        if(status==0)
                            break;
                    }
                }
                System.out.println("Enter 1 to continue with more category items");
                chcontinue=sc.nextInt();
            }while(chcontinue==1);
            break;
            case 2:  do{
                System.out.println("Enter Category of Items 1.Food 2.Stationery");
                int ch=sc.nextInt();
                switch(ch){
                    case 1:
                    while(true){
                        Food objf=new Food();
                        System.out.println("Enter product Name to be deleted");
                        String del=sc.next();
                        System.out.println("Enter Quantity to Return");
                        double returnq=sc.nextDouble();
                        bill=bill.delete(objf,pay,del,returnq);  
                        System.out.println("Enter 0 if all Food items are over returning else Enter 1");
                        int status=sc.nextInt();
                        if(status==0)
                            break;
                    }
                    break;

                    case 2:
                    while(true){
                        Stationery objs=new Stationery();
                        System.out.println("Enter product Name to be deleted");
                        String del=sc.next();
                        System.out.println("Enter Quantity to Return");
                        double returnq=sc.nextDouble();
                        bill=bill.delete(objs,pay,del,returnq);  
                        System.out.println("Enter 0 if all Food items are over returning else Enter 1");
                        int status=sc.nextInt();
                        if(status==0)
                            break;
                    }
                }
                System.out.println("Enter 1 to continue with more category items");
                chcontinue=sc.nextInt();
            }while(chcontinue!=3);

        }

        bill.display();
        System.out.println("Amount Payable by Customer= Rs."+pay);
    }

    public static void Main(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Let's start Billing!");
        customer c1=new customer();
        sc.nextLine();
        System.out.println("Enter Customer Name");
        c1.customername=sc.nextLine();
        System.out.println("Enter Customer Number");
        c1.contact=sc.nextLong();
        c1.billing();
    }

}

