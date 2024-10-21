import java.io.*;

class candydivision {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        Long n = Long.parseLong(br.readLine());
        StringBuilder front = new StringBuilder();
        StringBuilder back = new StringBuilder();
        Long i = 1L;
        while (i*i <= n) {
            if (i*i == n) {
                front.append(i - 1).append(" ");
            }
            else if (n%i == 0) {
                front.append(i - 1).append(" ");
                StringBuilder b = new StringBuilder();
                b.append(n/i - 1).reverse();
                back.append(" ").append(b);
            }
            i++;
        }
        pw.println(front + back.reverse().toString());
        pw.close();
        br.close();
    }
}
