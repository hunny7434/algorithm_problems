import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
//        int graph[][] = new int[N][N];
//        for(int i = 0; i < N; i++) {
//            String[] temp = bf.readLine().split(" ");
//            for(int j = 0; j < N; j++) {
//                graph[i][j] = Integer.parseInt(temp[j]);
//            }
//        }
        int[] input = new int[N*N];
        for(int i = 0; i < N; i++) {
            String[] temp = bf.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                input[i*N + j] = Integer.parseInt(temp[j]);
            }
        }
        Arrays.sort(input);
        System.out.println(input[N*N-N]);
    }
}