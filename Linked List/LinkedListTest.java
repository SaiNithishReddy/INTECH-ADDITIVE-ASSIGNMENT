class LinkedList {
    Node head; // head of the list

    /* Linked List node */
    class Node {
        int data;
        Node next;

        // Constructor to create a new node
        // Next is by default initialized
        // as null
        Node(int d) {
            data = d;
            next = null;
        }
    }

    /* Function to get the kth node from the last of a
    linked list */
    void printKthFromLast(int k) {
        Node main_ptr = head;
        Node ref_ptr = head;

        int count = 0;
        if (head != null) {
            while (count < k) {
                if (ref_ptr == null) {
                    System.out.println(k + " is greater than the no of nodes in the list");
                    return;
                }
                ref_ptr = ref_ptr.next;
                count++;
            }

            while (ref_ptr != null) {
                main_ptr = main_ptr.next;
                ref_ptr = ref_ptr.next;
            }
            System.out.println("Kth to last element is: " + main_ptr.data);
        }
    }

    /* Inserts a new Node at front of the list. */
    public void push(int new_data) {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }
}

/* Drier program to test above functions */
public class LinkedListTest {
    public static void main(String args[]) {
        LinkedList llist = new LinkedList();

        // Add nodes to the list
        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(35);

        // Finding kth to last element
        llist.printKthFromLast(3);
    }
}
