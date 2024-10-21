import java.io.*;
import java.util.*;

class delimiter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(br.readLine());
        String L = br.readLine();
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        String output = "ok so far";
        for(int i = 0; i < n; i++) {
            Character c = L.charAt(i);
            if(c.equals(' ')) {
                continue;
            }
            if(map.get(c) == null) {
                stack.push(c);
            }
            else if(stack.isEmpty()) {
                output = c + " " + i;
                break;
            }
            else if(map.get(c).equals(stack.peek())) {
                stack.pop();
            }
            else {
                output = c + " " + i;
                break;
            }
        }
        pw.println(output);
        br.close();
        pw.close();
    }
}