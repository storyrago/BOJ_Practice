import java.io.*;
import java.util.*;
public class Main {
    static int simisPalin(String str){
        if(isPalin(str,0,str.length()-1)){
            return 0;
        }
        int left = 0;
        int right = str.length()-1;

        while(left<right){
            if(str.charAt(left)!=str.charAt(right)){
                if(isPalin(str,left+1,right)){
                    return 1;
                }
                if(isPalin(str,left,right-1)){
                    return 1;
                }
                return 2;
            }
            left++;
            right--;
        }
        return 0;
    }
    static boolean isPalin(String str,int left,int right){
        while(left<right){
            if(str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0;i<n;i++){
            String str = br.readLine();
            int result = simisPalin(str);
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

