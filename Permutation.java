/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args) {
        if (args.length == 1) {
            int n = Integer.parseInt(args[0]);
            RandomizedQueue<String> ranq = new RandomizedQueue<>();
            while (!StdIn.isEmpty()) {
                ranq.enqueue(StdIn.readString());
            }
            for (int i = 0; i < n; i++) {
                StdOut.println(ranq.dequeue());
            }
        }
    }
}
