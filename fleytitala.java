import java.util.Scanner;
import java.math.*;
class kattis{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        float d = input.nextFloat();
        input.nextLine();
        float k = input.nextFloat();
        System.out.println(2*d*(1 - Math.pow(0.5,k+1)));
    }
}