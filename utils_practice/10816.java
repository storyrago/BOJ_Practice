import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        HashMap<Integer,Integer>map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++){
            int x = Integer.parseInt(st.nextToken());
            map.put(x,map.getOrDefault(x,0) + 1);
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<m;i++){
            bw.write(map.getOrDefault(Integer.parseInt(st.nextToken()),0) + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
