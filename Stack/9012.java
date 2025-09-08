import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Character> stk = new Stack<>();
        for(int i = 0;i<n;i++){
            String str = br.readLine();
            stk.clear();
            for(char c: str.toCharArray()){
                if(!stk.isEmpty() && stk.peek() == '(' && c == ')'){
                    stk.pop();
                }
                else{
                    stk.push(c);
                }
            }
            if(stk.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}


