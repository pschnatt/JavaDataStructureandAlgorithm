import java.math.BigInteger;

class ListNode
{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution 
{

  public static void main(String[] args)
  {
    ListNode a = new ListNode(9);

    ListNode b = new ListNode(9);
    ListNode c = new ListNode(9,b);
    ListNode d = new ListNode(9,c);
    ListNode e = new ListNode(9,d);
    ListNode f = new ListNode(9,e);
    ListNode g = new ListNode(9,f);
    ListNode h = new ListNode(9,g);
    ListNode i = new ListNode(9,h);
    ListNode j = new ListNode(9,i);
    ListNode k = new ListNode(1,j);

    Solution solution = new Solution();

    ListNode result = solution.addTwoNumbers(a, k);
    System.out.println(nodeAdd(result,BigInteger.ONE));
  }


  public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
  {
    BigInteger mathsum = (nodeAdd(l1, BigInteger.ONE).add (nodeAdd(l2, BigInteger.ONE)));
    String sum = mathsum.toString();
    ListNode head = new ListNode(((int) sum.charAt(sum.length() - 1)) - 48);
    ListNode current = head;

    if (sum.length() > 1)
    {
      for (int i = sum.length() - 2; i > -1; i--)
      {
        ListNode newnode = new ListNode(((int) sum.charAt(i)) - 48);
        current.next = newnode;
        current = newnode;
      }
    }
    return (head);
  }

  public static BigInteger nodeAdd(ListNode l,BigInteger value)
  {
      if (l.next == null)
        return (BigInteger.valueOf(l.val).multiply(value));
      return (nodeAdd(l.next,value.multiply(BigInteger.TEN))).add(BigInteger.valueOf(l.val).multiply(value));
  }
}