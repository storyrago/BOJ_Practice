import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String>cache = new ArrayList<>();
        for(String str: cities){
            str = str.toUpperCase();
            if(cache.contains(str)){ //hit
                cache.remove(str);
                cache.add(str);
                answer+=1;
                continue;
            }
            cache.add(str);
            if(cache.size() > cacheSize) {
                cache.remove(0);
            }
            answer+=5;
        }
        return answer;
    }
}
//LRU