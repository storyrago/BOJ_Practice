import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i = 1;i<len;i++){
            while(!st.isEmpty() && prices[st.peek()] > prices[i]){
                int index = st.pop();
                answer[index] = i - index;  
            }
            st.push(i);
        }
        
        while(!st.isEmpty()){
            int remainIndex = st.pop();
            answer[remainIndex] = len - 1 - remainIndex;
        }
        return answer;
    }
}