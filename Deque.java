/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int n;

    private class Node {
        private Item item = null;
        private Node next = null;
        private Node prev = null;
    }

    public Deque() {
        first = null;
        last = null;
        n = 0;
    }

    private void checkItem(Item item) {
        if (item == null)
            throw new NullPointerException("NULL Bish");
    }

    private void checkList() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty list man");
        }
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void addFirst(Item item) {
        checkItem(item);

        Node oldf = first;
        first = new Node();
        first.item = item;
        first.next = oldf;

        if (isEmpty()) {
            last = first;
        }
        else {
            oldf.prev = first;
        }

        n++;
    }

    public void addLast(Item item) {
        checkItem(item);

        Node oldl = last;
        last = new Node();
        last.item = item;
        last.prev = oldl;

        if (isEmpty()) first = last;
        else oldl.next = last;

        n++;
    }


    public Item removeFirst() {
        checkList();
        Item item = first.item;
        n--;
        if (isEmpty()) {
            first = null;
            last = null;
        }
        else {
            first = first.next;
            first.prev = null;
        }
        return item;
    }

    public Item removeLast() {
        checkList();
        Item item = last.item;
        n--;
        if (isEmpty()) {
            first = null;
            last = null;
        }
        else {
            last = last.prev;
            last.next = null;
        }
        return item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current;

        public ListIterator() {
            current = first;
        }

        public boolean hasNext() {
            return current.next != null;
        }

        public Item next() {
            if (hasNext()) {
                Item item = current.item;
                current = current.next;
                return item;
            }
            else {
                throw new NoSuchElementException("No such element");
            }
        }


    }

    public static void main(String[] args) {
    }
}
