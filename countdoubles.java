import java.io.*;
import java.util.ArrayList;

class countdoubles {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        ArrayList<Integer> arr = new ArrayList<>();
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr.add((Integer.parseInt(input[i]) + 1)%2);
        }
        for (int i = 1; i < n; i++) {
            arr.set(i, arr.get(i-1) + arr.get(i));
        }
        int count = arr.get(m-1) > 1 ? 1 : 0;
        for (int i = m; i < n; i++) {
            count += arr.get(i) - arr.get(i-m) > 1 ? 1 : 0;
        }
        pw.println(count);
        br.close();
        pw.close();
    }
}