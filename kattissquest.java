import java.io.*;
import java.util.*;

class kattissquest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();
        TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
        while (n-- > 0) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("add")) {
                int key = Integer.parseInt(input[1]);
                int value = Integer.parseInt(input[2]);
                if (!map.containsKey(key)) {
                    PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
                        public int compare(Integer o1, Integer o2) {
                            return o2 - o1;
                        }
                    });
                    pq.add(value);
                    map.put(key, pq);
                } else {
                    map.get(key).add(value);
                }
            }
            else if (input[0].equals("query")) {
                int X = Integer.parseInt(input[1]);
                long ans = 0;
                while (X>0) {
                    Map.Entry<Integer, PriorityQueue<Integer>> entry = map.floorEntry(X);
                    if (entry == null) {
                        break;
                    }
                    ans += entry.getValue().poll();
                    X -= entry.getKey();
                    if (entry.getValue().isEmpty()) {
                        map.remove(entry.getKey());
                    }
                }
                output.append(ans).append("\n");
            }
        }
        pw.println(output);
        br.close();
        pw.close();
    }
}