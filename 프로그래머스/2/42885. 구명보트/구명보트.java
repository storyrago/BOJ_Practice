import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int bottom = 0;
        int top = people.length - 1;
        int boat = 0;
        while(bottom <= top){
            int sum = people[bottom] + people[top];
            if(sum > limit){
                top--;
                boat++;
            }
            else{
                bottom++;
                top--;
                boat++;
            }
        }

        return boat;
    }
}