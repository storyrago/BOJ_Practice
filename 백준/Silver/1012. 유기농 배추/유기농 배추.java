import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {
    static int M;
    static int N;
    static int K;

    public static void bfs(int[][] graph,boolean[][]checked,int starty,int startx){
        Queue<int []> q = new LinkedList<>();
        checked[starty][startx] = true;
        q.add(new int[]{starty,startx});
        int[]dy = {-1,0,1,0};
        int[]dx = {0,1,0,-1};
        while(!q.isEmpty()){
            int[]temp = q.poll();
            int y = temp[0];
            int x = temp[1];
            for(int i = 0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny >= 0 && ny<N && nx >=0 && nx <M && !checked[ny][nx] && graph[ny][nx] == 1){
                    q.add(new int[]{ny,nx});
                    checked[ny][nx] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int i = 0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); //가로
            N = Integer.parseInt(st.nextToken()); //세로
            K = Integer.parseInt(st.nextToken()); //배추 개수
            int[][]graph = new int[N][M];
            boolean[][]checked = new boolean[N][M];
            for(int j = 0;j<K;j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[b][a] = 1;
            }
            int ans = 0;
            for(int j = 0;j<N;j++){
                for(int k = 0;k<M;k++){
                    if(!checked[j][k] && graph[j][k] == 1){
                        ans++;
                        bfs(graph,checked,j,k);
                    }
                }
            }
            System.out.println(ans);
        }

    }
}
/*

5
3 1 4 3 2
* */