# Dictionary in Java
The following project implements a dictionary using Java.
Functionality available:
1. Adding a word to dictionary along with its meaning
2. updating a word's meaning
3. Delete a word and its meaning
4. search for a word's meaning


Data Structure Used:
The data structure used to add words is **Trie**. It is an efficient information reTRIEval data structure. The other option to realize a
dictionary would be binary search trees, but a well balanced BST will need time proportional to M * log N, where M is maximum string
length and N is number of keys in tree.Using Trie, we can search the key in O(M) time.

Since a dictionary is often used to search meanings of words, we chose to favor time complexity instead of space and went ahead with
tries. 

Code Design Paramters:
The trie node looks like this:
```
public class Node 
{
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
```
Here, each node has 26 children! thats a lot of children for a node. And a lot of space. But this much space REALLY helps us reduce
that searching time complexity from O(M * log N) down to  O(M) time, where M is length of word and N is number of keys. Plus, 
Tries are more space efficient when they contain a large number of short keys, because nodes are shared between keys with common 
initial subsequences. So, when it comes to handling large amounts of data, trie is our obvious winner.

Outcomes:
1. A new data structure - trie
2. 



References:
Data Structures and Algorithms Made Easy in Java- Book
https://thenextcode.wordpress.com/2015/04/12/trie-vs-bst-vs-hashtable/
https://www.geeksforgeeks.org/trie-insert-and-search/
