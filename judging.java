import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class judging {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int i = n;
        int output = 0;
        ArrayList<String> dom = new ArrayList<>();
        ArrayList<String> kat = new ArrayList<>();
        while (i-- > 0) {
            dom.add(input.next());
        }
        i = n;
        while(i-->0) {
            kat.add(input.next());
        }
        Collections.sort(dom);
        Collections.sort(kat);
        i = 0;
        int j = 0;
        while (i < n && j < n) {
            if (dom.get(i).equals(kat.get(j))) {
                output += 1;
                i ++;
                j ++;
                continue;
            }
            if (dom.get(i).compareTo(kat.get(j)) > 0) {
                j ++;
            }
            else {
                i ++;
            }
        }
        System.out.println(output);

    }
}