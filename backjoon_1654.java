import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int K = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        int[] LANCables = new int[K];
        for(int i = 0; i < K; i++){
            LANCables[i] = Integer.parseInt(bf.readLine());
        }

        long left = 1;
        long right = Integer.MAX_VALUE;
        long count,mid;
        while (left <= right){
            mid = (left + right)/2;
            count = 0;
            for(int cable : LANCables) count += cable/mid;

            if(count<N){
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        System.out.println(right);
    }
}