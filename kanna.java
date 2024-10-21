import java.io.*;
import java.util.*;

class kanna {
    private static byte[] b;
    private static int off;

    public static void main(String[] args) throws IOException {
        System.in.read(b = new byte[System.in.available()]);
        PrintWriter writer = new PrintWriter(new BufferedWriter(
                new OutputStreamWriter(System.out)));
        int N = getInt();
        int Q = getInt();
        Edges edges = new Edges(N);
        StringBuilder sb = new StringBuilder();
        while (Q-->0) {
            int a = getInt();
            if (a == 1) {
                int x = getInt();
                int y = getInt();
                edges.insert(x,y);
            }
            else if (a == 2) {
                sb.append(edges.covered).append("\n");
            }
        }
        writer.println(sb);
        writer.flush();
        writer.close();
    }

    private static int getInt() {
        byte c;
        do {
            c = b[off++];
        } while (c < '0' || c > '9');
        int res = 0;
        do {
            res = res * 10 + c - '0';
        } while (off<b.length &&(c = b[off++]) >= '0');
        return res;
    }
}

class Edges {
    int N;
    TreeSet<int[]> edge;
    int covered;

    public Edges(int N) {
        this.N = N;
        this.edge = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        this.covered = 0;
    }

    public void insert(int start, int end) {
        int[] temp = new int[]{start, end};
        int[] lower = edge.floor(temp);
        int[] higher = edge.higher(temp);
        boolean ready = true;
        if (lower != null && lower[1] >= start - 1) {
            edge.remove(lower);
            temp = new int[]{lower[0], Math.max(end, lower[1])};
            covered -= lower[1] - lower[0] + 1;
            ready = false;
        }
        if (higher != null && higher[0] <= end + 1) {
            temp = new int[]{temp[0], Math.max(temp[1], higher[1])};
            edge.remove(higher);
            covered -= higher[1] - higher[0] + 1;
            ready = false;
        }
        if (ready) {
            edge.add(temp);
            covered += temp[1] - temp[0] + 1;
        } else {
            this.insert(temp[0], temp[1]);
        }
    }
}
