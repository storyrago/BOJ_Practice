import java.io.*;
import java.util.*;
public class Main {
	public static int bfs(int starty,int startx, int[][]board, boolean[][] visited) {
		if(board[starty][startx] == 0 || visited[starty][startx]) {
			return 0;
		}
		int cnt = 0;
		Queue<int []> q = new LinkedList<>();
		q.add(new int[] {starty,startx});
		visited[starty][startx] = true;
		int []dy = {-1,0,1,0};
		int []dx = {0,1,0,-1};
		while(!q.isEmpty()) {
			int[] temp = q.poll(); // q의 맨 앞 값 추출 (q 선언 형태 조심할 것)
			int cy = temp[0];
			int cx = temp[1];
			cnt++;
			for(int i =0;i<4;i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];
				if(ny >= 0 && ny <board.length && nx >=0 && nx < board[0].length&&!visited[ny][nx] && board[ny][nx] == 1) { 
					q.add(new int [] {ny,nx});
					visited[ny][nx] = true; // 이거 조심 (없으면 무한 루프)
				}
			}
		}
		return cnt;
		
	}
	
	public static void main(String[]args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][]board = new int[N][M];
		boolean[][]visited = new boolean[N][M];
		int y,x;
		for(int i = 0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken()) - 1;
			x = Integer.parseInt(st.nextToken()) - 1;
			board[y][x] = 1;	
		}
		int ans = 0;
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				int size = bfs(i,j,board,visited);
				if(size > ans) ans = size;
			}
		}
		System.out.println(ans);
	}
}
