/* *****************************************************************************
 *  Name: Dinkar Kumar
 *  Date: 09/05/2020
 *  Description:Implementation of Quick-Union Algorithm from Robert Sidgewick ,Section 1.5
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickFind {
    private int[] id; // access to compponent id
    private int count; // number of components


    public QuickFind(int N) {
        // Initialize component id array
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {
        // put p and q into the same component
        int pId = find(p);
        int qId = find(q);

        // Nothing to do if p and q are already in the same component
        if (pId == qId)
            return;
        // Rename p's component to q's name
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId)
                id[i] = qId;
        }
        count--;
    }

    public static void main(String[] args) {
        // Solve Dynamic connectivity problem on StdIn
        int N = StdIn.readInt(); // read number of sites
        QuickFind uf = new QuickFind(N); // Initialize n components
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt(); // Read pair to connect
            if (uf.connected(p, q)) continue; // Ignore if connected
            uf.union(p, q); // Combine components
            StdOut.println(p + " " + q); // print connections
        }
        StdOut.println(uf.count() + " components");
    }
}
