import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class stockprices {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();
        while (N-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int a = -1;
            int b = -1;
            int s = -1;
            PriorityQueue<int[]> buy = new PriorityQueue<>(new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return b[0] - a[0];
                }
            });
            PriorityQueue<int[]> sell = new PriorityQueue<>(new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return a[0] - b[0];
                }
            });
            while (n-- > 0) {
                String[] input = br.readLine().split(" ");
                int num = Integer.parseInt(input[1]);
                int price = Integer.parseInt(input[4]);
                if (input[0].equals("buy")) {
                    buy.add(new int[]{price, num});
                }
                else if (input[0].equals("sell")) {
                    sell.add(new int[]{price, num});
                }
                int temp = trade(sell,buy);
                while (temp != -1) {
                    s = temp;
                    temp = trade(sell, buy);
                }
                a = sell.isEmpty() ? -1 : sell.peek()[0];
                b = buy.isEmpty() ? -1 : buy.peek()[0];
                output.append(a == -1? "-":a);
                output.append(" ");
                output.append(b == -1? "-":b);
                output.append(" ");
                output.append(s == -1? "-":s);
                output.append("\n");
            }
        }
        pw.println(output);
        pw.close();
        br.close();
    }

    private static int trade(PriorityQueue<int[]> sell, PriorityQueue<int[]> buy) {
        if (sell.isEmpty() || buy.isEmpty()) {
            return -1;
        }
        if (sell.peek()[0] <= buy.peek()[0]) {
            int price = sell.peek()[0];
            if (sell.peek()[1] == buy.peek()[1]) {
                sell.poll();
                buy.poll();
            } else if (sell.peek()[1] > buy.peek()[1]) {
                sell.peek()[1] -= buy.peek()[1];
                buy.poll();
            } else if (sell.peek()[1] < buy.peek()[1]) {
                buy.peek()[1] -= sell.peek()[1];
                sell.poll();
            }
            return price;
        }
        return -1;
    }
}
