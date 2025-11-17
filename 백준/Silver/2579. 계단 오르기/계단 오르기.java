import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[]stairs = new int[n+1];
        int[][]dp = new int[n+1][2];
        for(int i = 0;i<n;i++){
            stairs[i+1] = Integer.parseInt(br.readLine());
        }
        //디피 수행 전 초기 작업
        if(n <= 1){
            dp[1][0] = stairs[1]; dp[1][1] = 0;
        }
        else{
            dp[1][0] = stairs[1]; dp[1][1] = 0; dp[2][0] = stairs[2];dp[2][1] =stairs[1] + stairs[2];
        }
        for(int i = 3;i<=n;i++){
            dp[i][1] = dp[i-1][0] + stairs[i];
            dp[i][0] = Math.max(dp[i-2][0],dp[i-2][1]) + stairs[i];
        }
        System.out.println(Math.max(dp[n][0],dp[n][1]));
    }
}