import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int M;
    static List<Integer>[] G;
    static int[] indegree;

    static void topological_sort(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i =1;i<N+1;i++){
            if(indegree[i] == 0) pq.offer(i);
        }
        while(!pq.isEmpty()){
            int x = pq.poll();
            System.out.print(x + " ");
            for(int y:G[x]){
                indegree[y]--;
                if(indegree[y] == 0) pq.offer(y);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = new List[N+1];
        indegree = new int[N+1];
        for(int i = 1;i<N+1;i++){
            G[i] = new ArrayList<>();
        }
        for(int i = 0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            G[from].add(to);
            indegree[to]++;
        }
        topological_sort();

    }

}
