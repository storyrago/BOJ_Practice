import java.util.*;
import java.io.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        int n = Integer.parseInt(br.readLine());
        for(int i = 0;i <n;i++){
            int num = Integer.parseInt(br.readLine());
            for(int j = 4; j<= num;j++){
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }
            System.out.println(dp[num]);
        }

    }
}
/*
1 1 / 1
2 1+1 2/ 2
3 1+1+1 1+2 2+1 3/ 4
4 7
5 1+1+1+1+1 ,1+1+1+2 * 4, 1+1+3 * 3 ,1+2+2 * 3, 2+3 * 2 / 13
* */