package trees;


public class Node {
	 char c;
		boolean isWord;
		Node[] children;
		String meaning;
		
		public Node(char c)
		{
			this.c=c;
			isWord=false;
			children=new Node[26];
		}
	public void setMeaning(String newMeaning)
	{
		this.meaning=newMeaning;
	}

}
