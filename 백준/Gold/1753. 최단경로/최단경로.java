import java.util.*;
import java.io.*;
public class Main {
    static class Node{
        int index;
        int cost;
        Node(int index,int cost){
            this.index = index;
            this.cost =cost;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken()); int e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for(int i = 0; i<= v;i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b,cost));
        }
        int []dist = new int[v+1];
        for(int i = 0;i<=v;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1.cost,o2.cost));
        //(o1,o2) -> Integer.compare(o1.cost,o2.cost) => o1.cost < o2.cost 이면 음수반환, o1.cost == o2.cost 이면 0, o1.cost > o2.cost 이면 양수 반환
        // 우선순위 큐는 이 반환값이 음수거나 0이면 그대로 두고, 양수면 두 객체의 순서를 바꾼다. 따라서 cost값이 더 작은 객체가 더 높은 우선순위이다.
        pq.offer(new Node(start, 0));
        dist[start] = 0;
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
        for(int i = 1;i<=v;i++){
            if(dist[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            }
            else{
                System.out.println(dist[i]);
            }
        }
    }
}
