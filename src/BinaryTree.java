import java.io.PrintWriter;
import java.util.Iterator;

/**
 * Simple binary trees.
 */
public class BinaryTree<T> implements Iterable<T> {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The root of the tree
   */
  BinaryTreeNode<T> root;

  /**
   * The number of values in the tree.
   */
  int size;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new, empty, tree.
   */
  public BinaryTree() {
    this.size = 0;
    this.root = null;
  } // BinaryTree

  /**
   * Create a new, somewhat balanced, tree.
   */
  public BinaryTree(T[] values) {
    this.size = values.length;
    this.root = makeTree(values, 0, values.length);
  } // BinaryTree(T[])

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Dump the tree to some output location.
   */
  public void dump(PrintWriter pen) {
    dump(pen, root, "");
  } // dump(PrintWriter)

  /**
   * Get an iterator for the tree.
   */
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      public boolean hasNext() {
        // STUB
        return false;
      } // hasNext()

      public T next() {
        // STUB
        return null;
      } // next()
    }; // new Iterator()
  } // iterator()

  // +---------+-----------------------------------------------------
  // | Helpers |
  // +---------+

  /**
   * Dump a portion of the tree to some output location.
   */
  void dump(PrintWriter pen, BinaryTreeNode<T> node, String indent) {
    if (node == null) {
      pen.println(indent + "<>");
    } else {
      pen.println(indent + node.value);
      if ((node.left != null) || (node.right != null)) {
        dump(pen, node.left, indent + "  ");
        dump(pen, node.right, indent + "  ");
      } // if has children
    } // else
  } // dump

  public void elements01(PrintWriter pen) {
    elements01Helper(pen, this.root);
    pen.println();
  }

  private void elements01Helper(PrintWriter pen, BinaryTreeNode<T> node) {
    if (node == null) {
      return;
    } else {
      pen.print(node.value + " ");
      elements01Helper(pen, node.left);
      elements01Helper(pen, node.right);
    }
  }
  
  public void elements02(PrintWriter pen) {
    elements02R(pen, this.root);
    pen.println();
  }
  
  private void elements02R(PrintWriter pen, BinaryTreeNode<T> node) {
    if (node == null) return;
    elements02R(pen, node.left);
    pen.print(node.value + " ");
    elements02R(pen, node.right);
  }

  /**
   * Build a tree from a subarray from lb (inclusive) to ub (exclusive).
   */
  BinaryTreeNode<T> makeTree(T[] values, int lb, int ub) {
    if (ub <= lb) {
      return null;
    } else if (ub - lb == 1) {
      return new BinaryTreeNode<T>(values[lb]);
    } else {
      int mid = lb + (ub - lb) / 2;
      return new BinaryTreeNode<T>(values[mid], makeTree(values, lb, mid),
          makeTree(values, mid + 1, ub));
    } // if/else
  } // makeTree(T[], int, int)

} // class BinaryTree
