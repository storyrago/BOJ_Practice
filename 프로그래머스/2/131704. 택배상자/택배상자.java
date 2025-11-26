import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        int curr = 1;
        int targetIndex = 0;

        while(targetIndex < order.length){
            int target = order[targetIndex];

            if(!st.isEmpty() && st.peek() == target){
                st.pop();
                answer++;
                targetIndex++;
            }
            else if(curr <= order.length){
                if(curr == target){
                    answer++;
                    targetIndex++;
                    curr++;
                }
                else{
                    st.push(curr);
                    curr++;
                }
            }
            else{
                break;
            }
        }
        return answer;
    }
}