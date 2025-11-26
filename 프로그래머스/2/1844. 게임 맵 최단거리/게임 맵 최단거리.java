import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int []dy={-1,0,1,0};
    static int []dx={0,1,0,-1};
    public static void bfs(int[][]maps, boolean[][]visited,int[][]dst){
        Queue<int[]> q = new LinkedList<>();
        dst[0][0] = 1;
        visited[0][0] = true;
        q.add(new int[]{0,0});
        while(!q.isEmpty()){
            int []temp = q.poll();
            int y = temp[0];
            int x = temp[1];
            for(int i = 0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny >= 0 && ny < maps.length && nx >= 0 && nx < maps[0].length && maps[ny][nx] == 1 && !visited[ny][nx]){
                    dst[ny][nx] = dst[y][x] + 1;
                    visited[ny][nx] = true;
                    q.add(new int[]{ny,nx});
                }
            }
        }
    }
    public int solution(int[][] maps) {
        int answer = 0;
        int[][]dst = new int[maps.length][maps[0].length];
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        bfs(maps,visited,dst);
        answer = dst[maps.length-1][maps[0].length-1] == 0?-1:dst[maps.length-1][maps[0].length-1];
        return answer;
    }
}