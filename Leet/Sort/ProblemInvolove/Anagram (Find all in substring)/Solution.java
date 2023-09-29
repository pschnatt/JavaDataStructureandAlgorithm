import java.util.ArrayList;
import java.util.List;

class Solution 
{
  public List<Integer> findAnagrams(String s, String p) 
  {
    List<Integer> ans = new ArrayList<>();
    int slen = s.length();
    int plen = p.length();
    char[] freq1 = new char[26];
    char[] freq2 = new char[26];

    for (int i = 0; i < 26; i++)
    {
      freq1[i] = 0;
      freq2[i] = 0;
    }

    for (int i = 0; i < plen; i++)
    {
      freq1[(int)p.charAt(i) - (int)'a']++;
    }

    for (int i = 0; i < slen; i++)
    {
      if (i > plen - 1)
      {
        freq2[(int)s.charAt(i - plen) - (int)'a']--;
      }
      freq2[(int)s.charAt(i) - (int)'a']++;
      if (i >= plen - 1)
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
          ans.add(i - plen + 1);
        }
      }
    }
    return (ans);
  }
}