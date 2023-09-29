//65011521 Schnat Rattanasombatpaibul

import code.TreeNode;

public class BST {
  public static void main(String[] args) {
    demo4();
  }

  TreeNode root;

  public BST() {
    root = null;
  }

  public TreeNode getRoot() {
    return root;
  }

  public void insert(int d) {
    if (root == null) {
      root = new TreeNode(d);
    } else {
      TreeNode cur = root;
      while (cur != null) {
        if (d < cur.data) {
          if (cur.left != null)
            cur = cur.left;
          else {
            cur.left = new TreeNode(d);
            cur.left.parent = cur;
            return;
          }
        } else {
          if (cur.right != null)
            cur = cur.right;
          else {
            cur.right = new TreeNode(d);
            cur.right.parent = cur;
            return;
          }
        }
      }
    }
  }

  public void printPreOrder() {
    printPreOrderRecurse(root);
  }

  private void printPreOrderRecurse(TreeNode node) {
    if (node == null) {
      return;
    }
    System.out.println(node.data + " ");
    printPreOrderRecurse(node.left);
    printPreOrderRecurse(node.right);
  }

  public void printInOrder() {
    printInOrderRecurse(root);
  }

  private void printInOrderRecurse(TreeNode node) {
    if (node == null) {
      return;
    }
    printInOrderRecurse(node.left);
    System.out.println(node.data + " ");
    printInOrderRecurse(node.right);
  }

  public void printPostOrder() {
    printPostOrderRecurse(root);
  }

  private void printPostOrderRecurse(TreeNode node) {
    if (node == null) {
      return;
    }
    printPostOrderRecurse(node.left);
    printPostOrderRecurse(node.right);
    System.out.println(node.data + " ");
  }

  public TreeNode search(int d) {
    TreeNode result = searchRecurse(d, root);
    return result;
  }

  public TreeNode searchRecurse(int d, TreeNode n) {
    if (n == null)
      return null;
    if (d == n.data)
      return n;
    if (d < n.data)
      return searchRecurse(d, n.left);
    return searchRecurse(d, n.right);
  }

  public TreeNode searchIter(int key) {
    if (root.data == key)
      return root;
    TreeNode current = root;
    while (current != null) {
      if (key < current.data) {
        current = current.left;
      } else if (key > current.data) {
        current = current.right;
      } else
        return current;
    }
    return null;
  }

  public int height() {
    return root == null ? 0 : height(root);
  }

  public int height(TreeNode node) {
    if (node == null)
      return 0;
    return (Math.max(height(node.left), height(node.right)) + 1);
  }

  public TreeNode findMaxFrom(TreeNode subtreeHead) {
    TreeNode current = subtreeHead;
    while (current.right != null) {
      current = current.right;
    }
    return current;
  }

  public void delete(int d, TreeNode current) {
    if (current == null)
      return; // not found
    if (d < current.data)
      delete(d, current.left);
    else if (d > current.data)
      delete(d, current.right);
    else 
    { // found ... time to delete
      if (current.left == null || current.right == null) 
      { // 0 or 1 child
        TreeNode q = (current.left == null) ? current.right : current.left;
        if (current.parent.left == current)
          current.parent.left = q; // this node is left child
        else
          current.parent.right = q;
        if (q != null)
          q.parent = current.parent;
      }
      else 
      { // two children
          TreeNode q = findMaxFrom(current.left);
          current.data = q.data;
          delete(q.data, current.left);
      } // two children
   // found
    }
  }

  public static void demo1() {
    System.out.println("-insert and preOrder traversal-");
    int[] dat = { 15, 20, 10, 18, 16, 12, 8, 25, 19, 30 };
    BST bst = new BST();
    for (int j = 0; j < dat.length; j++)
      bst.insert(dat[j]);
    bst.printPreOrder();
    // 15 10 8 12 20 18 16 19 25 30
    System.out.println();
    demo2(bst);
  }

  static void demo2(BST bst) {
    System.out.println("-more traversal---");
    bst.printInOrder();
    System.out.println();
    // 8 10 12 15 16 18 19 20 25 30
    bst.printPostOrder();
    System.out.println();
    // 8 12 10 16 19 18 30 25 20 15
    demo3(bst);
  }

  static void demo3(BST bst) {
    System.out.println("-search recursive---");
    System.out.println(bst.search(20)); // 18<-20->25
    System.out.println(bst.search(25)); // null<-25->30
    System.out.println(bst.search(12)); // null<-12->null
    System.out.println(bst.search(1)); // null
    System.out.println(bst.searchRecurse(10, bst.getRoot()));
    // if searchRecurse and getRoot is available
    System.out.println("-search iterative---");
    System.out.println(bst.searchIter(20));
    System.out.println(bst.searchIter(25));
    System.out.println(bst.searchIter(12));
    System.out.println(bst.searchIter(1));
  }

  public static void demo4() {
    int[] data = { 2, 1, 3, 4, 5, 6, 7, 8, 9 };
    BST bst = new BST();
    for (int j = 0; j < data.length; j++)
      bst.insert(data[j]);
    bst.printInOrder();
    System.out.println("Tree height = " + bst.height());
    int[] dat = { 15, 20, 10, 18, 16, 12, 8, 25, 19, 30 };
    bst = new BST();
    for (int j = 0; j < dat.length; j++)
      bst.insert(dat[j]);
    bst.printInOrder();
    System.out.println("Tree height = " + bst.height());
    System.out.println();
    demo5(bst);
  }

  public static void demo5(BST bst) {
    System.out.println("node with max value " + bst.findMaxFrom(bst.getRoot()));
    System.out.println();
    demo6(bst);
  }

  public static void demo6(BST bst) {
    bst.delete(12, bst.getRoot());
    System.out.println(bst.search(20)); // 18<-20->25
    System.out.println(bst.search(25)); // null<-25->30
    System.out.println(bst.search(16)); // null<-16->null
    System.out.println(bst.search(10)); // 8<-10->null
    System.out.println(bst.search(12)); // not found
  }
}