# Buffer_2.0

TOPIC : Clothing Store



TEAM MEMBERS : 
 1. Shwetali Jadhav (T.Y. IT),
 2. Sampada Nemade (T.Y. IT),
 3. Shravani Zope (T.Y. Comp)



INTRODUCTION : 

This program works as an offline clothing store. 
We have enlisted various categories according to which a 
customer can choose and buy products.
  Features :
  * Displaying categories of products, 
  * Choosing a product,
  * Adding it to cart,
  * Option for removal of a product from cart before billing,
  * Billing (with GST),
  * Exit



OBJECTIVE OF THE PROJECT :

Enabling easy and efficient funtioning of an offline clothing 
store reducing its dependency on manual work. The data i.e products 
along with their details are stored in the system. 
Products can be added or removed from the system as and when required.



DATA STRUCTURE :

Initially, we tried using a nested structure which comprised of 
ArrayLists within ArrayLists. But accessing products was tedious.
Hence we used HASHMAPS instead.

  HASHMAPS:
  * Java HashMap class implements the Map interface which 
    allows us to store key and value pair, where keys should 
    be unique. 
  * It is easy to perform operations using the key index like 
    updation, deletion, etc. HashMap class is found in the java.util 
    package.
  * HashMap in Java is like the legacy Hashtable class, but it is 
    not synchronized.
  * It allows us to store the null elements as well, but there 
    should be only one null key.
  * Java HashMap contains only unique keys.
  * Java HashMap maintains no order.

We also used ARRAYLISTS for storing the details of the products.

  ARRAYLISTS : 
  * Java ArrayList class uses a dynamic array for storing the 
    elements. 
  * It is like an array, but there is no size limit. We can add 
    or remove elements anytime.
  * So, it is much more flexible than the traditional array. It 
    is found in the java.util package.
  * The ArrayList in Java can have the duplicate elements also. 
    It implements the List interface so we can use all the methods 
    of List interface here.
  * The ArrayList maintains the insertion order internally.
  * Java ArrayList class is non synchronized.

Classes used :

  #Product
   * gender,
   * category,
   * productType,
   * brand,
   * productPrice,
   * productName,
   * productSize
   
  #Item
   * size,
   * name,
   * price



LEARNINGS FROM THIS PROJECT : 

We had an experience working with real life like problem and 
solving it using data structures and algorithms.
We used our theoretical knowledge of data structures and practically
implemented a use case.



WHAT'S NEXT FOR THE PROJECT : 

* We could enable profiles for owner and customer.
* We could connect a database to keep check of stock.
* We could maintain a database for registered users and their 
  purchases as well.





