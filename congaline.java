import java.io.*;

class Vertex {
    String name;
    Vertex before;
    Vertex after;
    Vertex partner;

    Vertex(String name) {
        this.name = name;
    }

    Vertex next(String name, String partnerName) {
        Vertex next = new Vertex(name);
        Vertex partner = new Vertex(partnerName);
        this.after = next;
        next.before = this;
        next.after = partner;
        next.partner = partner;
        partner.before = next;
        partner.partner = next;
        return partner;
    }

    void slotAfter(Vertex other) {
        if (this == other) {
            return;
        }
        if (this.before != null) {
            this.before.after = this.after;
        }
        if (this.after != null) {
            this.after.before = this.before;
        }
        if (other.after != null) {
            other.after.before = this;
        }
        this.after = other.after;
        other.after = this;
        this.before = other;
    }
}

class congaline {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int Q = Integer.parseInt(input[1]);
        Vertex first = new Vertex(" ");
        Vertex last = first;
        Vertex current = first;
        while (N-->0) {
            input = br.readLine().split(" ");
            current = current.next(input[0], input[1]);
            last = current;
        }
        first = first.after;
        first.before = null;
        char[] instructions = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        current = first;
        for (char c : instructions) {

            if (c == 'F') {
                current = current.before;
            }
            else if (c == 'B') {
                current = current.after;
            }
            else if (c == 'R') {
                if (first == current) {
                    first = current.after;
                }
                if (current == last) {
                    current = first;
                }
                else {
                    Vertex temp = current.after;
                    current.slotAfter(last);
                    last = current;
                    current = temp;
                }
            }
            else if (c == 'C') {
                if (first == current) {
                    first = current.after;
                }
                Vertex mic = current;
                if (current == last) {
                    mic = first;
                }
                else {
                    mic = current.after;
                }
                current.slotAfter(current.partner);
                if (last == current.partner) {
                    last = current;
                }
                current = mic;
            }
            else if (c == 'P') {
                sb.append(current.partner.name).append("\n");
            }
        }
        sb.append("\n");
        current = first;
        while (current != last) {
            sb.append(current.name).append("\n");
            current = current.after;
        }
        sb.append(last.name).append("\n");
        pw.println(sb);
        br.close();
        pw.close();
    }
}