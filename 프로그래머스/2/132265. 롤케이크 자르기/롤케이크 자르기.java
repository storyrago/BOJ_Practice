import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = -1;
        HashMap<Integer,Integer> m1 = new HashMap<>();
        HashMap<Integer,Integer> m2 = new HashMap<>();
        for(int i: topping){
            m2.put(i,m2.getOrDefault(i,0) + 1);
        }
        for(int i = 0;i<topping.length;i++){
            int t = topping[i];
            m1.put(t,m1.getOrDefault(t,0) + 1);
            m2.put(t,m2.get(t)-1);
            if(m2.get(t) == 0) m2.remove(t);
            if(m1.size() == m2.size()) answer++;
        }
        return answer == -1 ? 0 : answer+1;
    }
}