import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;

class courseScheduling {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(br.readLine());
        Hashtable<String, HashSet<String>> courses = new Hashtable<>();
        StringBuilder output = new StringBuilder();
        while (n-- > 0) {
            String[] input = br.readLine().split(" ");
            if (!courses.containsKey(input[2])) {
                courses.put(input[2], new HashSet<>());
            }
            courses.get(input[2]).add(input[0] + input[1]);
        }
        Object[] c = courses.keySet().toArray();
        Arrays.sort(c);
        for (Object key : c) {
            output.append(key + " " + courses.get(key).size() + "\n");
        }
        pw.println(output.toString());
        pw.close();
        br.close();
    }
}