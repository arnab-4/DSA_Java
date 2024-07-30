import java.util.Stack;
public class postfix_infix {
    public String post_infix(String str)
    {
        Stack <String> st=new Stack<>();
        
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(Character.isLetterOrDigit(c))
            {
                
                st.push(Character.toString(c));
            }
            else{
                String s1=st.pop();
                String s2=st.pop();
                String nw='('+s2+c+s1+')';
                st.push(nw);
            }
            
        }
        return st.peek();
    }
   public static void main(String[] args) {
    postfix_infix converter = new postfix_infix();
        String postfixExpression = "ab+c*"; // Example postfix expression
        String infixExpression = converter.post_infix(postfixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);
        System.out.println("Infix Expression: " + infixExpression);
   } 
}
