class Solution {
  public boolean checkInclusion(String s1, String s2) 
  {
      int[] freq1 = new int[26];
      int[] freq2 = new int[26];
      int s1len = s1.length();
      int s2len = s2.length();
      char[] c1 = s1.toCharArray();
      char[] c2 = s2.toCharArray();
      for (int i = 0; i < 26; i++)
      {
          freq1[i] = 0;
          freq2[i] = 0;
      }
      for (char c : c1)
      {
        freq1[(int)c - (int)'a']++;
      }
      for (int i = 0; i < s2len;i++)
      {
        if (i >= s1len)
        {
          freq2[(int)c2[i - s1len] - (int)'a']--;
        }

        freq2[(int)c2[i] - (int)'a']++;
        if (i >= s1len - 1)
        {
          boolean t = true;
          for (int j = 0; j < 26; j++)
          {
            if (freq1[j] != freq2[j])
            {
              t = false;
              break;
            }
          }
          if (t)
          {
            return (true);
          }
        }
      }
      return (false);
  }
}