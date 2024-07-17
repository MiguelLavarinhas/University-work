/**
 * This generic class creates Node objects to be used in the Binary Tree class.
 *
 * @author Miguel Lavarinhas
 * @version 1.0
 * @since 25/02/2024
 */
public class BinaryTreeNode<T extends Comparable<T>> 
{
   /**
    * The data stored in the Node.
    */
   T data;
   /**
    * The Node to the left of this Node.
    */
   BinaryTreeNode<T> left;
   /**
    * The Node to the right of this Node.
    */
   BinaryTreeNode<T> right;

   int height;
   /**
    * Constructor for Node object.
    * @param d The data stored in the Node.
    * @param l The Node to the right.
    * @param r The Node to the right.
    */
   public BinaryTreeNode ( T d, BinaryTreeNode<T> l, BinaryTreeNode<T> r )
   {
     data = d;
     left = l;
      right = r;
   }
   /**
    * Returns the data in the Node.
    */
   public T getData(){
      return data;
   }
   /**
    * Returns the Node to the right.
    */
   BinaryTreeNode<T> getLeft () { return left; }
   /**
    * Returns the Node to the left.
    */

   BinaryTreeNode<T> getRight () { return right; }
}
