import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

class jamboree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        ArrayList<Integer> arr = new ArrayList<>();
        s = br.readLine().split(" ");
        for (String str: s) {
            arr.add(Integer.parseInt(str));
        }
        Collections.sort(arr);
        if (N > M) {
            int extras = N - M;
            for (int i = 0; i < extras; i++) {
                arr.set(i, arr.get(i) + arr.get(2* extras - i - 1));
                arr.set(2* extras - i - 1, 0);
            }
            Collections.sort(arr);
        }
        pw.println(arr.getLast());
        pw.close();
        br.close();
    }
}
