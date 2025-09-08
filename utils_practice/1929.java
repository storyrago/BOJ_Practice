import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[] era = new boolean[N+1];
        Arrays.fill(era,true);
        era[1] = false;
        for(int i = 2;i*i<= N;i++){
            for(int j = i*i;j<=N;j+=i){
                era[j] = false;
            }
        }
        for(int i = M;i<=N;i++){
            if(era[i]) System.out.println(i);
        }
    }
}


