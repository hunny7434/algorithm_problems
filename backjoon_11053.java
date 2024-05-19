import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] nums = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> dp = new ArrayList<>();
        dp.add(nums[0]);
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            if(dp.get(dp.size() - 1) < num) dp.add(num);
            else{
                int index = Collections.binarySearch(dp,num);
                if (index < 0) index = -index - 1;
                dp.set(index,num);
            }
        }
        System.out.println(dp.size());
    }
}