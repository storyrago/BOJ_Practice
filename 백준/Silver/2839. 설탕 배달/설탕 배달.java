import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        boolean isDivided = false;
        while(n>=0){
            if(n % 5 == 0){
                answer += n /5;
                isDivided = true;
                break;
            }
            n -= 3;
            answer++;
        }
        System.out.println(isDivided?answer:-1);
    }
}