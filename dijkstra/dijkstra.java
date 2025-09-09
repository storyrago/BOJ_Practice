import java.io.*;
import java.util.*;

class node implements Comparable<node>{
    int index, cost;
    public node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }


    @Override
    public int compareTo(node o){
        return Integer.compare(this.cost,o.cost);
    }
}

public class Main {
    static ArrayList<node>[]graph;
    public static void dijkstra(int n, int start){
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        int INF = Integer.MAX_VALUE;

        Arrays.fill(dist,INF);
        dist[start] = 0;

        PriorityQueue<node> pq = new PriorityQueue<>();
        pq.offer(new node(start, 0));

        while(!pq.isEmpty()){
            int nowVertex = pq.poll().index;

            if(visited[nowVertex]) continue;
            visited[nowVertex] = true;

            for(node next : graph[nowVertex]){
                if(dist[next.index] > dist[nowVertex] + next.cost){
                    dist[next.index] = dist[nowVertex] + next.cost;

                    pq.offer(new node(next.index,dist[next.index]));
                }
            }
        }

        for(int i : dist){
            if(i==INF) System.out.println(0 + " ");
            else System.out.println((i + " "));
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());


        graph = new ArrayList[n+1];
        for(int i = 0;i<=n;i++) graph[i] = new ArrayList<>();

        StringTokenizer st;
        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[v].add(new node(w,cost));
        }
        int start = Integer.parseInt(br.readLine());

        dijkstra(n,start);
    }
}



