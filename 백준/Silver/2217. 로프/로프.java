import java.util.*;
import java.io.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>list = new ArrayList<>();
        for(int i = 0;i<n;i++) list.add(Integer.parseInt(br.readLine()));
        Collections.sort(list,Collections.reverseOrder());
        int ans = 0;
        for(int i = 0;i<n;i++){
            ans = Math.max(ans,list.get(i) * (i+1));
        }
        System.out.println(ans);
    }
}