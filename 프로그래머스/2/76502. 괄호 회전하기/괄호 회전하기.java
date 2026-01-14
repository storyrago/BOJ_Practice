import java.util.*;
class Solution {
    public void spin(Queue<Character> q){
        char c = q.poll();
        q.add(c);
    }
    public boolean check(Queue<Character> q){
        Stack<Character> st = new Stack<>();
        int size = q.size();
        for(int i = 0;i<size;i++){
            if(st.isEmpty()){
                st.push(q.poll());
            }
            else{
                char temp = q.poll();
                if(st.peek() == '('){
                    if(temp == ')') st.pop();
                    else st.push(temp);
                }
                else if(st.peek() == '{'){
                    if(temp == '}') st.pop();
                    else st.push(temp);
                }
                else if(st.peek() == '['){
                    if(temp == ']') st.pop();
                    else st.push(temp);
                }
                else{
                    st.push(temp);
                }
            }
        }
        if(st.isEmpty()) return true;
        return false;
    }
    public int solution(String s) {
        int answer = -1;
        Queue<Character> q = new LinkedList<>();
        for(char c : s.toCharArray()){
            q.add(c);
        }
        //여기까진 잘됨
        for(int i = 0;i<s.length();i++){
            Queue<Character> q2 = new LinkedList<>(q);
            if(check(q2)) answer++;
            spin(q);
        }
        return answer+1;
    }
}