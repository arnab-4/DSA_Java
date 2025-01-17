/*----- Post Order Traversal in a Tree -----*/

import java.util.*; 

class Node{
    Node left,right;
    int dValue;
    
    Node(int v){
        dValue = v;
        left = null;
        right = null;
    }
}


public class PostOrderTraversal {
    public static ArrayList<Integer> postorderTraversal(Node A) {
        
        ArrayList<Integer> list = new ArrayList<>(); 
        Stack<Node> stack = new Stack<>(); 
        Stack<Integer> stackReverse = new Stack<>(); 
    
        stack.push(A);
    
        while(!stack.empty()){
            
            Node node = stack.peek();
            int data = stack.pop().dValue; 
            stackReverse.push(data);
            
            if(node.left!=null)
                stack.push(node.left);
            
            if(node.right!=null)
                stack.push(node.right);
                
        }
        
        while(!stackReverse.empty()){
            list.add(stackReverse.pop()); 
        }
        
        
        return list;        
    }
    
    public static void main(String args[]){
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30); 
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
        
        ArrayList<Integer> list = postorderTraversal(root);
        
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i)+" ");
        }
    }
}

