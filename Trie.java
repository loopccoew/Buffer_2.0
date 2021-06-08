package logic;
import java.util.Scanner;

public class Trie 
{
		private Node root;

		public Trie()
		{
			root=new Node('\0');
		}
		
		public Node getRoot() {
			return root;
		}

		public void insert(String word,String meaning)
		{
			Node curr=root;
			for(int i=0;i<word.length();i++)
			{
			  char ch=word.charAt(i);
			  if(curr.children[ch-'a']==null)
			  {
				  curr.children[ch-'a']=new Node(ch);
			  }
			  curr=curr.children[ch-'a'];
			}
			curr.isWord=true;
			curr.meaning=meaning;
		}
		
		public Boolean search(String word)
		{
			boolean isPresent= false;
			isPresent = ((getNode(word)!=null)&&(getNode(word).isWord));
			if(isPresent)
			{
				System.out.println("\n Word found!!\n");
				System.out.print(" Meaning of " + word + " is : ");
				System.out.println(getNode(word).meaning);
			}
			return isPresent;
		}
		

		public void display(Node root,String word)
		{
			if(root == null)
			{
				return;
			}
			
			if(root.isWord)
			{
				//word=word+root.c;
				System.out.println("\n" + word+" : "+root.meaning);
				
			}
			
			for(int i=0;i<26;i++)
			{
				if(root.children[i] != null)
				{
					word = word + root.children[i].c;
					display(root.children[i], word);	
					word = word.substring(0, word.length()-1);
				}

			}

			
		}
		
		private Node getNode(String word)
		{
			Node curr=root;
			for(int i=0;i<word.length();i++)
			{
				char a=word.charAt(i);
				if(curr.children[a-'a']==null)
				{
					return null;
				}
				curr=curr.children[a-'a'];
			}
			return curr;
		}
		
		public Boolean delete(String word)
		{
			boolean isPresent = false;
			isPresent = ((getNode(word)!=null)&&(getNode(word).isWord));
			if(isPresent)
			{
				deleteWord(root, word, 0);
				return true;
			}
			else
			{
				return false;
			}
		}
		
		   private Node deleteWord(Node node, String word, int i)
		   {
		        if (i == word.length())	//if end of word is reached
		        {
		            node.isWord = false;
		        } 
		        else 
		        {
		            int index = word.charAt(i) - 'a';
		            node.children[index] = deleteWord(node.children[index], word, i + 1);
		        }
		        if (node.isWord) 
		        {
		            return node;
		        }		        
		        for(int n=0;n<26;n++)	
		        {
		        	if(node.children[n] != null)
		        	{
		        			return node;
		        	}
		        }
		        return null;
		    }
		   
		  	  

		   	  public void update(Node root,String word)
		   	  {
		   		  boolean isPresent=((getNode(word)!=null)&&(getNode(word).isWord));
		   		  if(isPresent)
		   		  {
		   			  String newMeaning;
		   			  Scanner sc = new Scanner(System.in);
		   			  System.out.print("\n Enter the updated meaning : ");
		   			  newMeaning=sc.nextLine();
		   			  getNode(word).setMeaning(newMeaning);
		   			  System.out.println(" Word updated");
		   			  //sc.close();
		   		  }
		   		  else
		   		  {
		   			  System.out.println(" Sorry you cannot update the word since the word doesn't exist");
		   		  }
		   		  
		   	  }
		   	      
		   	  public void displayWithPrefix(Node root,String prefix)
		   	  {
		   	       boolean isPresent=(getNode(prefix)!=null);
		   	       if(isPresent)
		   	       {
		   	          Node last=getNode(prefix);
		   	          display(last,prefix);
		   	       }
		   	   }
		   

}

