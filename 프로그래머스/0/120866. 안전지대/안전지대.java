import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int DangerAreaCnt = 0;
        int[]dy={-1,0,1,0,-1,1,1,-1};
        int[]dx={0,1,0,-1,-1,1,-1,1};
        boolean[][] checkedDangerArea;
        int n = board.length;
        int answer = n*n;
        checkedDangerArea = new boolean[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(board[i][j] == 1) {
                    checkedDangerArea[i][j] = true;
                    for(int r = 0;r < 8;r++){
                        int ny = i + dy[r];
                        int nx = j + dx[r];
                        if(ny >= 0 && ny < n && nx >= 0 && nx < n && !checkedDangerArea[ny][nx]){
                            checkedDangerArea[ny][nx] = true;
                        }
                    }
                }
            }
        }
        for(int i =0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(checkedDangerArea[i][j]) answer--;
            }
        }
        return answer;
    }
}