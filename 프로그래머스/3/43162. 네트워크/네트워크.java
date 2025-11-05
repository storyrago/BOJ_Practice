class Solution {
    static void dfs(int[][]computers,boolean[]checked, int start){
        if(checked[start]) return;
        checked[start]= true;
        for(int i = 0;i<computers[start-1].length;i++){
            if(computers[start-1][i] == 1 && !checked[i+1]){
                dfs(computers,checked,i+1);
            }
        }
    }
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[]checked = new boolean[n+1];
        for(int i = 1;i<=n;i++){
            if(!checked[i]){
                dfs(computers,checked,i);
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][]computers = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };
        System.out.println(solution(n,computers));
    }
}


