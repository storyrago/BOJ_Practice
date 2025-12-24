import java.util.*;

class Solution {
    public static int gcd(int a, int b){
        while(b!=0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public int solution(int[] arr) {
        int answer = 0;
        Stack<Integer>st = new Stack<>();
        for(int i : arr) st.push(i);
        while(st.size() >= 2){
            int x = st.pop();
            int y = st.pop();
            st.push(x*y/gcd(x,y));
        }
        answer = st.pop();
        return answer;
    }
}