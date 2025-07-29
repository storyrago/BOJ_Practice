import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer>stack = new Stack<>();

        int []arr = new int[n];
        int []ans = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++) {arr[i] = Integer.parseInt(st.nextToken());}
        for(int i = 0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){ //스택이 비어있지 않고, arr배열에 스택의 top값자리에 있는 값이 현재 배열의 숫자보다 작으면 오큰수
                int num = stack.pop();
                ans[num] = arr[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            ans[stack.pop()] = -1;
        } //반복문이 끝나도 스택에 남아있는 인덱스는 -1임
        for(int i = 0;i<n;i++){
            bw.write(ans[i] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

