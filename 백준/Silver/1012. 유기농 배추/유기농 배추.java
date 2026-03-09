import java.util.*;
import java.io.*;
import java.io.IOException;

public class Main {
    static int M;
    static int N;
    static int K;
    public static void bfs(int[][]board,boolean[][]checked, int startY, int startX){
        int[]dy = {-1,0,1,0};
        int[]dx = {0,1,0,-1};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startY, startX});
        checked[startY][startX] = true;
        while(!q.isEmpty()){
            int[]temp = q.poll();
            int ty = temp[0];
            int tx = temp[1];
            for(int i = 0;i<4;i++){
                int ny = ty + dy[i];
                int nx = tx + dx[i];
                if(ny >= 0 && ny < N && nx >= 0 && nx < M && !checked[ny][nx] && board[ny][nx] != 0){
                    checked[ny][nx] = true;
                    bfs(board,checked,ny,nx);
                }
            }
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int i = 0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            int[][]board = new int[N][M];
            boolean[][]checked = new boolean[N][M];
            for(int j = 0;j<K;j++){
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                board[Y][X] = 1;
            }
            int cnt = 0;
            for(int j = 0;j<N;j++){
                for(int k = 0;k<M;k++){
                    if(!checked[j][k] && board[j][k] == 1){
                        cnt++;
                        bfs(board,checked,j,k);
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}