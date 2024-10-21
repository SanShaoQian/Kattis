import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.stream.Collectors;


class inflation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Long> output = new ArrayList<>();
        output.add(0L);
        Hashtable<Long,Long> dishes = new Hashtable<>();
        String[] input = br.readLine().split(" ");
        for (String s: input) {
            long i = Integer.parseInt(s);
            output.set(0, output.getFirst() + i);
            if (dishes.containsKey(i)) {
                dishes.put(i,dishes.get(i)+1);
            }
            else {
                dishes.put(i,1L);
            }
        }
        int Q = Integer.parseInt(br.readLine());
        long inflation = 0L;
        while (Q-- > 0) {
            String[] line = br.readLine().split(" ");
            if (line[0].equals("INFLATION")) {
                int inf = Integer.parseInt(line[1]);
                inflation += inf;
                output.add(output.getLast() + (long) inf *N);
            }
            else if (line[0].equals("SET")) {
                long x = Integer.parseInt(line[1]) - inflation;
                long y = Integer.parseInt(line[2]) - inflation;
                if (x == y) {
                    output.add(output.getLast());
                    continue;
                }
                if (dishes.containsKey(x)) {
                    output.add(output.getLast() + (y - x) * dishes.get(x));
                    if (dishes.containsKey(y)) {
                        dishes.put(y,dishes.get(y)+dishes.get(x));
                    } else {
                        dishes.put(y,dishes.get(x));
                    }
                    dishes.remove(x);
                } else {
                    output.add(output.getLast());
                }
            }
        }
        output.removeFirst();
        pw.println(output.stream().map(Object::toString).collect(Collectors.joining("\n")));
        br.close();
        pw.close();
    }
}