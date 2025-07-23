//각 범위 까지의누적합을 사용하여 
// m으로 나누었을 때 나머지가 같은 쌍들의 개수를 구해야하는 문제
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long cnt = 0;
        long []d = new long[m];
        long sum = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++){
            sum += Long.parseLong(st.nextToken());
            int r = (int)(sum % m); //sum 은 long 이므로 형변환필요
            if(r==0) cnt++;
            d[r]++;
        }
        for(int i = 0;i<m;i++){
            if(d[i]>1) cnt += d[i]*(d[i]-1)/2; 
        }
        System.out.println(cnt);
    }
}

