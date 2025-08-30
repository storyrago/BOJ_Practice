import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int cnt;
    static int housecnt;
    public static int BFS(int startX,int startY,boolean[][]visited,ArrayList<ArrayList<Integer>> grid, int housecnt){
        cnt++;
        Queue <int []> q = new LinkedList<>();
        visited[startY][startX] = true;
        q.add(new int[]{startY,startX});
        int []dy = {-1,0,1,0};
        int []dx = {0,1,0,-1};
        while(!q.isEmpty()){
            int []temp = q.poll();
            int cy = temp[0];
            int cx = temp[1];
            for(int i =0;i<4;i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if(ny >= 0 && ny < N && nx >= 0 && nx < N && !visited[ny][nx]&&grid.get(ny).get(nx) == 1){
                    q.add(new int[]{ny,nx});
                    visited[ny][nx] = true;
                    housecnt++;
                }
            }
        }
        return housecnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> grid = new ArrayList<>();
        boolean[][]visited = new boolean[N][N];
        for(int i =0;i<N;i++){
            String str = br.readLine();
            ArrayList<Integer> line = new ArrayList<>();
            for(char c:str.toCharArray()){
                line.add(c-'0');
            }
            grid.add(line);
        }
        cnt = 0;

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0;i<N;i++){
            for(int j = 0;j<N;j++){
                if(!visited[i][j] && grid.get(i).get(j) == 1){
                    housecnt = 1;
                    ans.add(BFS(j,i,visited,grid,housecnt));
                }
            }
        }
        Collections.sort(ans);
        System.out.println(cnt);
        for(int i = 0;i<ans.size();i++){
            System.out.println(ans.get(i));
        }
    }
}
