/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] items;
    private int n;

    // construct an empty randomized queue
    public RandomizedQueue() {
        items = (Item[]) new Object[2];
        n = 0;
    }

    private void resize(int cap) {
        Item[] copy = (Item[]) new Object[cap];
        for (int i = 0; i < n; i++)
            copy[i] = items[i];

        items = copy;
    }

    private void swapShit() {
        int i = StdRandom.uniformInt(size());
        Item temp = items[i];
        items[i] = items[n - 1];
        items[n - 1] = temp;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return n;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new NoSuchElementException("NO Such Element exists");
        }
        items[n++] = item;
        if (n == items.length) {
            resize(2 * n);
        }
        swapShit();
    }

    // remove and return a random item
    public Item dequeue() {
        if (n == 0) {
            throw new NoSuchElementException("Nothing left man");
        }
        Item item = items[--n];
        if (n > 0 && n < items.length / 4) {
            resize(items.length / 2);
        }
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException("No Element Left To Sample :(");
        }
        int i = StdRandom.uniformInt(n);
        return items[i];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private int i;

        public boolean hasNext() {
            return items[i] != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (hasNext()) {
                Item item = items[i++];
                return item;
            }
            else {
                throw new NoSuchElementException("Its the end my friend");
            }
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
    }

}
