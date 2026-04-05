import java.util.*;
import java.io.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[]nums = new int[n+1];
        for(int i = 1;i<=n;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int[]dp = new int[n+1];
        int maxlen = 0;
        for(int i = 1;i<=n;i++){
            dp[i] = 1;
            for(int j = 1;j<i;j++){
                if(nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            maxlen = Math.max(maxlen, dp[i]);
        }
        System.out.println(maxlen);
    }
}