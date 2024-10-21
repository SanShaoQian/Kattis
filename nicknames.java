import java.io.*;
import java.util.HashMap;

class nicknames {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(br.readLine());
        String[] names = new String[N];
        for (int i = 0; i < N; i++) {
            names[i] = br.readLine();
        }
        HashMap<Integer, HashMap<String, Integer>> nicknames = new HashMap<>();
        int B = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();
        while (B-- > 0) {
            String nickname = br.readLine();
            int size = nickname.length();
            if (!nicknames.containsKey(size)) {
                nicknames.put(size, new HashMap<>());
                for (String s : names) {
                    if (s.length() < size) {
                        continue;
                    }
                    String sub = s.substring(0,size);
                    if (!nicknames.get(size).containsKey(sub)) {
                        nicknames.get(size).put(sub, 0);
                    }
                    nicknames.get(size).put(sub, nicknames.get(size).get(sub) + 1);
                }
            }
            if (nicknames.get(size).containsKey(nickname)) {
                output.append(nicknames.get(size).get(nickname));
            } else {
                output.append('0');
            }
            output.append('\n');
        }
        pw.println(output.toString());
        pw.close();
        br.close();
    }
}