/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node<Item> first;
    private Node<Item> last;
    private int n;

    private class Node<Item> {
        private Item item;
        private Node<Item> next;
        private Node<Item> prev;
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
        return first == null;
    }

    public int size() {
        return n;
    }

    public void addFirst(Item item) {
        checkItem(item);

        Node<Item> old = first;
        first = new Node<Item>();
        first.item = item;
        first.next = old;
        first.prev = null;

        if (isEmpty()) {
            last = first;
        }
        else old.prev = first;

        n++;
    }

    public void addLast(Item item) {
        checkItem(item);

        Node<Item> old = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        last.prev = old;

        if (isEmpty()) first = last;
        else old.next = last;
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
        private Node<Item> current;

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
