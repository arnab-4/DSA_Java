import java.util.Stack;
public class Infix_to_prefix {
    //THIS IS THE 1ST STEP
    public  String reverse(String str)
    {
      StringBuilder sb=new StringBuilder(str);
      return sb.reverse().toString();
        
    }
    public String parenthesis(String str)
    {
        String tempStr = str.replace('(', '\0');
        // Replace all ')' with '('
        tempStr = tempStr.replace(')', '(');
        // Replace the temporary character with ')'
        tempStr = tempStr.replace('\0', ')');
        return tempStr;
    }
    public static int priority(char ch) {
        switch(ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
    public String Infix_prefix(String str)
    {
        str=reverse(str);
        str=parenthesis(str);
        
        Stack<Character> st = new Stack<>();
        String ans="";
       for(int i=0;i<str.length();i++) {
            char c=str.charAt(i);
            if((c >= 'A' && c <= 'Z') ||
            (c >= 'a' && c <= 'z') ||
            (c >= '0' && c <= '9')){
                ans+=c;
            }
            else if(c=='(')
            {
                st.push(c);
            }
            else if(c==')')
            {
                while(!st.isEmpty() && st.peek()!='(')
                {
                    ans+=st.pop();
                }
                st.pop();
            }
            else{
                if(c=='^')  //HANDLE THE RIGHT ASSOSIATIVE PROPERTY
                {
                    while (!st.isEmpty() && priority(c) <= priority(st.peek())) {
                        ans += st.pop();
                    }
                    st.push(c);
                }
                else{    //HANDLE THE LEFT ASSOSIATIVE PROPERTY
                    while (!st.isEmpty() && priority(c) < priority(st.peek())) {
                        ans += st.pop();
                    }
                    st.push(c);
                }
              
                
            }
        }
        while (!st.isEmpty()) {
            
            ans += st.pop();
        }
        ans= reverse(ans);
        return ans;

    }
    //This is the second step
    public static void main(String[] args) {
        String c="(A+B)*C-D+F";
       Infix_to_prefix op=new Infix_to_prefix();
       String d=op.Infix_prefix(c);
       System.out.println(d);


    }
}