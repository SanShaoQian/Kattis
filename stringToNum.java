//https://nus.kattis.com/courses/CS2040/CS2040_S2_AY2324/assignments/iidei6/problems/t9spelling
import java.io.*;

class stringToNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringBuilder output = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringBuilder out = new StringBuilder();
            for (char c: br.readLine().toCharArray()) {
                String add = "0";
                if (c == 'z') {
                    add = "9999";
                }
                else if (c != ' ') {
                    int n = c - 'a';
                    if (c > 's') {
                        n -= 1;
                    }
                    Integer num = n / 3 + 2;
                    add = num.toString().repeat(n % 3 + 1);
                    if (c == 's') {
                        add = "7777";
                    }
                }
                if (!out.isEmpty() && out.substring(out.length() - 1).equals(add.substring(0,1))) {
                    out.append(" ");
                }
                out.append(add);
            }
            output.append(String.format("Case #%d: %s", i + 1, out.toString()));
            output.append("\n");
        }
        pw.println(output);
        pw.close();
        br.close();
    }
}
