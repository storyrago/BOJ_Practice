import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
public class Main {
    static class Node{
        int index;
        int cost;
        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1.cost,o2.cost));
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        for(int i = 0;i<=v;i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b,cost));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int []dist = new int[v+1];
        for(int i = 0;i<=v;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;
        pq.offer(new Node(start,0));
        while(!pq.isEmpty()){
            Node currNode = pq.poll();
            if(dist[currNode.index] < currNode.cost) continue;
            for(int i = 0;i<graph.get(currNode.index).size();i++){
                Node nextNode = graph.get(currNode.index).get(i);
                if(dist[nextNode.index] > currNode.cost + nextNode.cost){
                    dist[nextNode.index] = currNode.cost + nextNode.cost;
                    pq.offer(new Node(nextNode.index,dist[nextNode.index]));
                }
            }
        }
        System.out.println(dist[end]);
    }
}
