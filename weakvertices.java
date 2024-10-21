import java.io.*;
import java.util.Arrays;


class weakvertices {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringBuilder output = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while (n != -1) {
            int[][] matrix = new int[n][n];
            boolean[] isWeak = new boolean[n];
            Arrays.fill(isWeak, true);
            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(s[j]);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    for (int k = j; k < n; k++) {
                        if (matrix[i][k] + matrix[k][j] + matrix[i][j] == 3) {
                            isWeak[i] = false;
                            isWeak[j] = false;
                            isWeak[k] = false;
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if (isWeak[i]) {
                    output.append(i);
                    output.append(" ");
                }
            }
            n = Integer.parseInt(br.readLine());
            output.replace(output.length() - 1, output.length(), "\n");
        }
        System.out.println(output);
        br.close();
        pw.close();
    }
}