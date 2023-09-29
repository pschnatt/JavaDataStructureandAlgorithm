import java.util.Stack;

public class Solution
{
  public static void main(String[] args) {
    
  }
}

class MinStack {

    Stack<pair> minstack = new Stack<pair>();

    private class pair
    {
      int val;
      int min;
      private pair(int val, int min)
      {
        this.val = val;
        this.min = min;
      }

      public int getmin(){return min;}
      public int getval(){return val;}
    }

    public MinStack() 
    {
        
    }
    
    public void push(int val) 
    {
      if (minstack.empty())
      {
        minstack.push(new pair(val, val));
      }
      else
      {
        minstack.push(new pair(val, val < minstack.peek().getmin() ? val : minstack.peek().getmin()));
      }
    }
    
    public void pop() {
      minstack.pop();
      
    }
    
    public int top() {
        return (minstack.peek().getval());
    }
    
    public int getMin() {
        return (minstack.peek().getmin());
    }
}