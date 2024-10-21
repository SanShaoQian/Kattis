import java.util.Scanner;

class rice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        String want = input.next();
        int maxSum = 0;
        int max = 0;
        int output = 0;
        for (int i = 0; i < N; i++) {
            int A = input.nextInt();
            int S = input.nextInt();
            if (A + S < maxSum) {
                continue;
            }
            if (A+S == maxSum) {
                if (want.equals("antal")) {
                    if (A > max) {
                        max = A;
                        output = i;
                    }
                }
                if (want.equals("storlek")) {
                    if (S > max) {
                        max = S;
                        output = i;
                    }
                }
                continue;
            }
            maxSum = A + S;
            if (want.equals("antal")) {
                max = A;
            } else {
                max = S;
            }
            output = i;
        }
        System.out.println(output + 1);
    }
}