import java.util.*;
import java.io.*;

class Solution {
    int bfs(ArrayList<Integer>[]list,int []dist,int start){
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(dist,-1);
        int maxCnt = 0;
        q.add(start);
        dist[start] = 0;
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int i = 0;i<list[temp].size();i++){
                int temp2 = list[temp].get(i);
                if(dist[temp2] == -1){
                    q.add(temp2);
                    dist[temp2] = dist[temp] + 1;
                }
            }
        }
        int maxValue = 0;
        for(int i: dist){
            if(i > maxValue){
                maxValue = i;
            }
        }
        for(int i: dist){
            if(i == maxValue){
                maxCnt++;
            }
        }
        return maxCnt;
    }
    public int solution(int n, int[][] edge) {
        ArrayList<Integer>[]list = new ArrayList[n+1];
        for(int i = 1;i<n+1;i++){
            list[i] = new ArrayList<>();
        }

        int[]dist = new int[n+1];
        int answer = 0;
        for(int i = 0;i<edge.length;i++){
            list[edge[i][0]].add(edge[i][1]);
            list[edge[i][1]].add(edge[i][0]);
        }
        answer=  bfs(list,dist,1);
        return answer;
    }
}