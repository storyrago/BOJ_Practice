import java.util.*;
import java.io.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> sta = new Stack<>();
        int index = 1;
        for(int i = 0;i<n;i++){
            int num = Integer.parseInt(br.readLine());
            while(index <= num){
                sta.add(index);
                sb.append("+\n");
                index++;
            }
            if(sta.peek() == num){
                sta.pop();
                sb.append("-\n");
            }
            else{
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb.toString());
    }
}