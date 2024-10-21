import java.util.ArrayList;
import java.util.Scanner;

class kattis {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> pieces = new ArrayList<>();
        ArrayList<Integer> done = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            done.add(i);
        }
        while(input.hasNext()){
            pieces.add(input.nextInt());
        }
        String output = "";
        while (!pieces.equals(done)){
            for(int i = 0; i < pieces.size() - 1; i++) {
                if (pieces.get(i) > pieces.get(i + 1)) {
                    int o = pieces.get(i);
                    pieces.set(i, pieces.get(i + 1));
                    pieces.set(i + 1, o);
                    for (int j = 0; j < pieces.size(); j++) {
                        output += pieces.get(j);
                        if (j != pieces.size() - 1) {
                            output += " ";
                        }
                    }
                    output += "\n";
                }
            }
        }
        System.out.println(output);
    }
}