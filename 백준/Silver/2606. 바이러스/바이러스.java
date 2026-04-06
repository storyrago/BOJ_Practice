import java.util.*;
import java.io.*;
import java.io.IOException;

public class Main {
    static int cnt;
    static void bfs(ArrayList<ArrayList<Integer>>list, boolean[]checked, int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        checked[start] = true;
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int i = 0;i < list.get(temp).size();i++){
                int next = list.get(temp).get(i);
                if(!checked[next]){
                    cnt++;
                    q.add(next);
                    checked[next] = true;
                }
            }
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int com = Integer.parseInt(br.readLine());
        int pair = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        boolean[]checked = new boolean[com+1];
        for(int i = 0; i<= com; i++){
            list.add(new ArrayList<>());
        }
        cnt = 0;
        for(int i = 0; i<pair;i++){
            st = new StringTokenizer(br.readLine());
            int com1 = Integer.parseInt(st.nextToken());
            int com2 = Integer.parseInt(st.nextToken());
            list.get(com1).add(com2);
            list.get(com2).add(com1);
        }
        bfs(list, checked,1);
        System.out.println(cnt);
    }
}