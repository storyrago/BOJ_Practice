import java.util.*;
import java.io.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String a = br.readLine();
        String b = br.readLine();
        int alen = a.length();
        int blen = b.length();
        a = ' ' + a;
        b = ' ' + b;
        int[][]dp = new int[alen+1][blen+1];
        for(int i = 1;i<=alen;i++){
            for(int j = 1; j <=blen;j++){
                if(a.charAt(i) == b.charAt(j)) dp[i][j] = dp[i-1][j-1] + 1;
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[alen][blen]);
    }
}