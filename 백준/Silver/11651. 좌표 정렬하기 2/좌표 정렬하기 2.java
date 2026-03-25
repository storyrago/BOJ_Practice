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
        int N = Integer.parseInt(br.readLine());
        ArrayList<Point> list = new ArrayList<>();
        for(int i = 0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            list.add(new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list,(o1,o2)->{
            if(o1.y == o2.y) return Integer.compare(o1.x,o2.x);
            else return Integer.compare(o1.y,o2.y);
        });
        for (Point point : list) {
            System.out.print(point.x + " " + point.y + '\n');
        }
    }
}