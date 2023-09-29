package code;

public class TreeNode {
  public int data;
  public TreeNode left, right, parent;

  public TreeNode(int d) {
    data = d;
  }

  @Override
  public String toString() {
    String leftchild = (left == null)? "null" : Integer.toString(left.data);
    String rightchild = (right == null)? "null" : Integer.toString(right.data);
    return (leftchild + "<-" + data + "->" + rightchild);
  }
}