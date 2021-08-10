package logic;


import java.util.Scanner;

import logic.Trie;

public class Dictionary
{
	public static void main(String [] args) 
	{
	   
		int choice = 0;
		Trie Dictionary=new Trie();
		Scanner sc=new Scanner(System.in);
		int n = 0;
		
		do
		{
			
			do
			{
				
				System.out.println("\n\tM E N U");
				System.out.println("*******************************");
				System.out.println("1. INSERT A WORD");
				System.out.println("2. SEARCH A WORD");
				System.out.println("3. DELETE A WORD");
				System.out.println("4. UPDATE MEANING OF A WORD");
				System.out.println("5. DISPLAY WITH A PREFIX");
				System.out.println("6. DISPLAY ALL THE WORDS");
				System.out.println("0. EXIT");
				System.out.println("*******************************");
				System.out.print("Enter choice : ");
				if(sc.hasNextInt())
				{
				choice = sc.nextInt();
				}
				
			}while(choice<0 || choice>6);
			
			switch(choice)
			{
				case 1 :
							System.out.print("\n Enter the number of words you want to insert : ");
							
							n =sc.nextInt();
							for(int i=0;i<n;i++)
							{
								System.out.print("\n Enter the word: ");
								String word;
								word=sc.next();
								System.out.print("\n Enter the meaning: ");
								String meaning;
								meaning=sc.next();
								Dictionary.insert(word,meaning);
								System.out.println("\n-----------------------------");
							  }
							
							  break;
							 
				case 2 : 
					
						   System.out.print("\n Enter the word you want to search : ");
						   String searchWord;
						   searchWord=sc.next();
						   Boolean search = false;
						   search = Dictionary.search(searchWord);
						   if(!search)
						   {
							   System.out.println("\n Word doesn't exist");
						   }
						   System.out.println("\n-----------------------------");
						   break;
				
				case 3 : 
						   System.out.print("\n Enter the word you want to delete: ");
						   String deleteWord;
						   deleteWord=sc.next();
						   Boolean delete = false;
						   delete = Dictionary.delete(deleteWord);
						   if(delete)
						   {
							   System.out.println(" Word deleted successfully!!");
						   }
						   else
						   {
							   System.out.println("\n Word doesn't exist!");
						   }	
						   System.out.println("\n-----------------------------");
						   break;
						   
				case 4 :
						   String updateWord;
						   System.out.print("\n Enter the word to be updated : ");
						   updateWord = sc.next();
						   Dictionary.update(Dictionary.getRoot(), updateWord);
						   System.out.println("\n-----------------------------");
						   break;
					
				case 5 : 
						   String prefixWord;
						   if(Dictionary.getRoot() != null)
						   {
							   System.out.println("\n Enter the prefix :");
							   prefixWord = sc.next();
							   Dictionary.displayWithPrefix(Dictionary.getRoot(), prefixWord);
						   }
						   else
						   {
							   System.out.println("\n Dictionary is empty!");
						   }
						   System.out.println("\n-----------------------------");
						   break;
				
				case 6 : 
						   String word=" ";
						   if(Dictionary.getRoot() != null)
						   {
							   Dictionary.display(Dictionary.getRoot(),word);
						   }
						   else
						   {
							   System.out.println(" No words in the dictionary");
						   }
						   System.out.println("\n-----------------------------");
						   break;
							   
				case 0 :
							break;
						   
				default :
							System.out.println("Invalid input");
							System.out.println("\n-----------------------------");
							break;
						 
			}
			
		}while(choice != 0);
	   	   
	   sc.close();
	   
	}	
	
}

