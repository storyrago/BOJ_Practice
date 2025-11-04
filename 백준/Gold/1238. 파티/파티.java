import java.util.*;
import java.io.*;
public class Main {
    static int v;
    static int e;
    static int point;
    static class Node{
        int index;
        int cost;
        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
    static int[] dijkstra(ArrayList<ArrayList<Node>> graph, int start){
        int[]dist =new int[v+1];
        for(int i = 0;i<=v;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1.cost,o2.cost));
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
        return dist;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        point = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Node>> Graph = new ArrayList<>(); //정방향 그래프로 가는 시간을 구하고,
        ArrayList<ArrayList<Node>> reverseGraph = new ArrayList<>(); //역방향 그래프를 통해서 오는 시간을 구할 수 있음
        for(int i = 0;i<=v;i++){
            Graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }
        for(int i = 0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            Graph.get(a).add(new Node(b,cost));
            reverseGraph.get(b).add(new Node(a,cost));
        }
        int maxCost = 0;
        int []eachStudentCost = dijkstra(Graph,point);
        int []reverseEachStudentCost = dijkstra(reverseGraph,point);
        for(int i = 1;i<=v;i++){
            int temp = eachStudentCost[i] + reverseEachStudentCost[i];
            if(maxCost < temp) maxCost = temp;
        }
        System.out.println(maxCost);
    }
}
