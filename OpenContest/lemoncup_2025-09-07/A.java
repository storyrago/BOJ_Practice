import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashMap<Integer,Integer>map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++){
            int num = Integer.parseInt(st.nextToken());
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        if(map.size() == 2){
            if(map.get(2) > map.get(1)){
                System.out.println("No");
            }
            else{
                if((map.get(1) - map.get(2))%3 == 0 ){
                    System.out.println("Yes");
                }
                else{
                    System.out.println("No");
                }
            }
        }
        else{
            if(map.get(1) != null && map.get(1) % 3 == 0){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        }
    }
}
