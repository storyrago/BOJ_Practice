import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long x1 = Long.parseLong(st.nextToken());
        long y1 = Long.parseLong(st.nextToken());
        long x2 = Long.parseLong(st.nextToken());
        long y2 = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long a1 = Long.parseLong(st.nextToken());
        long b1 = Long.parseLong(st.nextToken());
        long a2 = Long.parseLong(st.nextToken());
        long b2 = Long.parseLong(st.nextToken());

        long dx = Math.min(x2, a2) - Math.max(x1, a1);
        long dy = Math.min(y2, b2) - Math.max(y1, b1);

        if (dx > 0 && dy > 0) {
            System.out.println("FACE");
        } else if ((dx == 0 && dy > 0) || (dx > 0 && dy == 0)) {
            System.out.println("LINE");
        } else if (dx == 0 && dy == 0) {
            System.out.println("POINT");
        } else {
            System.out.println("NULL");
        }
    }
}
