import java.util.Arrays;

class Solution {
    public int solution(String s) {
        int[]cnt = new int[2];
        Arrays.fill(cnt,0);
        StringBuilder sb = new StringBuilder();
        char temp = ' ';
        int index = 0;
        int answer = 0;
        for(char c : s.toCharArray()){
            if(temp == ' ') temp = c;
            if(c == temp) {
                cnt[0]++;
            }
            else{
                cnt[1]++;
            }
            if(cnt[0] == cnt[1]) {
                answer++;
                temp = ' ';
                Arrays.fill(cnt,0);
            }
            else{
                if(index == s.length() - 1) {
                    answer++;
                    break;
                }
            }
            index++;
        }
        return answer;
    }
}