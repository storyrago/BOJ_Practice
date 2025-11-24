import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] lanCable = new long[K];
        for(int i = 0;i<K;i++) lanCable[i] = Long.parseLong(br.readLine());
        Arrays.sort(lanCable);
        long btm = 1L;
        long top = lanCable[K-1];
        long maxLen = 0L;
        while(btm <= top){
            long midLen = (btm + top) / 2;
            long cnt = 0L;
            for(int i = 0;i<K;i++) cnt += lanCable[i] / midLen;
            if(cnt >= N) {
                maxLen = Math.max(maxLen, midLen);
                btm = midLen + 1;
            }
            else{
                top = midLen - 1;
            }
        }
        System.out.println(maxLen);
    }
}