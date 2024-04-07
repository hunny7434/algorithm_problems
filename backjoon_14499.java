import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void rollDown(int[] dice){
        int temp = dice[1];
        dice[1] = dice[5];
        dice[5] = dice[4];
        dice[4] = dice[0];
        dice[0] = temp;
    }
    public static void rollRight(int[] dice){
        int temp = dice[3];
        dice[3] = dice[5];
        dice[5] = dice[2];
        dice[2] = dice[0];
        dice[0] = temp;
    }
    public static void rollUp(int[] dice){
        int temp = dice[0];
        dice[0] = dice[4];
        dice[4] = dice[5];
        dice[5] = dice[1];
        dice[1] = temp;
    }
    public static void rollLeft(int[] dice){
        int temp = dice[0];
        dice[0] = dice[2];
        dice[2] = dice[5];
        dice[5] = dice[3];
        dice[3] = temp;
    }
    public static void printDice(int[] dice){
        for(int i:dice){
            System.out.print(i);
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] row = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N  = row[0];
        int M  = row[1];
        int x  = row[2];
        int y  = row[3];
        int k  = row[4];

        int[][] graph = new int[N][M];
        for(int i=0;i<N;i++){
            row = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0;j<M;j++){
                graph[i][j] = row[j];
            }
        }

        int[] orders = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] dice = new int[6];

        for(int order:orders){
            if (order == 4){
                if (x < N-1){
                    x += 1;
                    rollDown(dice);
                    if (graph[x][y] == 0){
                        graph[x][y] = dice[5];
                    } else {
                        dice[5] = graph[x][y];
                        graph[x][y] = 0;
                    }
                    System.out.println(dice[0]);
                }
            } else if (order == 1) {
                if (y < M-1){
                    y += 1;
                    rollRight(dice);
                    if (graph[x][y] == 0){
                        graph[x][y] = dice[5];
                    } else {
                        dice[5] = graph[x][y];
                        graph[x][y] = 0;
                    }
                    System.out.println(dice[0]);
                }
            } else if (order == 3) {
                if (x > 0){
                    x -= 1;
                    rollUp(dice);
                    if (graph[x][y] == 0){
                        graph[x][y] = dice[5];
                    } else {
                        dice[5] = graph[x][y];
                        graph[x][y] = 0;
                    }
                    System.out.println(dice[0]);
                }
            } else if (order == 2) {
                if (y > 0){
                    y -= 1;
                    rollLeft(dice);
                    if (graph[x][y] == 0){
                        graph[x][y] = dice[5];
                    } else {
                        dice[5] = graph[x][y];
                        graph[x][y] = 0;
                    }
                    System.out.println(dice[0]);
                }
            }
            //printDice(dice);
        }
    }
}