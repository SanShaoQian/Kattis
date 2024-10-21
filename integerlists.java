import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

class intList {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringBuilder output = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String instruction = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String s = br.readLine();
            String[] lst = s.substring(1,s.length()-1).split(",");
            Deque<Integer> dq = new ArrayDeque<>();
            for (String i:lst) {
                if (i != "") {
                    dq.add(Integer.parseInt(i));
                }
            }
            output.append(check(instruction, dq));
            output.append("\n");
        }
        pw.println(output.toString());
        br.close();
        pw.close();
    }

    private static String check(String instruction, Deque<Integer> dq) {
        boolean reverse = false;
        for (Character c:instruction.toCharArray()) {
            if (c == 'R') {
                reverse = !reverse;
            }
            else if (c == 'D') {
                if(dq.isEmpty()) {
                    return "error";
                }
                if (reverse) {
                    dq.pollLast();
                }
                else {
                    dq.pollFirst();
                }
            }
        }
        if (reverse) {
            ArrayList<Integer> a = new ArrayList<>();
            while (!dq.isEmpty()) {
                a.add(dq.pollLast());
            }
            return a.toString().replaceAll(" ", "");
        }
        return dq.toString().replaceAll(" ","");
    }
}