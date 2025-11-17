import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[]podo = new int[n+1];
        int[]dp = new int[n+1];

        for(int i = 0;i<n;i++){
            podo[i+1] = Integer.parseInt(br.readLine());
        }
        if(n >= 2){
            dp[1] = podo[1]; dp[2] = podo[1] + podo[2];
        }
        else{
            dp[1] = podo[1];
        }

        for(int i = 3;i<=n;i++){
            dp[i] = Math.max(dp[i-1],Math.max(dp[i-2] + podo[i], dp[i-3]+podo[i-1] + podo[i]));
        }
        System.out.println(dp[n]);
    }
}