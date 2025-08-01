import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int rightsum = 0;
        int []x = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++){
            x[i] = Integer.parseInt(st.nextToken());
            rightsum += x[i];
        }

        long ans = 0;
        for(int i = 0;i<n-1;i++){
            rightsum -= x[i];
            ans += x[i] * rightsum;
        }
        System.out.println(ans);
    }
}
// 5 [1][2] + [1][3] + [1][4] + [1][5]  [0](1+2+3+4)
//            [2][3] + [2][4] + [2][5]  [1](2+3+4)
//                     [3][4] + [3][5]  [2](3+4)
//                              [4][5]  [3](4)
