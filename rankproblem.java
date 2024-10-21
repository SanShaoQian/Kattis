import java.util.ArrayList;
import java.util.Scanner;

class kattis {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int i = 0;
        ArrayList<String> list = new ArrayList<String>();
        while (i++<n) {
            list.add("T" + (i));
        }
        i = 0;
        while (i++<m) {
            input.nextLine();
            String win = input.next();
            String lose = input.next();
            if (list.indexOf(win) < list.indexOf(lose)) {
                continue;
            }
            list.remove(lose);
            list.add(list.indexOf(win) + 1,lose);
        }
        StringBuilder output = new StringBuilder();
        for(String str : list){
            output.append(str);
            output.append(" ");
        }
        System.out.println(output);
    }
}
