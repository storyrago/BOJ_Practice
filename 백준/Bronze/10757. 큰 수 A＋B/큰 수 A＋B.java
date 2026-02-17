import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        BigInteger bigIntegera = new BigInteger(st.nextToken());
        BigInteger bigIntegerb = new BigInteger(st.nextToken());

        System.out.println(bigIntegera.add(bigIntegerb));
    }
}