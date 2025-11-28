import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String,Integer> map = new HashMap<>();
        for(String str : phone_book){
            map.put(str,1);
        }
        for(String str : phone_book){
            for(int i = 0;i<str.length();i++){
                String temp = str.substring(0,i);
                if(map.containsKey(temp)){
                    answer = false;
                    return answer;
                }
            }
        }
        return answer;
    }
}