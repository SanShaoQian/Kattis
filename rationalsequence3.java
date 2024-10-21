import java.io.*;
import java.util.Stack;

class rational {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringBuilder output = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String[] input = br.readLine().split(" ");
            int K = Integer.parseInt(input[0]);
            int N = Integer.parseInt(input[1]);
            Stack<Character> direction = new Stack<>();
            while(N>1){
                if(N%2==1) {
                    direction.push('R');
                }
                else {
                    direction.push('L');
                }
                N = N/2;
            }
            int p = 1;
            int q = 1;
            while(!direction.isEmpty()){
                char c = direction.pop();
                if(c == 'L'){
                    q += p;
                }
                else {
                    p += q;
                }
            }
            output.append(K).append(" ").append(p).append('/').append(q).append('\n');
        }
        pw.println(output);
        br.close();
        pw.close();
    }
}