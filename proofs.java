import java.io.*;
import java.util.HashSet;

class proofs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> conclusions = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            boolean conclusion = false;
            for (String s: line) {
                if (s.equals("->")) {
                    conclusion = true;
                    continue;
                }
                if (conclusion) {
                    conclusions.add(s);
                }
                else {
                    if (!conclusions.contains(s)) {
                        pw.println(i+1);
                        br.close();
                        pw.close();
                        return;
                    }
                }
            }
        }
        pw.println("correct");
        br.close();
        pw.close();
    }
}