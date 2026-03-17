import java.util.*;
import java.io.*;
import java.io.IOException;

public class Main {
    static int L;
    static int C;
    static void dfs(int start, int depth, char[]list, char[]ans){
        if(depth == L){
            if(isgood(ans)){
                for(int i = 0;i<L;i++){
                    System.out.print(ans[i]);
                }
                System.out.println();
            }
            return;
        }
        for(int i = start;i< C;i++){
            ans[depth] = list[i];

            dfs(i+1,depth+1,list,ans);
        }
    }
    static boolean isgood(char[]ans){
        int moem = 0;
        int jaem = 0;
        for(char c: ans){
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                moem++;
            }
            else{
                jaem++;
            }
        }
        if(moem >= 1 && jaem >=2){
            return true;
        }
        return false;
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        char[]list = new char[C];
        char[]ans = new char[L];
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<C;i++) list[i] = st.nextToken().charAt(0);
        Arrays.sort(list);
        dfs(0,0,list,ans);
    }
}