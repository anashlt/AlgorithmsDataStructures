public class BinarySearchTree<T extends Comparable<T>> {

	//root node of the tree
	Node root;  
	  
	 //defines each node of tree
	 class Node {
		  T value;  
	      Node right,left; 
	   
		  Node(T value){
		     this.value = value;
		  }
	 }
	  

	 //inserts new node in tree
	 public void insert(T value){
	    if(isEmpty())
	       root = new Node(value);  //root node added
	    else
	       insert(root, value);  //if not empty then insert based on root
	 }
	  
	// insert nodes at proper positions
	 private void insert(Node node, T value){
	  if(value.compareTo(node.value) < 0){  //if new value less than parent node
	        if(node.left == null)  //if left null then add
	             node.left = new Node(value);
		    else
	             insert(node.left,value);  //if left not null then recursive call
	  } else if(value.compareTo(node.value) >= 0){  //if new value same or greater than parent node
	      if(node.right == null)  //if right null then add
	          node.right = new Node(value);
	      else
	          insert(node.right,value);  //if right not null then recursive call
	   }
	 }
	  
	 // Returns the value of the root
	 public T peek(){
     	return root.value;
	 }
	  
	 /// Checks if tree is empty or not 
	 public boolean isEmpty(){
	    return (root == null)? true : false;
	 }
}