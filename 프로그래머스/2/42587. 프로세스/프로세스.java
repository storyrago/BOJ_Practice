import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Duo{
    int priority;
    int index;

    public Duo(int priority, int index) {
        this.priority = priority;
        this.index = index;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Duo> q = new LinkedList<>();
        PriorityQueue<Duo> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.priority, a.priority));
        for(int i = 0;i<priorities.length;i++){
            Duo insDuo = new Duo(priorities[i], i);
            q.add(insDuo); pq.add(insDuo);
        }
        while(!q.isEmpty()){
            if(q.peek().priority == pq.peek().priority){
                answer++;
                if(q.peek().index == location) break;
                q.poll();
                pq.poll();
            }
            else q.add(q.poll());
        }

        return answer;
    }
}