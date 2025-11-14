import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<int []>schedul = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            schedul.add(new int[]{start,end});
        }
        Collections.sort(schedul, (o1,o2)->{
            int compareInt = Integer.compare(o1[1],o2[1]);
            if(compareInt == 0){
                return Integer.compare(o1[0],o2[0]);
            }
            return compareInt;
        }); 
        // end 값을 기준으로 정렬, 둘의 값이 같다면 start 값을 기준으로 정렬
        // Integer.compare
        // 왼쪽값 < 오른쪽값 -1, 왼쪽값 == 오른쪽값 0, 왼쪽값 < 오른쪽값 1

        int cnt = 0;
        int prev = 0;
        for(int i = 0;i<schedul.size();i++){
            if(schedul.get(i)[0] >= prev){
                cnt++;
                prev = schedul.get(i)[1];
            }
        }
        System.out.println(cnt);
    }
}