import java.util.*;
import java.io.*;
public class Main{
    static int n;
    static int m;
    static int r;
    static class Node{
        int index;
        int cost;
        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
    static int dijkstra(ArrayList<ArrayList<Node>>graph, int[]item,int start){
        int[]dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)-> Integer.compare(o1.cost,o2.cost));
        dist[start] = 0;
        pq.offer(new Node(start,0));
        while(!pq.isEmpty()){
            Node currNode = pq.poll();
            if(dist[currNode.index] < currNode.cost) continue;
            for(int i = 0;i<graph.get(currNode.index).size();i++){
                Node nextNode = graph.get(currNode.index).get(i);
                if(dist[nextNode.index] > dist[currNode.index] + nextNode.cost){
                    dist[nextNode.index] = dist[currNode.index] + nextNode.cost;
                    pq.offer(new Node(nextNode.index,dist[nextNode.index]));
                }
            }
        }
        int Items = 0;
        for(int i = 1;i<=n;i++){
            if(m >= dist[i]) Items += item[i];
        }
        return Items;
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        int[]item = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1;i<=n;i++){
            item[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for(int i = 0;i<=n;i++) graph.add(new ArrayList<>());

        for(int i = 0;i<r;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b,cost));
            graph.get(b).add(new Node(a,cost));
        }
        boolean[]visited = new boolean[n+1];
        int maxItem = 0;
        for(int i = 1;i<=n;i++){
            int eachItem = dijkstra(graph,item,i);
            if(maxItem < eachItem) maxItem = eachItem;
        }
        System.out.println(maxItem);
    }
}