
public class p2 {

    // Node of a singly linked list
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Merge two sorted linked lists by relinking existing nodes
    public static Node mergeSorted(Node a, Node b) {
        // A dummy node simplifies handling the head
        Node dummy = new Node(0);
        Node tail = dummy;

        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }

            tail = tail.next;
        }

        // Attach whichever list still has remaining nodes
        if (a != null) {
            tail.next = a;
        } else {
            tail.next = b;
        }

        return dummy.next;
    }

    // Append a node for creating sample input lists
    static Node append(Node head, int data) {
        Node newNode = new Node(data);

        if (head == null) {
            return newNode;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        return head;
    }

    // Print the linked list
    static void printList(Node head) {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }

        Node current = head;

        while (current != null) {
            System.out.print(current.data);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        // Sample 1
        Node a = null;
        a = append(a, 3);
        a = append(a, 8);
        a = append(a, 15);

        Node b = null;
        b = append(b, 5);
        b = append(b, 8);
        b = append(b, 12);
        b = append(b, 20);

        System.out.print("Counter A: ");
        printList(a);

        System.out.print("Counter B: ");
        printList(b);

        Node merged = mergeSorted(a, b);

        System.out.print("Merged list: ");
        printList(merged);

        // Sample 2: Empty list and a single-node list
        Node empty = null;
        Node single = new Node(4);

        Node merged2 = mergeSorted(empty, single);

        System.out.print("Sample 2: ");
        printList(merged2);
    }
}
