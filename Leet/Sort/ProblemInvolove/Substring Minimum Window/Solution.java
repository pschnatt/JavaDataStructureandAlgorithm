// Given two strings s and t of lengths m and n respectively, return the minimum window 
// substring
//  of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

class Solution {
  public static void main(String[] args) {
    minWindow("ADOBECODEBANC", "ABC");
  }

  public static String minWindow(String s, String t) {
    int minval = Integer.MAX_VALUE;
    String answer = "";
    int[] ct = new int[52];
    int[] cs = new int[52];
    int slen = s.length();
    int tlen = t.length();
    for (int i = 0; i < 52; i++) {
      cs[i] = 0;
      ct[i] = 0;
    }
    for (int i = 0; i < tlen; i++) {
      int it = (int) t.charAt(i);
      if (it >= 'A' && it <= 'Z') {
        ct[it - (int) 'A']++;
      } else // lowercase
      {
        ct[it - (int) 'A' - 6]++;
      }
    }
    int startindex = 0;
    for (int i = 0; i < slen; i++) {
      int is = (int) s.charAt(i);
      if (is >= 'A' && is <= 'Z') {
        cs[is - (int) 'A']++;
      } else // lowercase
      {
        cs[is - (int) 'A' - 6]++;
      }

      while (i - startindex + 1 >= tlen) {
        boolean pass = true;
        for (int j = 0; j < 52; j++) {
          if (ct[j] != 0 && cs[j] < ct[j]) {
            pass = false;
            break;
          }
        }
        if (!pass) {
          System.out.println("notpass");
          break;
        }
        if (i - startindex + 1 < minval) {
          minval = i - startindex + 1;
          answer = s.substring(startindex, i + 1);

          System.out.println(answer);
        }
        int isn = (int) s.charAt(startindex);
        if (isn >= 'A' && isn <= 'Z') {
          cs[isn - (int) 'A']--;
        } else // lowercase
        {
          cs[isn - (int) 'A' - 6]--;
        }
        startindex++;
        if (answer.length() == tlen) {
          return (answer);
        }
      }
    }
    return (answer);
  }
}