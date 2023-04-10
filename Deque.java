/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

    private Node<Item> first;
    private Node<Item> last;
    private int n;

    private int size;

    private class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Deque() {
        first = null;
        last = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void addFirst(Item item) {
        if ;
    }

    public void addLast(Item item) {
    }

    public Item removeFirst() {
    }

    public Item removeLast() {
    }

    public Iterator<Item> iterator() {
    }

    public static void main(String[] args) {

    }
}
