import java.util.*;
import java.lang.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer>map = new HashMap<>();
        for(String s: participant){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        for(String s: completion){
            map.put(s,map.get(s)-1);
        }
        HashSet<String> set = new HashSet<>(map.keySet());
        for(String s: set){
            if(map.get(s) >= 1) answer = s;
        }
        return answer;
    }
}