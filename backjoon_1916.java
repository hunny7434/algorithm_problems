import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n+1; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int[] nums = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(nums[0]).add(new int[]{nums[1], nums[2]});
        }
        int[] nums = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(dijkstra(graph,nums[0],nums[1]));
    }
    private static int dijkstra(List<List<int[]>> graph, int start, int end) {
        int size = graph.size();
        int[] dist = new int[size];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });

        boolean[] visited = new boolean[size];

        pq.add(new int[] {start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (visited[cur[0]]) continue;
            else visited[cur[0]] = true;
            for(int[] neighbor : graph.get(cur[0])) {
                if (cur[1] + neighbor[1] < dist[neighbor[0]]) {
                    dist[neighbor[0]] = cur[1] + neighbor[1];
                    pq.add(new int[] {neighbor[0], dist[neighbor[0]]});
                }
            }
        }
        return dist[end];
    }
}