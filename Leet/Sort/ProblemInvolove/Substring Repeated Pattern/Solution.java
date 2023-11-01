//find if s can construct with repeated substring in s

class Solution 
{
    public boolean repeatedSubstringPattern(String s)
    {
      boolean ans = false;
      int slen = s.length();
      String s_fold = s.substring(1, slen) + s.substring(0,slen - 1); 
    }
}