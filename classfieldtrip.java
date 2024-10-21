import java.util.Arrays;
import java.util.Scanner;

class fieldTrip {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine() + input.nextLine();
        char[] output = s.toCharArray();
        Arrays.sort(output);
        System.out.println(output);
    }
}