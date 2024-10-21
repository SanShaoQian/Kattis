import java.io.*;
import java.util.Map;
import java.util.TreeMap;

class sannvirdi {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(br.readLine());
        TreeMap<Integer, String> map = new TreeMap<>();
        while (n-- > 0) {
            String[] input = br.readLine().split(" ");
            map.put(Integer.parseInt(input[1]), input[0]);
        }
        int q = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();
        while (q-- > 0) {
            int ans = Integer.parseInt(br.readLine());
            Map.Entry<Integer, String> entry = map.floorEntry(ans);
            if (entry != null) {
                output.append(entry.getValue()).append("\n");
            } else {
                output.append(":(").append("\n");
            }
        }
        pw.println(output);
        br.close();
        pw.close();
    }
}