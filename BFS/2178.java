import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    public static int BFS(int startY, int startX,ArrayList<ArrayList<Integer>> grid,int[][]dst, boolean[][]visited){
        Queue<int []>q = new LinkedList<>();
        visited[startY][startX] = true;
        dst[startY][startX] = 1;
        q.add(new int []{startY,startX});
        int []dy = {-1,0,1,0};
        int []dx = {0,-1,0,1};
        while(!q.isEmpty()){
            int []temp = q.poll();
            int ty = temp[0];
            int tx = temp[1];
            for(int i = 0;i<4;i++){
                int ny = ty + dy[i];
                int nx = tx + dx[i];
                if(ny>=0 && ny < n && nx >=0 && nx < m && grid.get(ny).get(nx) != 0 && !visited[ny][nx]){
                    dst[ny][nx] = dst[ty][tx] + 1;
                    visited[ny][nx] = true;
                    q.add(new int[]{ny,nx});
                }
            }
        }
        return dst[n-1][m-1];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        boolean [][]visited = new boolean[n][m];
        int [][]dst = new int[n][m];
        ArrayList<ArrayList<Integer>> grid = new ArrayList<>();
        for(int i = 0;i<n;i++){
            String str = br.readLine();
            ArrayList<Integer> list = new ArrayList<>();
            for(char c:str.toCharArray()){
                list.add(c-'0');
            }
            grid.add(list);
        }
        System.out.println(BFS(0,0,grid,dst,visited));
    }
}
