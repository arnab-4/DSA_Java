class Delete_all_occurence_in_a_given_key {
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    static Node addNode(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
        return head;
    }

    static Node deleteAllOccurOfX(Node head, int x) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == x) {
                if (temp == head) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else {
                    Node nextNode = temp.next;
                    Node prevNode = temp.prev;
                    if (nextNode != null) {
                        nextNode.prev = prevNode;
                    }
                    if (prevNode != null) {
                        prevNode.next = nextNode;
                    }
                }
                temp = temp.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = null;
        head = addNode(head, 1);
        head = addNode(head, 2);
        head = addNode(head, 3);
        head = addNode(head, 2);

        System.out.println("Original list:");
        printList(head);

        head = deleteAllOccurOfX(head, 2);

        System.out.println("List after deleting all occurrences of 2:");
        printList(head);
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
