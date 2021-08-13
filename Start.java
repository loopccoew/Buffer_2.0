package Hospital;
import java.util.Scanner;
public class Start {
	public static void StartHms() {
		  int c=0;
		  @SuppressWarnings("resource")
		  Scanner input = new Scanner(System.in);
		  char YesOrNo = 'Y';
		  while (YesOrNo  =='Y'){
		   
		   System.out.print("\t\t     ============================\n");
		   System.out.print("\t\t     Welcome To Hospital Managment \n");
		   System.out.print("\t\t               System           \n"); 
		   if(c==0)
		   {
		    c++;
		   }
		   else
		   {
		    System.out.print("\t\t        Again\n");
		   }
		   System.out.print("\t\t     ============================\n");
		   Hospital obj_hosptl=new Hospital();
		   obj_hosptl.start();
		   System.out.println("\n\tDo u want to Continue \n\t\tY = Continue Again\n\t\tN = Exit\n");
		   System.out.println("You Select : ");
		   YesOrNo =(input.next()).charAt(0);
		   if(Character.isLowerCase(YesOrNo )){
		    YesOrNo =Character.toUpperCase(YesOrNo );
		   }
		  }//End While
		 }
}
