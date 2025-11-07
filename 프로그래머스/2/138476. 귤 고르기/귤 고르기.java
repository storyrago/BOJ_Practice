import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    static class Gyul{
        int index;
        int size;
        public Gyul(int index, int size) {
            this.index = index;
            this.size = size;
        }
    }
    public int solution(int k, int[] tangerine) {
        ArrayList<Gyul> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i : tangerine) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for (Integer i : map.keySet()) {
            list.add(new Gyul(i,map.get(i)));
        }
        Collections.sort(list, (o1,o2)->Integer.compare(o2.size,o1.size));
        int gyulCnt = 0;
        int temp = 0;
        for (Gyul gyul : list) {
            if(temp >= k) break;
            temp += gyul.size;
            gyulCnt++;
        }
        return gyulCnt;
    }
}