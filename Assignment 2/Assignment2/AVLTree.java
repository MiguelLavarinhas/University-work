/**
 * This generic class creates an AVL Tree that stores BinaryTreeNode objects.
 *
 * @author Miguel Lavarinhas
 * @version 1.0
 * @since 20/03/2024
 */
public class AVLTree<T extends Comparable<T>> {
   /**
    * Counts the total operations taken in the insert method.
    */
private int insertCount;
    /**
    * Counts the total operations taken in the find method.
    */
private int searchCount;
    /**
    * The first node in the AVL tree.
    */
private BinaryTreeNode<T> root;
     /**
    * Constructs an AVL tree without a root.
    */
   public AVLTree() {
       root = null;
       insertCount=0;
       searchCount=0;
   }
   /**
    * Finds the height at this node.
    * @param node   Node visited.
    * @return the height.
    */
   public int height(BinaryTreeNode<T> node) {
       if (node != null)
           return node.height;
       return -1;
   }
   /**
    * Finds the balanceFactor at this node.
    * @param node   Node visited.
    * @return the balancefactor.
    */
   public int balanceFactor(BinaryTreeNode<T> node) {
       return height(node.right) - height(node.left);
   }
   /**
    * Recalculates the height at this node.
    * @param node   Node visited.
    */
   public void fixHeight(BinaryTreeNode<T> node) {
       node.height = Math.max(height(node.left),
               height(node.right)) + 1;
   }
   /**
    * Rotates the AVL tree right from that node onwards.
    * @param p  Node visited.
    * @return the node which replaces the current node.
    */
   public BinaryTreeNode<T> rotateRight(BinaryTreeNode<T> p) {
       BinaryTreeNode<T> q = p.left;
       p.left = q.right;
       q.right = p;
       fixHeight(p);
       fixHeight(q);
       return q;
   }
   /**
    * Rotates the AVL tree left from that node onwards.
    * @param q  Node visited.
    * @return the node which replaces the current node.
    */
   public BinaryTreeNode<T> rotateLeft(BinaryTreeNode<T> q) {
       BinaryTreeNode<T> p = q.right;
       q.right = p.left;
       p.left = q;
       fixHeight(q);
       fixHeight(p);
       return p;
   }
   /**
    * Rebalances the AVL tree by rotating if needed from the node onwards.
    * @param p  Node visited.
    * @return the node which has been balanced.
    */
   public BinaryTreeNode<T> balance(BinaryTreeNode<T> p) {
       fixHeight(p);
       if (balanceFactor(p) == 2) {
           if (balanceFactor(p.right) < 0)
               p.right = rotateRight(p.right);
           return rotateLeft(p);
       }
       if (balanceFactor(p) == -2) {
           if (balanceFactor(p.left) > 0)
               p.left = rotateLeft(p.left);
           return rotateRight(p);
       }
       return p;
   }
   /**
    * Insert method calls other inset method with root as parameter.
    * @param d   The data inserted into the AVL tree.
    */
   public void insert(T d) {
       root = insert(d, root);
   }
   /**
    * Insert finds the correct place and inserts data into AVL tree.
    * @param d   The data inserted into the AVL tree.
    * @param node   The node visited.
    * @return the balanced node or the next node needing to be compared to.
    */
   public BinaryTreeNode<T> insert(T d,
           BinaryTreeNode<T> node) {
       if (node == null)
           return new BinaryTreeNode<T>(d, null, null);
        insertCount++;
       if (d.compareTo(node.data) <= 0)
           node.left = insert(d, node.left);
       else
           node.right = insert(d, node.right);
       return balance(node);
   }
   /**
    * Returns root node if root is not null to other find method.
    * @param d  The data we are looking for.
    * @return null if root is null or returns the next find method.
    */
   public BinaryTreeNode<T> find ( T d )
   {
      if (root == null)
         return null;
      else
         return find (d, root);
   }
   /**
    * Finds the node in AVL which contains the data received.
    * @param d   The data to find in the AVL tree.
    * @param node   The node visited.
    * @return the node which has been found or null if not found.
    */
   public BinaryTreeNode<T> find ( T d, BinaryTreeNode<T> node )
   {
      if (d.compareTo (node.data) == 0){ 
        searchCount++;
         return node;
      }
      else if (d.compareTo (node.data) < 0){
        searchCount++;
         return (node.left == null) ? null : find (d, node.left);
      }
      else{
        searchCount++;
         return (node.right == null) ? null : find (d, node.right);
      }
   }
   /**
    * Returns InsertCount.
    * @return the insertCount.
    */
   public int getInsertCount(){
    return insertCount;
   }
   /**
    * Returns SearchCount.
    * @return the searchCount.
    */
   public int getSearchCount(){
    return searchCount;
   }

   public void resetInsertCount(){
     insertCount = 0;
   }

   public void resetSearchCount(){
    searchCount=0;
   }

}


