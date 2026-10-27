import java.util.Scanner;

class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data= data;
        this.next= null;
    }
}

public class SinglyLinkedList
{
    private static Node root= null;

    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        int choice, data, pos, value; // Added missing 'value' variable declaration
        while(true)
        {
            System.out.println("********** Operation on Singly Linked List **********");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Update");
            System.out.println("5. Display");
            System.out.println("6. Count Nodes");
            System.out.println("7. Find Maximum");
            System.out.println("8. Find Minimum");
            System.out.println("9. Find Middle Element");
            System.out.println("10. Reverse");
            System.out.println("11. Sort");
            System.out.println("12. Remove Duplicates");
            System.out.println("13. Exit");

            System.out.println("Enter your choice: ");
            choice= sc.nextInt();

            switch(choice)
            {
                case 1:
                {
                    System.out.print("Enter value to insert : ");
                    data=sc.nextInt();
                    System.out.print("Enter the position : ");
                    pos=sc.nextInt();
                    insert(data, pos);
                    break;
                }
                case 2:
                {
                    System.out.print("Enter position for deleting the value : ");
                    pos=sc.nextInt();
                    delete(pos);
                    break;
                }
                case 3:
                {
                    System.out.println("Enter the Value which has to be searched in the linked list: ");
                    value= sc.nextInt();
                    search(value);
                    break;
                }
                case 4:
                {
                    System.out.println("Enter the value which you want to replace it with: ");
                    value= sc.nextInt();
                    System.out.println("Enter the replace value: ");
                    int new_value= sc.nextInt();
                    update(value, new_value);
                    break;
                }
                case 5:
                {
                    display();
                    break;
                }
                case 6:
                {
                    System.out.println("No. of Nodes in the linkedlist : "+ Count_Nodes());
                    break;
                }
                case 7:
                {
                    System.out.println("Maximum value in linkedlist is : "+  Max());
                    break;
                }
                case 8:
                {
                    System.out.println("Minimum value in linkedlist is : "+ Minimum());
                    break;
                }
                case 9:
                {
                    System.out.println("Middle Element of the linked list is : "+ Middle_Element());
                    break;
                }
                case 10:
                {
                    Reverse_List();
                    break;
                }
                case 11:
                {
                    Sort_List();
                    break;
                }
                case 12:
                {
                    Remove_Duplicates();
                    break;
                }
                case 13:
                {
                    System.out.println("Exiting program");
                    sc.close();
                    System.exit(0);
                }
                default:
                    System.out.println("Entered choice is invalid ");
            }
        }
    }

    public static void insert(int data, int pos)
    {
        Node newNode= new Node(data);
        Node temp= root;
        Node hold;
        int len= Count_Nodes();
        
        if(pos==1 && len==0)  //Insert at Beginning if LinkedList is fully Empty
        {
            root= newNode;        
        }
        else if(pos==1 && pos<=len)   //Insert at Beginning if LinkedList is already having some node
        {
            newNode.next=root;      
            root= newNode;
        }
        else if(pos==len)    //Insert at End 
        {
            int i=1;
            while(i<pos-1)
            {
                temp=temp.next;
                i++;
            }
            hold=temp;
            temp=temp.next;
            newNode.next=temp;
            hold.next=newNode;
        }
        else if(pos==len+1)     //Insert at End: right after last node
        {
            while(temp.next != null)
            {
                temp=temp.next;
            }
            temp.next=newNode;
        }
        else if(pos<len && pos>1)  //Insert at Position
        {
            int i=1;
            while(i<pos-1)
            {
                temp=temp.next;
                i++;
            }
            hold=temp;
            temp=temp.next;
            newNode.next=temp;
            hold.next=newNode;
        }
        else
        {
            System.out.println("Invalid Position\n");
            System.out.println("The length of the position is\n"+len);
        }
    }


    public static void delete(int pos)
    {
        int len= Count_Nodes();
        Node temp= root;
        Node hold;
        if(pos>len || pos<1)               //If List is empty
        {
            System.out.println("\nInvalid Location");
            System.out.println("\nCurrently the length of linked list is "+len);
        }
        else if(pos==1)             //if first node has to be deleted
        {
            root= root.next;
            temp.next= null;
        }
        else
        {
            int i=1;             
            while(i<pos-1)
            {
                temp=temp.next;
                i++;
            }
            hold=temp.next;
            temp.next=hold.next;
            hold.next=null;
        }
    }


    public static void search(int value)
    {
        boolean flag= false;
        Node temp= root;
        if(root == null)    //if list is empty
        {
            System.out.println("Linked List is Empty");
        }
        else
        {
            while(temp != null)         //searching in whole list
            {
                if(temp.data == value)
                {
                    System.out.println("The value has been found");
                    flag= true;
                    break;
                }
                else 
                {
                    temp= temp.next;
                }
            }
            if(flag == false)
            {
                System.out.println("The value is not present in linked list");
            }
        }
    } 


    public static void update(int value, int new_value)
    {
        Node temp= root;
        if(root == null)    //if list is empty
        {
            System.out.println("Linked List is Empty");
        }
        else
        {
            while(temp != null)
            {
                if(temp.data == value)
                {
                    temp.data= new_value;
                }
                temp= temp.next; 
            }
        }
    }

    public static void display() 
    {
        if(root == null)
        {
            System.out.println("List is empty");
            return;
        }
        else
        {
            Node temp=root;
            System.out.print("Linked List : ");
            while(temp != null)
            {
                System.out.print(temp.data +" -> ");
                temp=temp.next;
            }
            System.out.println("null");
        }
    }


    public static int Count_Nodes() 
    {
        int count=0;
        Node temp=root;
        while(temp != null)
        {
            count++;
            temp=temp.next;
        }
        return count;
    }


    public static int Max()
    {
        Node temp= root;
        if(root==null)
        {
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        }
        else
        {
            int max= temp.data;
            while(temp!=null)
            {
                if(max<temp.data)
                {
                    max= temp.data;
                }
                temp= temp.next; 
            }
            return max;
        }
    }


    public static int Minimum()
    {
        Node temp= root;
        if(root==null)
        {
            System.out.println("Linked list is empty");
            return Integer.MAX_VALUE;
        }
        else
        {
            int min= temp.data;
            while(temp!=null)
            {
                if(min>temp.data)
                {
                    min= temp.data;
                }
                temp= temp.next; 
            }
            return min;
        }
    }


    public static int Middle_Element() 
    {
        int len = Count_Nodes();
        if (len == 0) 
        {
            System.out.println("The linked list is empty.");
            return -1;
        }

        int midIndex = len / 2; // For odd length, gets middle. For even length, gets middle-right.
        Node temp = root;

        for (int i = 0; i < midIndex; i++) 
        {
            temp = temp.next;
        }

        return temp.data;
    }

    public static void Reverse_List() 
    {
        Node prev = null;
        Node current = root;
        Node next = null;

        while (current != null) 
        {
            next = current.next; // Store next node
            current.next = prev; // Reverse pointer direction
            prev = current;      // Move prev one step forward
            current = next;      // Move current one step forward
        }

        root = prev; // Update the head pointer to the new first element
    }

    public static void Sort_List() 
    {
        if (root == null || root.next == null) 
        {
            return; // Already sorted if empty or single element
        }

        boolean swapped;
        do 
        {
            swapped = false;
            Node current = root;

            while (current.next != null) 
            {
                if (current.data > current.next.data) 
                {
                    // Swap the data values
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } 
        while (swapped);
    }

    public static void Remove_Duplicates() 
    {
        Node current = root;

        while (current != null && current.next != null) 
        {
            if (current.data == current.next.data) 
            {
                // Skip the duplicate node
                current.next = current.next.next;
            } 
            else 
            {
                current = current.next;
            }
        }
    }
}
