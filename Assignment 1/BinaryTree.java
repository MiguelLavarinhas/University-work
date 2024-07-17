/**
 * This class contains a list of Node objects which store data of generic type and has methods to access and manipulate data in the nodes.
 *
 * @param <T> The data stored in each Node(extends comparable).
 * @author Miguel Lavarinhas
 * @version 1.0
 * @since 25/02/2024
 */
 public class BinaryTree <T extends Comparable>
{
   /**
    * The count used in postOrder() to see how many statements were found that match the term.
    */
   int count = 0;
   /**
    * The first Node or root of the tree.
    */
   private BinaryTreeNode<T> root;
   /**
    * Constructs a binary tree without a root.
    */
   public BinaryTree(){
      root = null;
   }  
   /**
    * Prints the Node data.
    * @param node Node visited.
    */
   public void visit ( BinaryTreeNode<T> node )
   {
      System.out.println (node.data);
   }
   /**
    * Finds the node with the same data as the parameter data.
    * @param d The data to find.
    * @return The node which has the same data or null if it does not exist.
    */
   public BinaryTreeNode<T> find ( T d )
   {
      if (root == null)
        return null;
      else
        return find (d, root);
   }
   /**
    * Recursive method to find the node with the same data as the parameter data in the binary tree.
    * @param d The data to find.
    * @param node The root node at first then further on down the path other nodes.
    * @return The node which has the same data or null if it does not exist.
    */
   public BinaryTreeNode<T> find ( T d, BinaryTreeNode<T> node )
   {
      Statement d1 = (Statement)d;
      int cmp = 0;
      //If statement to check if we looking for just a matching term or a term and sentence.
      if(d1.getSentence() == ""){
         cmp = d.compareTo (node.data);
      }else{
         //Checking for mathcing term and sentence.
         Statement d2 = (Statement)node.data;
         cmp = d1.compareTo(d2.getTerm(), d2.getSentence());
      }
      if (cmp == 0)
        return node;
      else if (cmp < 0)
         return (node.left == null) ? null : find (d, node.left);
      else
         return (node.right == null) ? null : find (d, node.right);
   }
      /**
      * Traversal method which starts at root.
      * @param d  Datatype saved in the node.
      */
      public void postOrder (T d)
      {
         postOrder (d,root);
      }
      /**
      * Traversal method which starts at node parameter.
      * @param d  Datatype saved in the node.
      * @param node  Node entered as parameter where traversal starts.
      */
      public void postOrder (T d, BinaryTreeNode<T> node )
      {
         if (node != null)
         {
            Statement s = (Statement)d;
            Statement s2 = (Statement)node.data;
            if(s2.getSentence().toLowerCase().contains(s.getTerm()) ){
               System.out.println("Statement found: "+ s2.getSentence()+ " (Confidence score: "+ s2.getConfidence()+")\n");
               count++;
            }
            postOrder (d,node.getLeft ());
            postOrder (d,node.getRight ());
         }
      }
   /**
      * Insert into Binary Tree method.
      * @param d  Datatype saved in the node.
      */
   public void insert ( T d )
   {
      if (root == null)
         root = new BinaryTreeNode<T> (d, null, null);
      else
         insert (d, root);
   }
   /**
      * Insert method which starts at node parameter and inserts new datatype.
      * @param d  Datatype saved in the node.
      * @param node  Node entered as parameter where search starts for correct insert location.
      */
   public void insert ( T d, BinaryTreeNode<T> node )
   {
      if(d.compareTo(node.data) <=0)
      {
         if (node.left == null)
            node.left = new BinaryTreeNode<T> (d, null, null);
         else
            insert (d, node.left);
      }
      else
      {
         if (node.right == null)
            node.right = new BinaryTreeNode<T> (d, null, null);
         else
            insert (d, node.right);
      }
   }
}
