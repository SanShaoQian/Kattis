import java.io.*;
import java.util.Hashtable;


class eiginnofn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(br.readLine());
        Hashtable<String,String> names = new Hashtable<>();
        while (n-- > 0) {
            String[] input = br.readLine().split(" ");
            if (input.length == 1) {
                names.put(input[0], "");
            }
            else {
                names.put(input[0],input[1]);
            }
        }
        int m = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();
        while (m-- > 0) {
            String s = br.readLine();
            if (!names.containsKey(s)) {
                output.append("Neibb");
                output.append("\n");
            }
            else {
                String name = names.get(s);
                if (name.equals("")) {
                    output.append("Jebb");
                    output.append("\n");
                } else {
                    output.append(String.format("Neibb en %s %s er heima", s,name));
                    output.append("\n");
                }
            }
        }
        pw.println(output);
        br.close();
        pw.close();
    }
}