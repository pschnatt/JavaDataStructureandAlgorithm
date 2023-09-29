/* 
class ListNode
{
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
*/

public class EffecientSol 
{
  //Time Complexity O(n)
  //Space Complexity O(n)
  
  public ListNode addTwoNumbers2(ListNode l1, ListNode l2)
  {
    int carry = 0;
    ListNode head = new ListNode(0);
    ListNode current = head;

    while (l1 != null || l2 != null || carry != 0)
    {
      int augend = (l1 == null) ? 0 : l1.val;
      int addend = (l2 == null) ? 0 : l2.val;
      int sum = augend + addend + carry;
      carry = sum / 10;
      sum %= 10;
      ListNode newnode = new ListNode(sum);
      current.next = newnode;
      current = newnode;
      l1 = (l1 == null) ? null : l1.next;
      l2 = (l2 == null) ? null : l2.next; 
    }
    return (head.next);
  }
  
}
