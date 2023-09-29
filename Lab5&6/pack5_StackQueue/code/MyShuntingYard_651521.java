package code;

import java.util.StringTokenizer;

public class MyShuntingYard_651521 {
  private static int order(String c) 
  {return switch (c) 
    {
      case "+", "-" -> 1;
      case "*", "/" -> 2;
      default -> 0;
    };
}
  public static String infixToPostfix(String infixString) 
  {
    MyQueueL_651521 queue = new MyQueueL_651521();
    MyStackL stack = new MyStackL();
    String resultPostfixString = "";
    StringTokenizer st = new StringTokenizer(infixString);
    while (st.hasMoreTokens()) 
    {
      String t = st.nextToken();
      if (MyRPN_651521.isNumeric(t))
        queue.enqueue(t);
      else if (t.equals("(")) 
      {
        stack.push(t);
      } 
      else if (t.equals(")")) 
      {
        while (!stack.peek().equals("("))
        {
          queue.enqueue(stack.pop());
        }
        stack.pop();
      } 
      else 
      {
        if(!stack.isEmpty() && order(t) <= order(stack.peek())) 
        {
          queue.enqueue(stack.pop());
        }
        stack.push(t);
      }
    }
    while (!stack.isEmpty())
    {
      queue.enqueue(stack.pop());
    }
    resultPostfixString = queue.dumpToString();
    return (resultPostfixString);
  }
}