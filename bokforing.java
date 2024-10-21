import java.io.*;
import java.util.HashMap;


class accounting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringBuilder output = new StringBuilder();
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        HashMap<Integer,Integer> settings = new HashMap<>();
        int base = 0;
        while (m-- > 0) {
            s = br.readLine().split(" ");
            if (s[0].equals("SET")) {
                settings.put(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
            }
            else if (s[0].equals("PRINT")) {
                int key = Integer.parseInt(s[1]);
                if (settings.containsKey(key)) {
                    output.append(settings.get(key)).append("\n");
                } else {
                    output.append(base).append(" ").append("\n");
                }
            }
            else if (s[0].equals("RESTART")) {
                base = Integer.parseInt(s[1]);
                settings.clear();
            }
        }
        pw.println(output);
        br.close();
        pw.close();
    }
}