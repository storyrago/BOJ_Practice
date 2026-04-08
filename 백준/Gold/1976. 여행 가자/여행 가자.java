import java.util.*;
import java.io.*;
import java.io.IOException;

public class Main {
    static int findKing(int[]arr, int start){
        if(arr[start] == start) return start;
        return arr[start] = findKing(arr, arr[start]);
    }
    static void union(int[]arr, int a, int b){
        arr[a] = b;
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int cities = Integer.parseInt(br.readLine());
        int[]arr = new int[cities + 1];
        for(int i = 1; i<= cities;i++) arr[i] = i;

        int M = Integer.parseInt(br.readLine()); //얘 뭐임

        for(int i = 1;i<=cities;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1;j<=cities;j++){
                if(st.nextToken().equals("1")){
                    int x = findKing(arr, j);
                    int y = findKing(arr, i);
                    if(x!=y) union(arr, x, y);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int num = findKing(arr, Integer.parseInt(st.nextToken()));

        boolean isPossible = true;
        for(int i = 1 ;i < M;i++){
            int temp = findKing(arr, Integer.parseInt(st.nextToken()));
            if(num != temp) {
                isPossible = false;
                break;
            }
        }
        if(isPossible) System.out.println("YES");
        else System.out.println("NO");
    }
}