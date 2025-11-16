import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int S;
    static int CNT;
    static void dfs(int[]arr,int start,int sum){
        if(start == N){
            if(sum == S) CNT++;
            return;
        }
        dfs(arr,start+1,sum+arr[start]);
        dfs(arr,start+1,sum);
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        int[]arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(arr,0,0);

        if(S==0) CNT--;
        System.out.println(CNT);
    }
}