import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n  = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        double min = Math.min(n,m);
        min /= 2;
        min *= 100;
        System.out.println((int)min);
    }
}