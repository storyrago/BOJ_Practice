import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for(int i:scoville){
            pq.add(i);
        }
        int addSco = 0;
        while(true){
            int firstSco = pq.poll();
            if(firstSco >= K) {
                return answer;
            }
            if(pq.isEmpty()) break;
            int secondSco = pq.poll();
            answer++;
            addSco = firstSco + secondSco * 2;
            pq.add(addSco);
        }
        return -1;
    }
}