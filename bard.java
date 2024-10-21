//https://open.kattis.com/problems/bard

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

class bard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        int currentSong = 0;
        HashSet<Integer>[] set = new HashSet[N + 1];
        for (int i = 0; i <= N; i++) {
            set[i] = new HashSet<>();
        }
        while (E-- > 0) {
            String[] s = br.readLine().split(" ");
            int K = Integer.parseInt(s[0]);
            boolean newSong = Arrays.stream(s).anyMatch(x -> x.equals("1"));
            if (newSong) {
                currentSong++;
            }
            HashSet<Integer> allSongs = new HashSet<>();
            for (int i = 1; i <= K; i++) {
                int villager = Integer.parseInt(s[i]);
                if (villager == 1) {
                    continue;
                }
                if (newSong) {
                    set[villager].add(currentSong);
                } else {
                    allSongs.addAll(set[villager]);
                }
            }
            if (!newSong) {
                for (int i = 1; i <= K; i++) {
                    set[Integer.parseInt(s[i])] = (HashSet<Integer>) allSongs.clone();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("1").append("\n");
        for (int i = 2; i <= N; i++) {
            if (set[i].size() == currentSong) {
                sb.append(i).append("\n");
            }
        }
        pw.println(sb);
        pw.close();
        br.close();
    }
}
