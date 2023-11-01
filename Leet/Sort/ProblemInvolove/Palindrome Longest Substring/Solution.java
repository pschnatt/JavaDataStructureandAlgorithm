// Given a string s, return the longest palindromic substring in s.

class Solution {
    int maxlen = 0;
    int maxstarti = 0;

    public String longestPalindrome(String s) 
    {
        int slen = s.length();
        if (slen < 2)
        {
            return (s);
        }

        for (int i = 0; i < slen - 1; i++)
        {
            longestPalindromehelper(s, i, i, slen);
            longestPalindromehelper(s, i, i + 1, slen);
        }
        return (s.substring(maxstarti, maxstarti + maxlen));
    }

    public void longestPalindromehelper(String s, int index, int index2, int slen)
    {
        while (index >= 0 && index2 < slen && s.charAt(index) == s.charAt(index2))
        {
            index--;
            index2++;
        }
        if (maxlen < index2 - index - 1)
        {
            maxlen = index2 - index - 1;
            maxstarti = index + 1;

        }
    }
}