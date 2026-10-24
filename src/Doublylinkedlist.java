import java.util.Scanner;

class DoublyNode {
    int data;
    DoublyNode prev;
    DoublyNode next;

    DoublyNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class Doublylinkedlist {
    private static DoublyNode head = null;
    private static DoublyNode tail = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice, data, pos, targetValue, newValue;

        while (true) {
            System.out.println("\n********** Operation on Doubly Linked List **********");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Insert After a Node");
            System.out.println("5. Insert Before a Node");
            System.out.println("6. Delete from Beginning");
            System.out.println("7. Delete from End");
            System.out.println("8. Delete from Position");
            System.out.println("9. Delete by Value");
            System.out.println("10. Search");
            System.out.println("11. Update");
            System.out.println("12. Display Forward");
            System.out.println("13. Display Backward");
            System.out.println("14. Count Nodes");
            System.out.println("15. Find Maximum");
            System.out.println("16. Find Minimum");
            System.out.println("17. Find Middle Element");
            System.out.println("18. Reverse");
            System.out.println("19. Sort");
            System.out.println("20. Remove Duplicates");
            System.out.println("21. Exit");

            System.out.print("\nEnter the choice:- ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    data = sc.nextInt();
                    insertAtBeginning(data);
                    break;
                case 2:
                    System.out.print("Enter value to insert: ");
                    data = sc.nextInt();
                    insertAtEnd(data);
                    break;
                case 3:
                    System.out.print("Enter value to insert: ");
                    data = sc.nextInt();
                    System.out.print("Enter position: ");
                    pos = sc.nextInt();
                    insertAtPosition(data, pos);
                    break;
                case 4:
                    System.out.print("Enter target node value: ");
                    targetValue = sc.nextInt();
                    System.out.print("Enter value to insert: ");
                    data = sc.nextInt();
                    insertAfterNode(targetValue, data);
                    break;
                case 5:
                    System.out.print("Enter target node value: ");
                    targetValue = sc.nextInt();
                    System.out.print("Enter value to insert: ");
                    data = sc.nextInt();
                    insertBeforeNode(targetValue, data);
                    break;
                case 6:
                    deleteFromBeginning();
                    break;
                case 7:
                    deleteFromEnd();
                    break;
                case 8:
                    System.out.print("Enter position to delete: ");
                    pos = sc.nextInt();
                    deleteFromPosition(pos);
                    break;
                case 9:
                    System.out.print("Enter value to delete: ");
                    data = sc.nextInt();
                    deleteByValue(data);
                    break;
                case 10:
                    System.out.print("Enter value to search: ");
                    data = sc.nextInt();
                    search(data);
                    break;
                case 11:
                    System.out.print("Enter target value to update: ");
                    targetValue = sc.nextInt();
                    System.out.print("Enter new value: ");
                    newValue = sc.nextInt();
                    update(targetValue, newValue);
                    break;
                case 12:
                    displayForward();
                    break;
                case 13:
                    displayBackward();
                    break;
                case 14:
                    System.out.println("Total nodes: " + countNodes());
                    break;
                case 15:
                    findMaximum();
                    break;
                case 16:
                    findMinimum();
                    break;
                case 17:
                    findMiddleElement();
                    break;
                case 18:
                    reverse();
                    break;
                case 19:
                    sort();
                    break;
                case 20:
                    removeDuplicates();
                    break;
                case 21:
                    System.out.println("Exiting program...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // 1. Insert at Beginning[cite: 3, 4]
    public static void insertAtBeginning(int data) {
        DoublyNode newNode = new DoublyNode(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Inserted " + data + " at beginning.");
    }

    // 2. Insert at End[cite: 3, 4]
    public static void insertAtEnd(int data) {
        DoublyNode newNode = new DoublyNode(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Inserted " + data + " at end.");
    }

    // 3. Insert at Position (1-based)[cite: 3, 4]
    public static void insertAtPosition(int data, int pos) {
        int len = countNodes();
        if (pos < 1 || pos > len + 1) {
            System.out.println("Invalid position!");
            return;
        }
        if (pos == 1) {
            insertAtBeginning(data);
            return;
        }
        if (pos == len + 1) {
            insertAtEnd(data);
            return;
        }

        DoublyNode newNode = new DoublyNode(data);
        DoublyNode temp = head;
        for (int i = 1; i < pos - 1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
        System.out.println("Inserted " + data + " at position " + pos + ".");
    }

    // 4. Insert After a Node[cite: 3, 4]
    public static void insertAfterNode(int target, int data) {
        DoublyNode temp = head;
        while (temp != null && temp.data != target) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Target node with value " + target + " not found.");
            return;
        }

        if (temp == tail) {
            insertAtEnd(data);
            return;
        }

        DoublyNode newNode = new DoublyNode(data);
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
        System.out.println("Inserted " + data + " after node " + target + ".");
    }

    // 5. Insert Before a Node[cite: 3, 4]
    public static void insertBeforeNode(int target, int data) {
        DoublyNode temp = head;
        while (temp != null && temp.data != target) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Target node with value " + target + " not found.");
            return;
        }

        if (temp == head) {
            insertAtBeginning(data);
            return;
        }

        DoublyNode newNode = new DoublyNode(data);
        newNode.prev = temp.prev;
        newNode.next = temp;
        temp.prev.next = newNode;
        temp.prev = newNode;
        System.out.println("Inserted " + data + " before node " + target + ".");
    }

    // 6. Delete from Beginning[cite: 3, 4]
    public static void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        System.out.println("Deleted value: " + head.data);
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    // 7. Delete from End[cite: 3, 4]
    public static void deleteFromEnd() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }

        System.out.println("Deleted value: " + tail.data);
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    // 8. Delete from Position (1-based)[cite: 3, 4]
    public static void deleteFromPosition(int pos) {
        int len = countNodes();
        if (pos < 1 || pos > len) {
            System.out.println("Invalid position!");
            return;
        }

        if (pos == 1) {
            deleteFromBeginning();
            return;
        }

        if (pos == len) {
            deleteFromEnd();
            return;
        }

        DoublyNode temp = head;
        for (int i = 1; i < pos; i++) {
            temp = temp.next;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        System.out.println("Deleted value " + temp.data + " from position " + pos + ".");
    }

    // 9. Delete by Value[cite: 3, 4]
    public static void deleteByValue(int value) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        DoublyNode temp = head;
        while (temp != null && temp.data != value) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Value " + value + " not found in the list.");
            return;
        }

        if (temp == head) {
            deleteFromBeginning();
            return;
        }

        if (temp == tail) {
            deleteFromEnd();
            return;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        System.out.println("Deleted node with value " + value + ".");
    }

    // 10. Search[cite: 3, 4]
    public static void search(int value) {
        DoublyNode temp = head;
        int pos = 1;
        while (temp != null) {
            if (temp.data == value) {
                System.out.println("Value " + value + " found at position " + pos + ".");
                return;
            }
            temp = temp.next;
            pos++;
        }
        System.out.println("Value " + value + " is not present in the list.");
    }

    // 11. Update[cite: 3, 4]
    public static void update(int targetValue, int newValue) {
        DoublyNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.data == targetValue) {
                temp.data = newValue;
                found = true;
            }
            temp = temp.next;
        }

        if (found) {
            System.out.println("Updated value " + targetValue + " to " + newValue + ".");
        } else {
            System.out.println("Value " + targetValue + " not found.");
        }
    }

    // 12. Display Forward[cite: 3, 4]
    public static void displayForward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        System.out.print("Forward List: null <- ");
        DoublyNode temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" <-> ");
            }
            temp = temp.next;
        }
        System.out.println(" -> null");
    }

    // 13. Display Backward[cite: 3, 4]
    public static void displayBackward() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }
        System.out.print("Backward List: null <- ");
        DoublyNode temp = tail;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.prev != null) {
                System.out.print(" <-> ");
            }
            temp = temp.prev;
        }
        System.out.println(" -> null");
    }

    // 14. Count Nodes[cite: 3, 4]
    public static int countNodes() {
        int count = 0;
        DoublyNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // 15. Find Maximum[cite: 3, 4]
    public static void findMaximum() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        int max = head.data;
        DoublyNode temp = head.next;
        while (temp != null) {
            if (temp.data > max) {
                max = temp.data;
            }
            temp = temp.next;
        }
        System.out.println("Maximum value: " + max);
    }

    // 16. Find Minimum[cite: 3, 4]
    public static void findMinimum() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        int min = head.data;
        DoublyNode temp = head.next;
        while (temp != null) {
            if (temp.data < min) {
                min = temp.data;
            }
            temp = temp.next;
        }
        System.out.println("Minimum value: " + min);
    }

    // 17. Find Middle Element (Two-Pointer Technique)[cite: 3, 4]
    public static void findMiddleElement() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        DoublyNode slow = head;
        DoublyNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle element: " + slow.data);
    }

    // 18. Reverse[cite: 3, 4]
    public static void reverse() {
        if (head == null || head.next == null) {
            System.out.println("List reversed.");
            return;
        }

        DoublyNode temp = null;
        DoublyNode current = head;

        tail = head; // Current head becomes the new tail

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev; // Move backward using updated prev link
        }

        if (temp != null) {
            head = temp.prev; // Update head pointer
        }

        System.out.println("List reversed successfully.");
    }

    // 19. Sort (Bubble Sort)[cite: 3, 4]
    public static void sort() {
        if (head == null || head.next == null) {
            System.out.println("List sorted.");
            return;
        }

        boolean swapped;
        do {
            swapped = false;
            DoublyNode current = head;

            while (current.next != null) {
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);

        System.out.println("List sorted in ascending order.");
    }

    // 20. Remove Duplicates[cite: 3, 4]
    public static void removeDuplicates() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        DoublyNode current = head;
        while (current != null) {
            DoublyNode runner = current.next;
            while (runner != null) {
                if (runner.data == current.data) {
                    DoublyNode nextNode = runner.next;
                    
                    if (runner.prev != null) {
                        runner.prev.next = runner.next;
                    }
                    if (runner.next != null) {
                        runner.next.prev = runner.prev;
                    } else {
                        tail = runner.prev; // If tail is removed, update tail pointer
                    }
                    
                    runner = nextNode;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
        System.out.println("Duplicates removed successfully.");
    }
}