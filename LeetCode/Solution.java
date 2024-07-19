public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // If either head is null, there can be no intersection
        if (headA == null || headB == null) {
            return null;
        }

        // Initialize two pointers
         
       

        // Traverse both lists
        while (temp1 != temp2) {
            // If temp1 reaches the end of list A, switch to headB
            if (temp1 == null) {
                temp1 = headB;
            } else {
                temp1 = temp1.next;
            }

            // If temp2 reaches the end of list B, switch to headA
            if (temp2 == null) {
                temp2 = headA;
            } else {
                temp2 = temp2.next;
            }
        }

        // Return the intersection node or null if there is no intersection
        return temp1;
    }
}