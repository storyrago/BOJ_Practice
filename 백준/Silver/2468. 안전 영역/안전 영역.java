import java.util.*;
import java.io.*;
import java.io.IOException;

public class Main {
    static int N;
    public static void bfs(int[][]board, boolean[][]checked, int startY,int startX, int maxH){
        Queue<int[]>q = new LinkedList<>();
        q.add(new int[]{startY,startX});
        checked[startY][startX] = true;
        int[]dy = {-1,0,1,0};
        int[]dx = {0,1,0,-1};
        while(!q.isEmpty()){
            int[] temp = q.poll();
            int ty = temp[0];
            int tx = temp[1];
            for(int i = 0;i<4;i++){
                int ny = ty + dy[i];
                int nx = tx + dx[i];
                if(ny >= 0 && ny < N && nx >= 0 && nx < N && !checked[ny][nx] && board[ny][nx] >= maxH){
                    bfs(board,checked,ny,nx,maxH);
                }
            }
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int[][]board = new int[N][N];
        int maxH = 0;
        for(int i = 0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<N;j++){
                int num = Integer.parseInt(st.nextToken());
                maxH = Math.max(num, maxH);
                board[i][j] = num;
            }
        }
        int ans = 0;
        for(int i = 1;i<=maxH;i++){
            int cnt = 0;
            boolean[][]checked = new boolean[N][N];
            for(int j = 0;j<N;j++){
                for(int k = 0;k<N;k++){
                    if(!checked[j][k] && board[j][k] >= i){
                        cnt++;
                        bfs(board,checked,j,k,i);
                    }
                }
            }
            ans = Math.max(ans,cnt);
        }
        System.out.println(ans);
    }
}