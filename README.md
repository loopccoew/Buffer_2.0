# Dictionary in Java
The following project implements a dictionary using Java.
Functionality available:
1. Adding a word to dictionary along with its meaning
2. updating a word's meaning
3. Delete a word and its meaning
4. search for a word's meaning


### **Data Structure Used:**

The data structure used to add words is **Trie**. Also known as **Prefix Trees**. Tries have the unique feature that the time to insert or to delete or find is almost identical because the code paths followed are most identical.  It is an efficient information reTRIEval data structure.
There are other alternative data structures that can be used to build and perform these operations on a dictionary. The most significant one being BST.
We used Trie over BST for the following reasons:
* In trie looking up a key of length m takes worst case O(m) time. On the other hand a well balanced BST performs O((logn)) comparisons of keys where n is the number of elements in the tree.Hence is the worst case a BST will need time proportional to M * log N, where M is maximum string
length and N is number of keys in tree. Using Trie, we can search the key in O(M) time.
* Another huge advantage of Trie over the other considerable Data Structure HashTable is printing out all the words in alphabetical order.
* An efficient prefix search is also possible through Tries.
Since a dictionary is often used to search meanings of words, we chose to favor time complexity instead of space and went ahead with
tries. 

### **Code Design Parameters:**

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

### **Outcomes:**

1. A new Data Structure- Trie - As students who have predominantly coded in C throughout the first two years of college, picking up a new language and a data structure that we weren't acquainted with was exciting and challenging. At a glance while Trie appeared to be a way more complex tree than the other trees, as we digged deeper we discovered the varied functionality of this data structure and why it is used more so for projects where large datasets are used. It makes their access and serach easier.  
2. Understanding time and space complexitites better-  We made a head to head comparsion of time complexities of varied data structures that could perform the same operations and then made an informed choice based on our observation. This has helped us greatly in understanding the paramount importance of time complexity in projects like these. The project has made us more intuitive and familair with the role of space and time complexity.
3. Working in a team along with fellow classmated beyond the classroom also has been a great experience. 

### **What's next for the project**

We aim to improvise on the code and make in user friendly by incorporating Java Swing to enhance the real time effect. We also mean to import datasets using SQL and make the dictionary user-ready

### **References:**

1. Data Structures and Algorithms Made Easy in Java- Book

2. https://thenextcode.wordpress.com/2015/04/12/trie-vs-bst-vs-hashtable/
3. https://www.geeksforgeeks.org/trie-insert-and-search/
4. https://www.baeldung.com/trie-java#:~:text=In%20a%20trie%2C%20every%20node,of%20the%20trie%20as%20well
5. https://gist.github.com/prettymuchbryce/3719435/868ae3231e98b3bde667a9e899157e20dd58c366
6. https://www.geeksforgeeks.org/implement-a-dictionary-using-trie/
