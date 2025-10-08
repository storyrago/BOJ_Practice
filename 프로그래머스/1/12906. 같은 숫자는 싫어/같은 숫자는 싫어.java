import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer;
        Stack<Integer>st= new Stack<>();
        for(int i = 0;i<arr.length;i++){
            if(!st.isEmpty()){
                int temp = st.pop();
                if(temp == arr[i]) st.push(temp);
                else{
                    st.push(temp);
                    st.push(arr[i]);
                }
            }
            else{
                st.push(arr[i]);
            }
        }
        answer = new int[st.size()];
        int idx = 0;
        for(int i:st){
            answer[idx++] = i;
        }
        return answer;
    }
}