import java.io.*;
import java.util.*;

public class Main {
    public static int BFS(int start,ArrayList<Integer>[]list,boolean[]visited){
        if(visited[start]) return 0;
        int cnt = 0;
        Queue <Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int iter:list[temp]){
                if(!visited[iter]){
                    cnt++;
                    q.add(iter);
                    visited[iter] = true;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] list = new ArrayList[n+1];
        for(int i = 1;i<=n;i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            list[num1].add(num2);
            list[num2].add(num1);
        }
        boolean[] visited = new boolean[n+1];
        System.out.println(BFS(1,list,visited));
    }
}

