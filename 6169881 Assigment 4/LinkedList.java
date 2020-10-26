
/**
 * The class LinkedList implements a singly linked list of ElementType
 * The list uses a header (dummy) node.
 *
 * @author (6169881)
 */
public class LinkedList{


    /**********************************************************************************
     * The remove() and search() method implemented in this program were implemented
     * with the help of the slides privided by Prof. A. Hernandez.*
     * ****************************************************************************** */

    private Node first; // dummy header node

    /**
     * Default constructor. Sets this object as an empty list.
     *
     */
    public LinkedList()
    {
        first = new Node();
    }

    /**
     * Adds new element as the first element of the list.
     *
     * @param x element to be added to the list
     */
    public void add(ElementType x)
    {
        Node node = new Node();
        node.setInfo(x);
        node.setNext(first.getNext());
        first.setNext(node);
    }

    /**
     * Determines if linked list is empty.
     *
     * @return true if list contains no elements, false otherwise.
     */
    public boolean isEmpty()
    {
        return (first.getNext() == null);
    }

    /**
     * Removes given element from the list.
     *
     * @param x element to be removed
     */
    public void remove(String x)
    {
        Node oldNode = first.getNext();
        Node newFirst = first;

        boolean found = false;

        while (oldNode != null && !found)
        {
            if (oldNode.getInfo().identifier == x)
            {
                found = true;
            }
            else
            {
                newFirst = oldNode;
                oldNode = newFirst.getNext();
            }

            if(found)
                newFirst.setNext(oldNode.getNext());
        }
    }

    /**
     * Determines if a given element is in the list.
     *
     * @param x element to be searched
     * @return true if x is in the list, false otherwise
     */
    public boolean search(String x)
    {
        Node current = first.getNext();

        while (current != null) {
            if (current.getInfo().identifier == x) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    /**
     * Constructs a String description of the list.
     *
     * @return String containing the list elements.
     */
    public String toString() {
        Node current = first.getNext();

        String str = "";
        while (current != null) {
            str += current.getInfo() + " -> ";
            current = current.getNext();
        }
        return str;
    }

}
