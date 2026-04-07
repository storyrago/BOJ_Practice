import java.util.*;
import java.io.*;
import java.io.IOException;

public class Main {
    static int findKing(int[]arr, int start){
        if(arr[start] == start) return start;
        return arr[start] = findKing(arr, arr[start]);
    }
    static void union(int[]arr, int a, int b){
        int x = findKing(arr, a);
        int y = findKing(arr, b);
        if(x != y) arr[x] = y;
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[]arr = new int[n+1];
        for(int i = 1;i<=n;i++) arr[i] = i;
        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            boolean isOne = Integer.parseInt(st.nextToken()) == 1;
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(isOne){
                if(findKing(arr, a) == findKing(arr, b)) System.out.println("YES");
                else System.out.println("NO");
            }
            else{
                union(arr, a, b);
            }
        }
    }
}