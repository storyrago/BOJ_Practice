import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0;i<t;i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int []arra = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int []arrb = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(arra);
            Arrays.sort(arrb);
            int cnt = 0;
            for(int j = 0;j<n;j++){
                int left = 0,right = m-1,temp=0;
                while(left<=right){
                    int mid = (right+left)/2;
                    if(arra[j] > arrb[mid]){ //arra[j]가 arrb[mid]보다 크면 그 아래값은 다 먹을 수 있음
                        left = mid + 1; 
                        temp = mid+1; //mid에 +1 한 이유는 인덱스값이기 때문
                    }
                    else right = mid-1;
                }
                cnt += temp;
            }
            System.out.println(cnt);
        }
    }
}

