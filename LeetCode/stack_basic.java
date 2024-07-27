public class stack_basic {
    public int arr[];
    public int top;

    public stack_basic() {
        arr = new int[50];
        top = -1;
    }

    public void push(int x) {
        if (top < arr.length - 1) {
            arr[++top] = x;
        }
    }

    public int pop() {
        if (top == -1) {
            return -1;
        }
        return top--;
    }

    public void print() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        stack_basic st = new stack_basic();
        st.push(9);
        st.push(10);
        st.push(65);
        st.push(2);
        st.push(6);
        st.push(8);

        // Print the stack after pushing elements
        System.out.println("Stack elements after pushes:");
        st.print();
        System.out.println("After deletion");
        st.pop();
        st.pop();
        st.print();
    }
}
