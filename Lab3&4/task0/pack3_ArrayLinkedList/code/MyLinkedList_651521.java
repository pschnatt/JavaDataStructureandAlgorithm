package code;
import java.util.ArrayList;
import java.util.HashSet;

public class MyLinkedList_651521
{
  public static void main(String[] args) 
  {
    System.out.println("-demo1--------");
    demo1();
    System.out.println("-demo2--------");
    demo2();
    System.out.println("-q1--------");
    q1();
    System.out.println("-q2--------");
    q2();
    System.out.println("-q3--------");
    q3();
    System.out.println("-q4--------");
    q4();
    System.out.println("-q5--------");
    q5();
  }

  public class Node 
  {
    int data;
    Node next;
    public Node(int d) {data = d;}
  }

  Node head = null;

  public void add(int d)
  {
    Node newnode = new Node(d);
    newnode.next = head;
    head = newnode;
  }

  public void insert(int d)
  {
    Node newnode = new Node(d);
    Node newhead = new Node(0);
    newhead.next = head;
    Node dummy = newhead;
    while (dummy.next != null && dummy.next.data < d)
    {
      dummy = dummy.next;
    }
    newnode.next = dummy.next;
    dummy.next = newnode;
    head = newhead.next;
  }

  public int find(int d)
  {
    int index = 0;
    Node dummy = head;

    while (dummy != null)
    {
      if(dummy.data == d)
        return index;
      index++;
      dummy = dummy.next;
    }
    return (-1);
  }

  public void delete(int d)
  {
    Node newhead = new Node(0);
    newhead.next = head;
    Node dummy = newhead;
    while (dummy.next != null)
    {
      if (dummy.next.data == d)
      {
        dummy.next = dummy.next.next;
        break;
      }
      dummy = dummy.next;
    }
    head = newhead.next;
  }

  private int size()
  {
    Node newhead = head;
    int size = 0;
    while (newhead != null)
    {
      size++;
      newhead = newhead.next;
    }
    return (size);
  }

  private void add(int[] d)
  {
    Node newnode;
    Node dummy = head;
    for (int i = d.length - 1; i >= 0; i--)
    {
      newnode = new Node(d[i]);
      newnode.next =  dummy;
      dummy = newnode;
    }
    head = dummy;
  }

  private void insert(int[] d)
  {
    for (int i : d)
    {
      insert(i);
    }
  }

  public String toString() 
  {
    StringBuffer sb = new StringBuffer("head ");
    Node p = head;
    while(p!=null) 
    {
      sb.append("--> [");
      sb.append(p.data);
      sb.append("] ");
      p = p.next;
    }
    sb.append("-> null");
    return (new String(sb));
  }

  public void q1_rotate_clockwise(int k)
  {
    if (k < 1 || k >= size())
      return ;
    
    Node newhead = new Node(0);
    newhead.next = head;
    Node dummyNode = newhead;

    Node latterNode;
    int i = 1;
    while (i != k)
    {
      dummyNode = dummyNode.next;
      i++;
    }
    latterNode = dummyNode.next.next;
    dummyNode.next.next = null;
    dummyNode = latterNode;
    while (dummyNode.next != null)
    {
      dummyNode = dummyNode.next;
    }
    dummyNode.next = newhead.next;
    head = latterNode;
  }

  public void q2_reverse()
  {
    Node newnode = null;
    Node add;
    while (head != null)
    {
      add = new Node(head.data);
      add.next = newnode;
      newnode = add;
      head = head.next;
    }
    head = newnode;
  }

  public void q3_remove_dup()
  {
    Node dummyNode = new Node(0);
    dummyNode.next = head;
    Node p = dummyNode;
    while (p.next.next != null)
    {
      if (p.next.data == p.next.next.data)
      {
        p.next.next = p.next.next.next;
      }
      else
      {
        p = p.next;
      }
    }
    head = dummyNode.next;
  }

  public void q4_increment_digits()
  {
    if (head.next == null && head.data < 9)
    {
      head.data += 1;
      return ;
    }
    q2_reverse();
    Node dummyNode = new Node(0);
    dummyNode.next = head;
    int carry = 1;
    int sum;
    while (dummyNode.next != null)
    {
      if (dummyNode.next.data > 9)
      {
        System.out.println("Error : Please enter a digit in each node");
        return ;
      }
      sum = dummyNode.next.data + carry;
      carry = sum / 10;
      dummyNode.next.data = sum % 10;
      dummyNode = dummyNode.next;
    }
    if (carry != 0)
    {
      dummyNode.next = new Node(carry);
    }
    q2_reverse();
  }

  public boolean q5_isPalindrome()
  {
    if (head == null || head.next == null)
      return (false);
    int listsize = size();
    if (listsize == 1)
      return (true);

    Node dummyNode = new Node(0);
    dummyNode.next = head;
    int i;
    ArrayList<Integer> list = new ArrayList<Integer>();
    
    for (i = 0; i < listsize / 2; i++)
    {
      list.add(dummyNode.next.data);
      dummyNode = dummyNode.next;
    }
    if (listsize % 2 != 0)
      dummyNode = dummyNode.next;
    for (i = (listsize / 2) - 1; i >= 0; i--)
    {
      if (dummyNode.next.data != list.get(i))
        return (false);
      dummyNode = dummyNode.next;
    }
    return (true);
  }


  static void demo1()
  {
    MyLinkedList_651521 list = new MyLinkedList_651521();
    list.add(5);
    list.add(1);
    list.insert(4);
    list.insert(3);
    System.out.println(list);
    list.delete(2);
    System.out.println("5 is at " + list.find(5));
    System.out.println(list);
  }
  static void demo2()
  {
    MyLinkedList_651521 mList = new MyLinkedList_651521();
    mList.insert(50);
    mList.insert(40);
    mList.insert(30);
    mList.insert(20);
    mList.insert(10);
    System.out.println(mList);
  }

  static void q1()
  {
    int [] d = {10,20,30,40,50};
    MyLinkedList_651521 mList = new MyLinkedList_651521();
    mList.insert(d);
    System.out.println("before -> " + mList);
    mList.q1_rotate_clockwise(1);
    System.out.println("(k = " + 1 + ") -> " + mList);
    mList.q1_rotate_clockwise(3);
    System.out.println("(k = " + 3 + ") -> " + mList);
    mList.q1_rotate_clockwise(7);
    System.out.println("(k = " + 7 + ") -> " + mList);
  }

  static void q2()
  {
    int [] d = {1,2,3,4,5,6,7,8};
    MyLinkedList_651521 mList = new MyLinkedList_651521();
    mList.insert(d);
    System.out.println("before -> " + mList);
    mList.q2_reverse();
    System.out.println("after -> " + mList);
  }

  static void q3()
  {
    int [] d = {13, 11, 4, 15, 4, 11, 15};
    MyLinkedList_651521 mList = new MyLinkedList_651521();
    mList.insert(d);
    System.out.println("before -> " + mList);
    mList.q3_remove_dup();
    System.out.println("after -> " + mList);
    int [] e = {13, 11, 15, 4};
    mList = new MyLinkedList_651521();
    mList.insert(e);
    System.out.println("before -> " + mList);
    mList.q3_remove_dup();
    System.out.println("after -> " + mList);
  }

  static void q4()
  {
    int [] d = {1,9,9,9};
    MyLinkedList_651521 mList = new MyLinkedList_651521();
    // mList.insert(d);
    // System.out.println("before -> " + mList);
    // mList.q4_increment_digits();
    // System.out.println("after -> " + mList);
    d[0] = 9;
    mList.insert(d);
    System.out.println("before -> " + mList);
    mList.q4_increment_digits();     
    System.out.println("after  -> " + mList); 
  }

  static void q5()
  {
    int [] d = {21, 33, 33, 21};
    boolean isPalind;
    MyLinkedList_651521 mList = new MyLinkedList_651521();
    mList.add(d);
    isPalind = mList.q5_isPalindrome();
    System.out.println(mList + " isPalindrome() = " + isPalind);
    int [] e = {21, 33, 44, 33, 21};
    mList = new MyLinkedList_651521();
    mList.add(e);
    isPalind = mList.q5_isPalindrome();
    System.out.println(mList + " isPalindrome() = " + isPalind);
    int [] f = {1, 9, 9, 9};
    mList = new MyLinkedList_651521();
    mList.add(f);
    isPalind = mList.q5_isPalindrome();
    System.out.println(mList + " isPalindrome() = " + isPalind);
  }

}