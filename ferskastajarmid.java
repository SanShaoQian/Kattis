import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class ferskasta {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int max = 0;
        ArrayList<String> output = new ArrayList<>();
        while (n-- > 0) {
            String s = input.next();
            int fresh = input.nextInt()* input.nextInt();
            if (fresh > max) {
                max = fresh;
                output = new ArrayList<>();
                output.add(s);
                continue;
            }
            if (fresh == max) {
                output.add(s);
            }
        }
        Collections.sort(output);
        System.out.println(output.get(0));
    }
}