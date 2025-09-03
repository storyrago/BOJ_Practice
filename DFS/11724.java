import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int CNT;
    public static void DFS(int start,ArrayList<Integer>[] list,boolean[] visited){
        if(visited[start]) return;
        visited[start] = true;
        for(int i = 0;i<list[start].size();i++){
            int temp = list[start].get(i);
            DFS(temp,list,visited);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] list = new ArrayList[N+1];
        for(int i = 1;i<=N;i++) list[i] = new ArrayList<>();
        for(int i = 0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            list[num1].add(num2);
            list[num2].add(num1);
        }
        boolean[] visited = new boolean[N+1];
        for(int i = 1;i<=N;i++){
            if(!visited[i]){
                DFS(i,list,visited);
                CNT++;
            }
        }
        System.out.println(CNT);
    }
}
