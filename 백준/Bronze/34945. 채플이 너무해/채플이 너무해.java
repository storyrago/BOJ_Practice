import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int a = Integer.parseInt(br.readLine());
        if(a+2 >= 8) {
            System.out.println("Success!");
            return;
        }
        System.out.println("Oh My God!");
    }
}