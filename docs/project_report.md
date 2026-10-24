# Project Report: Linked List Management System

## 1. Introduction
This project is a menu-driven Java application implementing two fundamental linear data structures: **Singly Linked List** and **Doubly Linked List**. The program provides an interactive command-line interface (CLI) to perform dynamic operations such as insertions, deletions, searching, traversals, sorting, reversal, and utility calculations.

---

## 2. Key Features & Menu Operations

### Singly Linked List (`SinglyLinkedList.java`)
1. **Insert:** Add a node at a specified position.
2. **Delete:** Remove a node from a specified position.
3. **Search:** Search for a target value in the list.
4. **Update:** Replace an existing value with a new value.
5. **Display:** Print all nodes sequentially.
6. **Count Nodes:** Count the total number of nodes.
7. **Find Maximum:** Find the node with the highest value.
8. **Find Minimum:** Find the node with the lowest value.
9. **Find Middle Element:** Retrieve the value located at the center of the list.
10. **Reverse:** Reverse all node pointers in-place.
11. **Sort:** Sort elements in ascending order using Bubble Sort.
12. **Remove Duplicates:** Delete duplicate elements.

### Doubly Linked List (`DoublyLinkedList.java`)
1. **Insertions:** Insert at Beginning, Insert at End, Insert at Position, Insert After a Node, Insert Before a Node.
2. **Deletions:** Delete from Beginning, Delete from End, Delete from Position, Delete by Value.
3. **Traversals:** Display Forward (`head` -> `tail`), Display Backward (`tail` -> `head`).
4. **Search & Update:** Locate value positions and update target node values.
5. **Utilities & Algorithms:** Count Nodes, Find Maximum, Find Minimum, Find Middle Element (Fast & Slow pointer method), Reverse List In-Place, Sort (Bubble Sort), Remove Duplicates.

---

## 3. Data Structure Comparison & Complexity

| Operation | Singly Linked List | Doubly Linked List |
| :--- | :--- | :--- |
| **Pointers per Node** | 1 (`next`) | 2 (`prev`, `next`) |
| **Traversal Direction** | Unidirectional (Forward) | Bidirectional (Forward & Backward) |
| **Insert at Head** | O(1) | O(1) |
| **Insert at Tail** | O(N) | O(1) *(with `tail` pointer)* |
| **Delete from Head** | O(1) | O(1) |
| **Delete from Tail** | O(N) | O(1) *(with `tail` pointer)* |
| **Search / Update** | O(N) | O(N) |
| **Reverse In-Place** | O(N) | O(N) |
| **Sort (Bubble Sort)** | O(N²) | O(N²) |
| **Space Complexity** | O(N) | O(N) *(Higher memory per node)* |

---

## 4. GitHub Repository Structure

```text
Linked-List-Management-System/
├── README.md
├── .gitignore
├── src/
│   ├── SinglyLinkedList.java
│   └── DoublyLinkedList.java
├── sample-output/
│   └── output.txt
└── docs/
    └── project-report.pdf
