import java.util.*;
import java.io.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] chunk  = str.split("-");
        ArrayList<Integer>list = new ArrayList<>();
        for(String iter: chunk) {
            int sum = 0;
            String[] strnums = iter.split("\\+");
            for (String num : strnums) {
                sum += Integer.parseInt(num);
            }
            list.add(sum);
        }
        int ans = 0;
        for(int i = 0;i<list.size();i++){
            if(i == 0) ans = list.get(0);
            else{
                ans -= list.get(i);
            }
        }
        System.out.println(ans);
    }
}