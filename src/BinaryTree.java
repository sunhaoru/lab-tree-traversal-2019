/**
 * Simple binary trees.
 */
public class BinaryTree<T> {
  /**
   * The root of the tree
   */
  BinaryTreeNode<T> root;
  
  /**
   * The number of values in the tree.
   */
  int size;
  
  /**
   * Create a new, somewhat balanced, tree.
   */
  public BinaryTree(T[] values) {
    this.size = values.length;
    this.root = makeTree(values, 0, values.length);
  } // BinaryTree(T[])
  
  /**
   * Build a tree from a subarray from lb (inclusive)
   * to ub (exclusive).
   */
  BinaryTreeNode<T> makeTree(T[] values, int lb, int ub) {
    if (ub <= lb) {
      return null;
    } else if (ub - lb == 1) {
      return new BinaryTreeNode(values[lb]);
    } else {
      int mid = lb + (ub - lb)/2;
      return new BinaryTreeNode(values[mid],
          makeTree(values, lb, mid),
          makeTree(values, mid+1, ub));
    } // if/else
  } // makeTree(T[], int, int)
  
} // class BinaryTree
