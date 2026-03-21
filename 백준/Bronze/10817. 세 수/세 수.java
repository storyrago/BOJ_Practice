import java.util.*;
import java.io.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[]num = new int[3];
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<3;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        System.out.println(num[1]);
    }
}