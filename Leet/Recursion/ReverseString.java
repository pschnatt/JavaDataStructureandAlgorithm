public class ReverseString{
  public static void main(String[] args)
  {
    Solution x = new Solution();
    String str = "hello";
    char[] charArray = str.toCharArray();
    x.reverseString(charArray);
    System.out.println(charArray);
  }
}

class Solution {
    public void reverseString(char[] s)
    {
      reverseStringhelper(s, 0, s.length-1);
    }

    public void reverseStringhelper(char[] s, int start, int end)
    {
      if (start >= end)
        return ;
      char temp;

      temp = s[start];
      s[start] = s[end];
      s[end] = temp;
      reverseStringhelper(s, start + 1, end - 1);
    }
}