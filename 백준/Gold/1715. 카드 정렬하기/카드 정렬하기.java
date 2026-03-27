import java.util.*;
import java.io.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0;i<n;i++){
            int num = Integer.parseInt(br.readLine());
            pq.add(num);
        }
        int ans = 0;
        while(pq.size() >= 2){
            int prefix = pq.poll() + pq.poll();
            ans += prefix;
            pq.add(prefix);
        }
        System.out.println(ans);
    }
}