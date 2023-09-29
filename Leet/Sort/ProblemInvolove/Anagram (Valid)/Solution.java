import java.util.Arrays;

// Given two strings s and t, return true if t is an anagram of s, and false otherwise.

// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.


class Solution {
    public boolean isAnagram(String s, String t) 
    {
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        Arrays.sort(chs);
        Arrays.sort(cht);
        return (String.valueOf(cht).equals(String.valueOf(chs)) ? true : false);
    }
}