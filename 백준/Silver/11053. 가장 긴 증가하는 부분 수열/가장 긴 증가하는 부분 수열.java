import java.util.*;
import java.io.*;

import static java.lang.Math.max;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st= new StringTokenizer(br.readLine());
        int[]arr = new int[n+1];
        int[]length = new int[n+1];
        for(int i = 0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());

        int maxLen = 0;

        for(int i = 0;i<n;i++){
            length[i] = 1;
            for(int j = 0;j<i;j++){
                if(arr[i] > arr[j]) length[i] = max(length[i],length[j] + 1);
            }
            if(maxLen < length[i]) maxLen = length[i];
        }
        System.out.println(maxLen);
    }
}