class Solution {
    public static void main(String[] args) {
      Solution x = new Solution();
      String y = x.entityParser("and I quote: &quot;...&quot;");
      System.out.println(y);
    }
    public String entityParser(String text) {

        String result = "";
        String buffer = "";
        for (int i = 0; i < text.length(); i++)
        {
          char c = text.charAt(i);
          if (c == '&')
          {
            result += buffer;
            buffer = "&";
          }
          else if (c == ';')
          {
            buffer += c;
            switch (buffer)
            {
              case "&quot;":
                result += "\"";
                break;
              case "&apos;":
                result += "\'";
                break;
              case "&amp;":
                result += "&";
                break;
              case "&gt;":
                result += ">";
                break;
              case "&lt;":
                result += "<";
                break;
              case "&frasl;":
                result += "/";
                break;
              default :
                result += buffer;
                break;
            }
            buffer = "";
          }
          else
          {
            buffer += c;
          }
        }
        if (buffer != "")
        {
          result += buffer;
        }
        return (result);
    }
}