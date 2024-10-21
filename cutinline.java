import java.util.ArrayList;
import java.util.Scanner;

class cutInLine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        ArrayList<String> list = new ArrayList<>();
        input.nextLine();
        while (n-- > 0) {
            list.add(input.nextLine());
        }
        int c = input.nextInt();
        while (c-- > 0) {
            String action = input.next();
            String person = input.next();
            if (action.equals("leave")) {
                list.remove(person);
            }
            if (action.equals("cut")) {
                int i = list.indexOf(input.next());
                list.add(i, person);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}