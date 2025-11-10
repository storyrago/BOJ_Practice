import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int [] ATM = new int[n];
        for(int i = 0;i<n;i++){
            ATM[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ATM);
        int answer = 0;
        for(int i = 1;i<n;i++){
            ATM[i] = ATM[i] + ATM[i-1];
            answer += ATM[i];
        }
        System.out.println(ATM[0] + answer);
    }
}
/*
* */