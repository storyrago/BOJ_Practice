import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int a = -1;
        int b = -1;
        while(true){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if(a == 0 && b == 0) break;

            if(a>b){
                if(a%b == 0) {
                    System.out.println("multiple");
                    continue;
                }
            }
            else{
                if(b%a == 0){
                    System.out.println("factor");
                    continue;
                }
            }
            System.out.println("neither");
        }
    }
}