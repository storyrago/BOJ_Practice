import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[]foods = new int[n+1];
        for(int i = 1;i<=n;i++){
            foods[i] = Integer.parseInt(br.readLine());
        }
        int m = Integer.parseInt(br.readLine());
        int ans = 0;
        for(int i = 0;i<m;i++){
            ans += foods[Integer.parseInt(br.readLine())];
        }
        System.out.println(ans);
    }
}