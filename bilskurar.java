import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class bilskurar {
    static long output;

    public static void main(String[] args) {
        output = 0;
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        ArrayList<Integer> house = new ArrayList<>();
        Map<Integer, Integer> garage = new HashMap<>();
        for (int i = 0; i < n; i++) {
            house.add(input.nextInt());
        }
        for (int i = 0; i < n; i++) {
            garage.put(input.nextInt(),i);
        }
        for (int i = 0; i < house.size(); i++) {
            house.set(i, garage.get(house.get(i)));
        }
        sort(house, 0, house.size());
        System.out.println(output);
    }

    private static ArrayList<Integer> check(ArrayList<Integer> left, ArrayList<Integer> right) {
        int add = 0;
        int l = 0;
        int r = 0;
        ArrayList<Integer> sorted = new ArrayList<>();
        while (l<left.size() || r<right.size()) { //isEmpty()
            if (l>=left.size()) {
                sorted.addAll(right.subList(r, right.size()));
                return sorted;
            }
            if (r>=right.size()) {
                sorted.addAll(left.subList(l, left.size()));
                output += add * (left.size() - l);
                return sorted;
            }
            if (left.get(l) <= right.get(r)) {
                output += add;
                sorted.add(left.get(l));
                l += 1;
            } else {
                add += 1;
                sorted.add(right.get(r));
                r += 1;
            }
        }
        return sorted;
    }

    private static ArrayList<Integer> sort(ArrayList<Integer> input, int left, int right) {
        if (right - left == 1) {
            ArrayList<Integer> sorted = new ArrayList<>();
            sorted.add(input.get(left));
            return sorted;
        }
        else {
            return check(sort(input, left, (left + right)/2), sort(input,(left + right)/2, right));
        }
    }
}