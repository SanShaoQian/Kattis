import java.io.*;
import java.util.*;

class racing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int change = 0;
        while (n-- > 0) {
            String[] input = br.readLine().split(" ");
            int instruction = Integer.parseInt(input[0]);
            int i = Integer.parseInt(input[1]);
            if (instruction == 1) { //add to scoreboard
                pq.add(i - change);
            }
            if (instruction == 2) { //perform operation
                change += i;
            }
            if (instruction == 3) {
                if(i == 1) {
                    output.append(pq.peek() + change).append("\n");
                    continue;
                }
                ArrayList<Integer> top = new ArrayList<>();
                while(i-->0){
                    top.add(pq.poll());
                }
                output.append(top.getLast() + change).append("\n");
                pq.addAll(top);
            }
        }
        pw.println(output);
        br.close();
        pw.close();
    }
}