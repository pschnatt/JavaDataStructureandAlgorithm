class Solution {
    public static void main(String[] args)
    {
      Solution x = new Solution();
      int y = x.myAtoi("                          6651mjhbhjgbhk98191514954915");
      // int z = x.myAtoi("     -42");
      // int a = x.myAtoi("42 with words");
      System.out.println(y);
      // System.out.println(z);
      // System.out.println(a);

    }
      public int myAtoi(String s) {
        int i = 0;
        long value = 0;
        int sign = 1;
        int result;
        while (i < s.length() && (s.charAt(i) == ' ')){i++;}
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-'))
        {
          if (s.charAt(i) == '-')
            sign *= -1;
          i++;
        }
        while (i < s.length() && (s.charAt(i) >= '0' && s.charAt(i) <= '9'))
        {
          value *= 10;
          value += (s.charAt(i) - 48);
          i++;
          if (value >= 2147483647 && sign == 1)
            return (2147483647);
          else if (sign == -1 && value > 2147483647)
            return (-2147483648);
        }
        result = (int)value;
        return (result *sign);
      }
  }