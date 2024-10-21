import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class noThanks {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        input.nextLine();
        ArrayList<Integer> cards = new ArrayList<>();
        while(N-- > 0) {
            cards.add(input.nextInt());
        }
        Collections.sort(cards);
        int output = cards.get(0);
        for (int i = 1; i < cards.size(); i++) {
            if (cards.get(i) != cards.get(i - 1) + 1) {
                output += cards.get(i);
            }
        }
        System.out.println(output);
    }
}