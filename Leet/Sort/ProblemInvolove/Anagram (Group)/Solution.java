// Given an array of strings strs, group the anagrams together. You can return the answer in any order.

// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution 
{
  public List<List<String>> groupAnagrams(String[] strs) 
  {
      HashMap<String,List<String>> map = new HashMap<>();
      for (String str : strs)
      {
        char[] chararr = str.toCharArray();
        Arrays.sort(chararr);
        String s = String.valueOf(chararr);
        if (!map.containsKey(s))
        {
          map.put(s, new ArrayList<>());
        }
        map.get(s).add(str);
      }
      return new ArrayList<>(map.values());
  }
}