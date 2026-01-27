import java.util.*;
class Solution {
    public int solution(int[] nums) {
        HashMap<Integer,Integer>map = new HashMap<>();
        int answer = 0;
        for(int i: nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        answer = map.size() > nums.length/2 ? nums.length/2 : map.size();
        return answer;
    }
}