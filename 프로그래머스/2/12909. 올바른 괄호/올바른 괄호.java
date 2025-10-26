import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int index = 0;
        Stack<Character>st = new Stack<>();
        for(char c: s.toCharArray()){
            if(st.size() == 0){
                st.push(c);
            }
            else{
                char temp = st.pop();
                if(temp == ')'){
                    st.push(temp);
                    st.push(c);
                }
                else{
                    if(c == '('){
                        st.push(temp);
                        st.push(c);
                    }
                }
            }
        }
        if(st.size() != 0) answer = false;
        return answer;
    }
}