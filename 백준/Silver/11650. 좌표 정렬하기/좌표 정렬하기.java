import java.util.*;
import java.io.*;
import java.io.IOException;

public class Main {
    static class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<Point> list = new ArrayList<>();
        for(int i = 0;i < n;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Point(a,b));
        }
        Collections.sort(list,(o1,o2)->{
            if(o1.x == o2.x) return Integer.compare(o1.y,o2.y);
            else return Integer.compare(o1.x,o2.x);
        });

        for(int i = 0;i<n;i++){
            System.out.print(list.get(i).x);
            System.out.print(" ");
            System.out.println(list.get(i).y);
        }
    }
}