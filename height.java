import java.util.ArrayList;
import java.util.Scanner;

class kattis {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        while (N-- > 0) {
            input.nextLine();
            System.out.print(input.nextInt() + " ");
            int output = 0;
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                list.add(input.nextInt());
            }
            for (int i = 0; i < 19; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    int j = i;
                    while (j >= 0 && list.get(j) > list.get(i + 1)) {
                        j--;
                        output ++;
                    }
                    int temp = list.get(i+1);
                    list.remove(i+1);
                    list.add(j + 1, temp);
                }
            }
            System.out.println(output);
        }
    }
}