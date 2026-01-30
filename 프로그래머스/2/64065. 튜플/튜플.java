import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List solution(String s) {
        HashMap<Integer,Integer> map = new HashMap<>();
        s = s.replace("{","");
        s = s.replace("}","");
        String[] numsChar = s.split(",");
        for(String str: numsChar){
            int num = Integer.parseInt(str);
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        List<Map.Entry<Integer,Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((o1,o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        List<Integer> answer = new ArrayList<>();
        for(Map.Entry<Integer,Integer> i : entryList){
            answer.add(i.getKey());
        }
        return answer;
    }
}