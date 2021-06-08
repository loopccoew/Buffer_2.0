package logic;
import trees.Trie;
import trees.Node;

import java.util.Scanner;

public class Dictionary {
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
				
				System.out.println("Enter your choice");
				System.out.println("1. INSERT A WORD");
				System.out.println("2. SEARCH A WORD");
				System.out.println("3. DELETE A WORD");
				System.out.println("4. UPDATE MEANING OF A WORD");
				System.out.println("5. DISPLAY WITH A PREFIX");
				System.out.println("6. DISPLAY ALL THE WORDS");
				System.out.println("0. EXIT");
				System.out.println("Enter choice : \n");
				if(sc.hasNextInt())
				{
				choice = sc.nextInt();
				}
				
			}while(choice<0 || choice>6);
			
			switch(choice)
			{
				case 1 :
							System.out.println("Enter the number of words you want to insert: ");
							if(sc.hasNextInt())
							{
							n =sc.nextInt();
							for(int i=0;i<n;i++)
							{
								System.out.println("Enter the word: ");
								String word;
								word=sc.next();
								System.out.println("Enter the meaning: ");
								String meaning;
								meaning=sc.next();
								Dictionary.insert(word,meaning);
							  }
							}
							  break;
							 
				case 2 : 
					
						   System.out.println("Enter the word you want to search: ");
						   String searchWord;
						   searchWord=sc.next();
						   Boolean search = false;
						   search = Dictionary.search(searchWord);
						   if(!search)
						   {
							   System.out.println("Word doesn't exist");
						   }
						   break;
				
				case 3 : 
						   System.out.println("Enter the word you want to delete: ");
						   String deleteWord;
						   deleteWord=sc.next();
						   Boolean delete = false;
						   delete = Dictionary.delete(deleteWord);
						   if(delete)
						   {
							   System.out.println("Word deleted");
						   }
						   else
						   {
							   System.out.println("Word doesn't exist");
						   }	
						   break;
						   
				case 4 :
						   String updateWord;
						   System.out.println("Enter the word to be updated ");
						   updateWord = sc.next();
						   Dictionary.update(Dictionary.getRoot(), updateWord);
						   break;
					
				case 5 : 
						   String prefixWord;
						   System.out.println("Enter the prefix :");
						   prefixWord = sc.next();
						   Dictionary.displayWithPrefix(Dictionary.getRoot(), prefixWord);
						   break;
				
				case 6 : 
						   String word=" ";
						   if(Dictionary.getRoot() == null)
						   {
							   Dictionary.display(Dictionary.getRoot(),word);
						   }
						   else
						   {
							   System.out.println("No words in the dictionary");
						   }
							   break;
							   
				case 0 :
							break;
						   
				default :
							System.out.println("Invalid input");
							break;
						 
			}
			
		}while(choice != 0);
	   	   
	   sc.close();
	   
	}
	}

}
