import java.io.*;
import java.util.*;

class circuitMath {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(br.readLine());
        String[] firstLine = br.readLine().split(" ");
        boolean[] truthValues = new boolean[n];
        for (int i = 0; i < n; i++) {
            truthValues[i] = firstLine[i].equals("T");
        }
        String[] circuit = br.readLine().split(" ");
        Stack<Boolean> stack = new Stack<>();
        for (String component: circuit) {
            if(component.equals("*")) {
                Boolean first = stack.pop();
                Boolean second = stack.pop();
                stack.push(first && second);
            }
            else if(component.equals("-")) {
                stack.push(stack.pop()? Boolean.FALSE:Boolean.TRUE);
            }
            else if(component.equals("+")) {
                Boolean first = stack.pop();
                Boolean second = stack.pop();
                stack.push(first || second);
            }
            else {
                stack.push(truthValues[component.charAt(0) - 65]);
            }
        }
        pw.println(stack.peek() ? "T":"F");
        br.close();
        pw.close();
    }
}