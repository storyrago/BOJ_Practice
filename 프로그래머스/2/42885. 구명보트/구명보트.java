import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int len = people.length;
        int minW = 0;
        int maxW = len-1;
        while(minW <= maxW){
            if(people[minW] + people[maxW] <= limit){
                answer++;
                minW++;
                maxW--;
            }
            else{
                answer++;
                maxW--;
            }
        }
        return answer;
    }
}