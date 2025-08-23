import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer,Integer>map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0;i<n;i++){
            int v = Integer.parseInt(br.readLine());
            for(int j = 0;j<v;j++){
                int num = Integer.parseInt(br.readLine());
                map.put(num,map.getOrDefault(num,0) + 1);
            }
            int max = 0;                //최대 빈도수
            int ans = Integer.MAX_VALUE;//최대 빈도수를 갖는 수

            for(Map.Entry<Integer,Integer> entry:map.entrySet()){ //map 순회돌기
                int key = entry.getKey();
                int value = entry.getValue();

                if(value > max){
                    max = value;
                    ans = key;
                }
                else if(value == max){
                    ans = Math.min(ans,key);
                }
            }

            System.out.println(ans);
            map.clear();
        }
    }
}
