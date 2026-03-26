import java.util.*;
import java.io.*;
import java.io.IOException;

public class Main {
    static class Period{
        int start;
        int end;
        public Period(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<Period> list =new ArrayList<>();
        for(int i = 0; i< n ;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Period(start, end));
        }
        Collections.sort(list,(o1,o2)->{
            if(o1.end == o2.end) return Integer.compare(o1.start,o2.start);
            else return Integer.compare(o1.end,o2.end);
        });
        int beforeEndtime = 0;
        int ans = 0;
        for (Period period : list) {
            if(beforeEndtime <= period.start){
                ans++;
                beforeEndtime = period.end;
            }
        }
        System.out.println(ans);
    }
}