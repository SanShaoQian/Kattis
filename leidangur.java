import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class leidangur {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        char[] input = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        for (Character c : input) {
            if (c == 'p' || c == 'g' || c == 'o')  {
                stack.push(c);
            }
            else if (c == 'P' || c == 'G' || c == 'O') {
                Character toGive = (char) (c.charValue() + 32);
                while (!stack.isEmpty() && stack.peek() != toGive) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    pw.println("Neibb");
                    pw.close();
                    br.close();
                    return ;
                }
                stack.pop();
            }
        }
        ArrayList<Integer> output = new ArrayList<>();
        output.add(0);
        output.add(0);
        output.add(0);
        while (!stack.isEmpty()) {
            char ch = stack.pop();
            if (ch == 'p') output.set(0, output.get(0) + 1);
            else if (ch == 'g') output.set(1, output.get(1) + 1);
            else if (ch == 'o') output.set(2, output.get(2) + 1);
        }
        for (int i: output) {
            pw.println(i);
        }
        pw.close();
        br.close();
    }
}