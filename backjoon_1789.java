import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long S = in.nextLong();
        long N = 1;
        while (S>=0){
            S -= N;
            N++;
        }
        System.out.println(N-2);
    }
}