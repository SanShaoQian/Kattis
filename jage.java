import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;


class tag {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        HashSet<String> cheaters = new HashSet<>();
        HashSet<String> taggers = new HashSet<>();
        taggers.add(br.readLine().split(" ")[0]);
        while (M-->0) {
            String[] line = br.readLine().split(" ");
            String tagger = line[0];
            String tagged = line[2];
            if (!taggers.contains(tagger)) {
                cheaters.add(tagger);
            } else {
                taggers.remove(tagger);
            }
            taggers.add(tagged);
        }
        String[] output = new String[cheaters.size()];
        cheaters.toArray(output);
        Arrays.sort(output);
        pw.println(output.length);
        pw.println(Arrays.stream(output).collect(Collectors.joining(" ")));
        br.close();
        pw.close();
    }
}