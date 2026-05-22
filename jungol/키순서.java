import java.util.*;
import java.io.*;

public class Main {
    static int cnt;

    static void bfs(ArrayList<ArrayList<Integer>> list, boolean[] checked, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        checked[start] = true;
        
        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int i = 0; i < list.get(temp).size(); i++) {
                int next = list.get(temp).get(i);
                if (!checked[next]) {
                    cnt++;
                    q.add(next);
                    checked[next] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> tallerList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> shorterList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            tallerList.add(new ArrayList<>());
            shorterList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            tallerList.get(a).add(b);  
            shorterList.get(b).add(a); 
        }

        int result = 0;
        
        for (int i = 1; i <= n; i++) {
            cnt = 0;    
            bfs(tallerList, new boolean[n + 1], i);
            bfs(shorterList, new boolean[n + 1], i);
            if (cnt == n - 1) {
                result++;
            }
        }

        System.out.println(result);
    }
}
