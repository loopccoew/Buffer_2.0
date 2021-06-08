package trees;
import java.util.Scanner

public class Trie {
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
		  char c=word.charAt(i);
		  if(curr.children[c-'a']==null)
		  {
			  curr.children[c-'a']=new Node(c);
		  }
		  curr=curr.children[c-'a'];
		}
		curr.isWord=true;
		curr.meaning=meaning;
	}
	public void search(String word)
	{
		boolean isPresent=((getNode(word)!=null)&&(getNode(word).isWord));
		if(isPresent)
		{
			System.out.println(getNode(word).meaning);
		}
		else
		{
			System.out.println("Word doesn't exist");
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
	
		public void display(Node root,String word)
		{
			if(root == null)
			{
				return;
			}
			
			if(root.isWord)
			{
				//word=word+root.c;
				System.out.print(word+": "+root.meaning+",");
				
			}
			
			for(int i=0;i<26;i++)
			{
				if(root.children[i] != null)
				{
					word = word + root.children[i].c;
					display(root.children[i], word);	// cat: animal, cdog: animal
					word = word.substring(0, word.length()-1);
				}

			}

			
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
		        for(int n=0;n<26;n++)	//apple and apples 'e' has a node for 's' hence it'll return node otherwise would have returned null
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
			  Scanner sc=new Scanner(System.in);
			  System.out.println("Enter the updated meaning: ");
			  newMeaning=sc.nextLine();
			  getNode(word).setMeaning(newMeaning);
			  System.out.println("Word updated");
		  }
		  else
		  {
			  System.out.println("Sorry you cannot update the word since the Word doesn't exist");
		  }
	  }
	      
	  public void displayWithPrefix(Node root,String prefix)
	  {
	       boolean isPresent=(getNode(word)!=null);
	       if(isPresent)
	       {
	          Node last=getNode(prefix);
		  display(last,prefix);
	       }
	   }
}

