//https://open.kattis.com/problems/doctorkattis

import java.io.*;
import java.util.HashMap;
import java.util.PriorityQueue;

class doctorkattis {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Cat> cats = new HashMap<>();
        PriorityQueue<Cat> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        int time = 0;
        while (n-- > 0) {
            String[] s = br.readLine().split(" ");
            if (s[0].equals("0")) {
                String name = s[1];
                int infect = Integer.parseInt(s[2]);
                Cat meow = new Cat(name, infect, time);
                cats.put(name, meow);
                pq.add(meow);
                time++;
            }
            if (s[0].equals("1")) {
                String name = s[1];
                int infect = Integer.parseInt(s[2]);
                cats.get(name).infection += infect;
                if (cats.get(name).infection > 100) {
                    cats.get(name).infection = 100;
                }
            }
            if (s[0].equals("2")) {
                String name = s[1];
                Cat meow = cats.get(name);
                cats.remove(name);
                pq.remove(meow);
            }
            if (s[0].equals("3")) {
                if (pq.isEmpty()) {
                    sb.append("The clinic is empty");
                } else {
                    sb.append(pq.peek().name);
                }
                sb.append("\n");
            }
        }
        pw.println(sb);
        pw.close();
        br.close();
    }
}

class Cat implements Comparable<Cat> {
    String name;
    int infection;
    int time;

    Cat(String name, int infection, int time) {
        this.name = name;
        this.infection = infection;
        this.time = time;
    }

    @Override
    public int compareTo(Cat o) {
        int off = o.infection - this.infection;
        if (off == 0) {
            return this.time - o.time;
        }
        return off;
    }
}
