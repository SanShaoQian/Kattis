import java.io.*;
import java.util.*;

class gitGood {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> output = new HashSet<>();
        Stack<String> wd = new Stack<>();
        while (n-- > 0) {
            String[] s = br.readLine().split(" ");
            if (s[0].equals("cd")) {
                if (s[1].equals("..")) {
                    wd.pop();
                } else {
                    if (wd.isEmpty()) {
                        wd.push(s[1] + "/");
                    } else {
                        wd.push(wd.peek() + s[1] + "/");
                    }
                }
            }
            else if (s[0].equals( "nano")) {
                if (!wd.isEmpty()) {
                    output.add(wd.peek() + s[1]);
                }
                else {
                    output.add(s[1]);
                }
            }
        }
        String[] out = output.toArray(new String[output.size()]);
        Arrays.sort(out);
        StringBuilder sb = new StringBuilder();
        for (String s: out) {
            sb.append("git add ");
            sb.append(s);
            sb.append("\n");
        }
        sb.append("git commit");
        sb.append('\n');
        sb.append("git push");
        sb.append('\n');
        pw.println(sb);
        pw.close();
        br.close();
    }
}
