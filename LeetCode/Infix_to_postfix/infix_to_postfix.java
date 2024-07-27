import java.util.Scanner;
import java.util.Stack;

public class infix_to_postfix {

    // Function to convert an infix expression to a postfix expression.
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

    public static String infixToPostfix(String exp) {
        int i = 0;
        Stack<Character> st = new Stack<>();
        String ans = "";
        while (i < exp.length()) {
            char c = exp.charAt(i);
            if ((c >= 'A' && c <= 'Z') ||
                (c >= 'a' && c <= 'z') ||
                (c >= '0' && c <= '9')) {
                ans += c;
            } else if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    ans += st.pop();
                }
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                } else {
                    return "Invalid Expression"; // mismatched parentheses
                }
            } else {
                while (!st.isEmpty() && priority(c) <= priority(st.peek())) {
                    ans += st.pop();
                }
                st.push(c);
            }
            i++;
        }
        while (!st.isEmpty()) {
            if (st.peek() == '(') {
                return "Invalid Expression"; // mismatched parentheses
            }
            ans += st.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an infix expression: ");
        String expression = scanner.nextLine();
        String postfix = infixToPostfix(expression);
        System.out.println("Postfix expression: " + postfix);
        scanner.close();
    }
}
