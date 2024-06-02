import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static int[] parent;
    // union 연산
    public static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) return false;

        if(x <= y) parent[y] = x;
        else parent[x] = y;
        return true;
    }

    // find 연산
    public static int find(int x) {
        if(parent[x] == x) return x;
        return find(parent[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());

        parent = new int[n+1];
        for (int i = 1; i < n+1; i++) parent[i] = i;

        for(int i = 1; i < n+1; i++) {
            String[] input = bf.readLine().split(" ");
            for (int j = i; j < n; j++) {
                if (Integer.parseInt(input[j]) == 1) {
                    union(i, j+1);
                }
            }
        }

        String[] input = bf.readLine().split(" ");
        int parent = find(Integer.parseInt(input[0]));
        for(int i = 1; i < m; i++) {
            if (find(Integer.parseInt(input[i])) != parent) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

}