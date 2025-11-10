import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            int num = Integer.parseInt(br.readLine());
            list.add(num);
        }
        Collections.sort(list);
        for(int i : list){
            bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}